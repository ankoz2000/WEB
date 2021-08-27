package app.controllers;

import app.entities.Dictionary;
import app.services.DictionaryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.ModelAndViewResolver;

import java.util.List;

@Controller
public class DictionaryController {

    @Autowired private DictionaryService dictionaryService;

    /*@RequestMapping(method = RequestMethod.POST,
                    path = "/create")
    public ModelAndView createDictionary() {
        dictionaryService.addDictionary(dictionary);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dictionaries");
        modelAndView.addObject("dictionariesList", dictionary);
        return modelAndView;
    }*/

    @RequestMapping(method = RequestMethod.GET,
            path = "/createDictionary")
    public ModelAndView createDictionary() {

    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST},
                    path = "/createDictionary")
    public ModelAndView allDictionaries() {
        List<Dictionary> dictionaries = dictionaryService.getDictionaries();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("template");
        modelAndView.addObject("dictionariesList", dictionaries);
        return modelAndView;
    }

}
