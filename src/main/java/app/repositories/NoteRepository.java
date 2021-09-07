package app.repositories;

import app.entities.Note;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    @Override
    void deleteById(@NotNull Integer id);

    List<Note> getNotesByDictionaryId(Integer dictionaryId);

    @Override
    <S extends Note> S save(S s);
}
