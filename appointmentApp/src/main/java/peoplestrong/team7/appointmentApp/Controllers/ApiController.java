package peoplestrong.team7.appointmentApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peoplestrong.team7.appointmentApp.Exception.UserAlreadyExistsException;
import peoplestrong.team7.appointmentApp.Models.*;
import peoplestrong.team7.appointmentApp.Repository.*;
import peoplestrong.team7.appointmentApp.Services.BusinessService;
import peoplestrong.team7.appointmentApp.Services.RegistrationService;

import javax.print.attribute.standard.PageRanges;
import java.awt.print.Pageable;
import java.security.Principal;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private RegistrationService regstService;

    LocalDateTime localDateTime=LocalDateTime.now();
    Time time= new Time(23);

    User user=new User("vijay","yadav","vijay@gmail.com","vijay123","987654321",false, localDateTime,false,"image",false);
    Categories category= new Categories(1123,"Saloon");
    List<BusinessWorkingHours> workingHours=new ArrayList<>();

    BusinessAddress address= new BusinessAddress("249 MG road","indore","451335","MP","INDIA",23.45,54.32);
    Business business = new Business("motocorp","vehicle design","MOTOG","987654321","motog@gmail.com",true,2,"MAle","images",category,user,workingHours,address);
    Services service=new Services("Saloon","hair cut",200,business);
    Payments payment=new Payments("UPI",localDateTime,200,null);
    Appointment appointment= new Appointment(localDateTime,localDateTime,time,"active",false,"reason",user,business,service,payment);
    Comments comments=new Comments(appointment,user,"nice",4);

    @GetMapping ("/add")
    public List<User> addData(){
        List<User> users=new ArrayList<>();
        users=  userRepository.getAllUser();
        return users;
    }


    @GetMapping(value = "/")
    public ModelAndView viewHomePage() {
        ModelAndView modelAndView = new ModelAndView("index.html");
        return modelAndView;
    }

    @GetMapping(value = "/register")
    public String signUpForm(Model model) {
        model.addAttribute(new User());
        return "SignupForm";
    }

    @RequestMapping(value = "/processRegistration", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> processRegistration(@RequestBody User user) throws UserAlreadyExistsException {
            String msg = regstService.processRegistration(user);
            return ResponseEntity.ok(msg);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User oAuthUser = userRepository.findByEmail(user.getEmail()).get();
//        System.out.println(oAuthUser.getPassword() + " && " + user.getPassword() );
        if(oAuthUser == null) {
            return "Invalid Credentials";
        }else{
            if(user.getUserPassword().contentEquals(oAuthUser.getUserPassword())) {
                return "Login Successful";
            }else{
                return "Invalid Credentials";
            }
        }
    }


    //business registration
   /* @GetMapping("/signupBusiness")
    public String businessRegisterPage(Model model)
    {
      //  model.addAttribute("title","Register for Business");
        model.addAttribute("business",new Business());
        return "RegisterBusiness";
    }

    //handler for registering business
  /*  @PostMapping("/do_register_business")
    public String registerBusiness(@ModelAttribute("business") Business business, Model model, HttpSession session){

        try {

            Business result=this.businessRepository.save(business);
            model.addAttribute("business",new Business());
            session.setAttribute("message",new Message("Successfully registered ","Alert-Success"));
            return "signUpPage";

        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("business",business);
            session.setAttribute("message",new Message("Something went wrong"+e.getMessage(),"Alert-Error"));
            return "signUpPage";
        }



        //return "signUP";
    }*/

  /*  @PostMapping("{userid}/do_register")
    public String registerBusiness(@PathVariable Long userid, @RequestBody Business business){
        return businessService.registerBusiness(userid, business);
    }
*/
    // dashboard for user

    @GetMapping("/login/{userid}/userDashboard")
    public User userDashboard( @PathVariable("userid") Long userid){
        User user= userRepository.findById(userid).get();
        String userName = user.getFirstname()+user.getLastname();
        System.out.println("USERNAME"+userName);

        // getting user details
        Date date =new Date();
        user.totalAppointmentDetails = appointmentsRepository.TotalAppointmentByUserid(userid);
        user.upcomingAppointmentDetails = appointmentsRepository.getUpcomingAppointments(userid,date);
        user.totalAppointments=user.totalAppointmentDetails.size();
        user.upcomingAppointments=user.upcomingAppointmentDetails.size();
        user.totalReviews = commentRepository.getTotalReviews(userid);
        //user.favourites = commentRepository.getFavourites(userid);


        //Pageable pageable = (Pageable) PageRequest.of(0,3);
        user.saloonServices = serviceRepository.getByServiceNameOrderByServicePriceAsc("Saloon");
        user.doctorServices = serviceRepository.getByServiceNameOrderByServicePriceAsc("Doctor");
        user.restaurantServices  =serviceRepository.getByServiceNameOrderByServicePriceAsc("Restaurant");


        System.out.println("USER"+user);
        //model.addAttribute("user",user);
        return user;
    }

    // admin dashboard
    @GetMapping("/admin_dashboard")
    public Admin adminDashboard(){
        Admin admin= new Admin();
        admin.users= userRepository.getAllUser();
        admin.businesses = businessRepository.getAllBusiness();
        admin.appointments= appointmentsRepository.getAllAppointments();
        admin.payments= paymentRepository.getAllPayments();
        admin.totalUsers=userRepository.countTotalUser();
        admin.newUsersThisWeek= userRepository.countTotalUserByThisWeek();
        admin.totalBusinesses= businessRepository.countTotalBusiness();
        admin.newBusinessesToday = businessRepository.countBusinessesToday();
        admin.totalRevenue = paymentRepository.countTotalRevenue();
        admin.revenueThisWeek = paymentRepository.countRevenueThisWeek();
        return admin;
    }

    // business details
    @GetMapping("/Business_details")
    public List<Business> businessDetails(){
        List<Business> businesses = new ArrayList<>();
        businesses = businessRepository.getAllBusiness();
        return businesses;

    }



}
