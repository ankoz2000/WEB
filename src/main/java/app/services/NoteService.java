package app.services;

import app.entities.Note;
import app.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Transactional
    public void removeNote(int id) { noteRepository.deleteById(id); }

    @Modifying
    @Transactional
    public void addNew(Note note) { noteRepository.save(note); }
    /*@Transactional
    public List<Note> getNotesForDictionary(int id) {
        return noteRepository.findAll((Note note) -> {
            return note.getDictionaryKey() == id;
        });
    }*/
}
