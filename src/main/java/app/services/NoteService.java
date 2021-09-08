package app.services;

import app.entities.Note;
import app.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private DictionaryService dictionaryService;

    @Transactional
    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    @Transactional
    public List<Note> getNotesForDictionary(Integer id) {
        return noteRepository.getNotesByDictionaryId(id);
    }

    @Transactional
    public Note getNote(Integer id) {
        return noteRepository.getById(id);
    }

    @Transactional
    public void removeNote(int id) { noteRepository.deleteById(id); }

    @Modifying
    @Transactional
    public boolean addNew(Note note) {
        if (!check(note)) return false;
        noteRepository.saveAndFlush(note);
        return true;
    }


    private boolean check(Note note) {
        Charset charset = StandardCharsets.UTF_8;
        String content = note.getText()
                + " "
                + note.getTranslate();
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buff = ByteBuffer.wrap(bytes);
        String condition = charset.decode(buff).toString();
        return condition.matches(note.getDictionary().getCondition());
    }
}
