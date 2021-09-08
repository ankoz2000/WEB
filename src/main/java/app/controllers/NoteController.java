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

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(method = RequestMethod.GET, params = "new")
    public String createNote(Model model) {
        if (model == null) {
            model = (Model) new ModelAndView();
        }
        model.addAttribute(new Note());
        return "notes/add";
    }

    @RequestMapping(value = "/{dictionaryId}",
            method = RequestMethod.GET, params = "new")
    public String createNote(Model model, @PathVariable int dictionaryId) {
        if (model == null) {
            model = (Model) new ModelAndView();
        }
        Note note = new Note();
        note.setDictionary(dictionaryService.getDictionaryById(dictionaryId));
        model.addAttribute(note);
        return "notes/add";
    }

    @RequestMapping(value = "/{dictionaryId}",
            method = RequestMethod.POST,
            params = "new",
            produces = "application/json;charset=UTF-8")
    public String addNoteFromForm(@Validated Note note,
                                        @PathVariable int dictionaryId,
                                        BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "dictionaries/{dictionaryId}?new";
        Dictionary dictionary = dictionaryService.getDictionaryById(dictionaryId);
        note.setDictionary(dictionary);
        if(!noteService.addNew(note)) {
            return "redirect:/dictionaries/{dictionaryId}?new";
        }
        return "redirect:/dictionaries?show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{dictionaryId}", params = "get")
    public ModelAndView dictionaryNotes(@PathVariable Integer dictionaryId) {
        List<Note> notes = noteService.getNotesForDictionary(dictionaryId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes/show");
        modelAndView.addObject("notes", notes);
        modelAndView.addObject("dictionaryId", dictionaryId);
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST, path = "/{noteId}", params = "delete")
    public ModelAndView deleteNote(@PathVariable Integer noteId) {
        ModelAndView modelAndView = new ModelAndView();
        noteService.removeNote(noteId);
        modelAndView.setViewName("dictionaries/show");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{noteId}", params = "edit")
    public ModelAndView editNote(@PathVariable Integer noteId) {
        ModelAndView modelAndView = new ModelAndView();
        Note note = noteService.getNote(noteId);
        Integer dictionaryId = note.getDictionary().getId();
        note.setDictionary(dictionaryService.getDictionaryById(dictionaryId));
        modelAndView.setViewName("notes/edit");
        modelAndView.addObject("note", note);
        modelAndView.addObject("dictionaryId", dictionaryId);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/{noteId}/{dictionaryId}")
    public String addNoteFromForm(@Validated Note note,
                                        @PathVariable Integer noteId,
                                        @PathVariable Integer dictionaryId,
                                        BindingResult bindingResult)  {
        if(bindingResult.hasErrors()) return "dictionaries/show";
        note.setDictionary(dictionaryService.getDictionaryById(dictionaryId));
        note.setId(noteId);
        noteService.addNew(note);
        return "redirect:/dictionaries?show";
    }
}
