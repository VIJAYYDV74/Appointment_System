package peoplestrong.team7.appointmentApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peoplestrong.team7.appointmentApp.Exception.UserAlreadyExistsException;
import peoplestrong.team7.appointmentApp.Models.User;
import peoplestrong.team7.appointmentApp.Repository.UserRepository;
import peoplestrong.team7.appointmentApp.Services.RegistrationService;

@RestController
public class ApiController {

    @Autowired
    private UserRepository userRepository;

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
    @CrossOrigin(origins = "localhost:8080")
    public ResponseEntity<String> processRegistration(@RequestBody User user) throws UserAlreadyExistsException {
            String msg = regstService.processRegistration(user);
            return ResponseEntity.ok(msg);
    }

}
