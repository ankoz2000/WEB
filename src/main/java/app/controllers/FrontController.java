package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @RequestMapping({ "/", "/home" })
    public String display() {
        return "forward:/dictionaries?show";
    }
}
