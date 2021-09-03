package app.repositories;

import app.entities.Dictionary;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
    Dictionary findByName(String name);

    @Override
    List<Dictionary> findAll();

    @Override
    <S extends Dictionary> S save(S s);

    @Override
    Dictionary getById(@NotNull Integer id);

}
