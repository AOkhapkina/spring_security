package spring.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String infoForAllEmployees(){
        return "view_for_all_employee";
    }
    @GetMapping("/hr_info")
    public String getInfoForHR(){
        return "view_for_hr";
    }
    @GetMapping("/manager_info")
    public String getInfoForManager(){
        return "view_for_manager";
    }

}
