package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @RequestMapping({ "/", "/home" })
    public String display() {
        return "home";
    }

    @RequestMapping("/createDictionary")
    public String createDictionary() {
        return "createDictionary";
    }

    @RequestMapping("/dictionaryList")
    public String dictionaryList() {
        return "dictionaryList";
    }

    /* @RequestMapping("/notesList")
    public String dictionariesPage() {
        return "list";
    }

    @RequestMapping("/dictionaries//notes")
    public String notes() {
        return "notes";
    }*/

}
