package app.services;

import app.entities.Note;
import app.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Transactional
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }
}
