package app.services;

import app.entities.Dictionary;
import app.repositories.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DictionaryService {

    @Autowired private DictionaryRepository dictionaryRepository;

    @Transactional
    public List<Dictionary> getDictionaries() {
        return dictionaryRepository.findAll();
    }

    @Transactional
    public void addDictionary(Dictionary dictionary) { dictionaryRepository.save(dictionary); }
}
