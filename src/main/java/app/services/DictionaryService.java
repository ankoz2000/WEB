package app.services;

import app.entities.Dictionary;
import app.entities.Note;
import app.repositories.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DictionaryService {

    @Autowired private DictionaryRepository dictionaryRepository;
    @Autowired private NoteService noteService;

    @Transactional
    public List<Dictionary> getDictionaries() {
        return dictionaryRepository.findAll();
    }

    @Transactional
    public void addDictionary(Dictionary dictionary) { dictionaryRepository.save(dictionary); }

    @Transactional
    public Dictionary getDictionaryByName(String name) { return dictionaryRepository.findByName(name); }

    @Transactional
    public Dictionary getDictionaryById(int id) { return dictionaryRepository.getById(id); }
}
