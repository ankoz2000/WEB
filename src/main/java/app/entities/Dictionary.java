package app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dictionaries")
public class Dictionary {

    public Dictionary(String name, String condition) {
        this.name = name;
        this.condition = condition;
    }

    public Dictionary(String name) {
        this.name = name;
    }

    public Dictionary() {
    }

    @Id
    @Column(name = "id")
    @SequenceGenerator(name="seq",sequenceName="hibernate_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@OneToMany(mappedBy = "dictionaryKey", fetch = FetchType.EAGER)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "condition")
    private String condition;

    @OrderBy("notes.id ASC")
    @OneToMany(mappedBy = "dictionary", fetch = FetchType.LAZY)
    private List<Note> note;

    public List<Note> getNote() {
        return note;
    }

    public void setNote(List<Note> note) {
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Dictionary get() {
        return new Dictionary();
    }

    @Override
    public String toString() {
        return String.format(
                "Dictionary[id=%d, name='%s', condition='%s']",
                id, name, condition);
    }
}
