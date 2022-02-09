package peoplestrong.team7.appointmentApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peoplestrong.team7.appointmentApp.Exception.UserAlreadyExistsException;
import peoplestrong.team7.appointmentApp.Models.Business;
import peoplestrong.team7.appointmentApp.Models.User;
import peoplestrong.team7.appointmentApp.Repository.BusinessRepository;
import peoplestrong.team7.appointmentApp.Repository.UserRepository;
import peoplestrong.team7.appointmentApp.Services.RegistrationService;
import peoplestrong.team7.appointmentApp.helper.Message;

import javax.servlet.http.HttpSession;

@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BusinessRepository businessRepository;

    @Autowired
    private RegistrationService regstService;

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
            if(user.getPassword().contentEquals(oAuthUser.getPassword())) {
                return "Login Successful";
            }else{
                return "Invalid Credentials";
            }
        }
    }


    //business registration
    @GetMapping("/signupBusiness")
    public String businessRegisterPage(Model model)
    {
      //  model.addAttribute("title","Register for Business");
        model.addAttribute("business",new Business());
        return "RegisterBusiness";
    }

    //handler for registering business
    @PostMapping("/do_register")
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
    }

}
