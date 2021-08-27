package app.controllers;

import app.entities.Dictionary;
import app.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dictionaries")
public class DictionaryController {

    @Autowired private DictionaryService dictionaryService;

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createDictionary(Model model) {
        model.addAttribute(new Dictionary());
        return "dictionaries/add";
    }

    @RequestMapping(method = RequestMethod.GET, params = "show")
    public ModelAndView showDictionaries() {
        List<Dictionary> dictionaries = dictionaryService.getDictionaries();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dictionaries/show");
        modelAndView.addObject("dictionaries", dictionaries);
        return modelAndView;
    }

    /*@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},
                    path = "/createDictionary")
    public ModelAndView allDictionaries() {
        List<Dictionary> dictionaries = dictionaryService.getDictionaries();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("template");
        modelAndView.addObject("dictionariesList", dictionaries);
        return modelAndView;
    }*/

}