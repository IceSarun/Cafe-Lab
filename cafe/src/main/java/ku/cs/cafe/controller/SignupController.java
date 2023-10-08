package ku.cs.cafe.controller;
// 6410406878
// Sarunpawat Phosoi

//import ku.cs.cafe.entity.Member;
import ku.cs.cafe.model.SignupRequest;
import ku.cs.cafe.sevice.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    private SignupService signupService;
    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup"; // return หน้าฟอร์ม signup.html
    }


    @PostMapping("/signup") // รับเป็นโมเดลเข้ามา
    public String signupUser(@ModelAttribute SignupRequest user, Model model) {


        if (signupService.isUsernameAvailable(user.getUsername())) {
            // create when username available
            signupService.createUser(user);
            // show "Success" when available
            model.addAttribute("signupSuccess", true);
        } else {
            // show "Error" when not available
            model.addAttribute("signupError", "Username not available");
        }
        // return signup.html and show message
        return "signup";
    }

}
