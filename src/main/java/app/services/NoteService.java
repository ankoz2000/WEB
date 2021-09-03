package app.services;

import app.entities.Note;
import app.repositories.NoteRepository;
import com.sun.tools.javac.comp.Todo;
import org.glassfish.jaxb.core.v2.TODO;
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

    @Modifying
    @Transactional
    public void removeNote(int id) { noteRepository.deleteById(id); }

    @Modifying
    @Transactional
    public boolean addNew(Note note) {
        if (!check(note)) return false;
        noteRepository.save(note);
        return true;
    }

    private boolean check(Note note) {
        // TODO: 03.09.2021 Сделать изменение кодировки, т.к. при указании русских букв приходят некорректные символы 
        Charset charset = StandardCharsets.UTF_8;
        String content = note.getText()
                + " "
                + note.getTranslate();
        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);
        ByteBuffer buff = ByteBuffer.wrap(bytes);
        String condition = charset.decode(buff).toString();
        //String condition = new String(content.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        return condition.matches(note.getDictionary().getCondition());
    }
    /*@Transactional
    public List<Note> getNotesForDictionary(int id) {
        return noteRepository.findAll((Note note) -> {
            return note.getDictionaryKey() == id;
        });
    }*/
}
