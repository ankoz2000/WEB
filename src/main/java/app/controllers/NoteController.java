package app.controllers;

import app.entities.Note;
import app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class NoteController {
    @Autowired
    private NoteService noteService;

    @RequestMapping(method = RequestMethod.GET, path = "/dictionaries/*/notes")
    public ModelAndView allNotes() {
        List<Note> notes = noteService.getNotes();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("notes");
        modelAndView.addObject("notesList", notes);
        return modelAndView;
    }
}
