package app.controllers;

import app.entities.Dictionary;
import app.entities.Note;
import app.services.DictionaryService;
import app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.PreRemove;
import java.util.List;

@Controller
@RequestMapping("/dictionaries")
public class DictionaryController {

    @Autowired private DictionaryService dictionaryService;
    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createDictionary(Model model) {
        if (model == null) {
            model = (Model) new ModelAndView();
        }
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

    @RequestMapping(method = RequestMethod.POST)
    public String addDictionaryFromForm(@Validated Dictionary dictionary,
                                        BindingResult bindingResult)  {
        if(bindingResult.hasErrors()) return "dictionaries/add";
        dictionaryService.addDictionary(dictionary);
        return "redirect:/dictionaries?show";
        //return "redirect:/dictionaries/" + dictionary.getName();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET, params = "new")
    public ModelAndView showDictionaryNotes(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(dictionaryService.getDictionaryById(id));
        String viewName = "redirect:/notes/{id}?new";
        modelAndView.setViewName(viewName);
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
