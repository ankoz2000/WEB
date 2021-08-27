package app.repositories;

import app.entities.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
    Dictionary findByName(String name);

    @Override
    List<Dictionary> findAll();

    @Override
    <S extends Dictionary> S save(S s);

}
