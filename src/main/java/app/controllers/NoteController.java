package app.controllers;

import app.entities.Note;
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

    @RequestMapping(value = "/{dictionaryId}", method = RequestMethod.GET, params = "new")
    public String createNote(Model model, @PathVariable int dictionaryId) {
        if (model == null) {
            model = (Model) new ModelAndView();
        }
        model.addAttribute(new Note());
        return "notes/add";
    }

    @RequestMapping(value = "/{dictionaryId}", method = RequestMethod.POST, params = "new")
    public String addNoteFromForm(@Validated Note note,
                                        @PathVariable int dictionaryId,
                                        BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "dictionaries/{dictionaryId}?new";
        note.setDictionaryKey(dictionaryId);
        noteService.addNew(note);
        return "redirect:/dictionaries?show";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/*/notes")
    public ModelAndView allNotes() {
        List<Note> notes = noteService.getNotes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("notesList", notes);
        return modelAndView;
    }
}
