package app.entities;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToMany(mappedBy = "dictionaryKey", fetch = FetchType.EAGER)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "condition")
    private String condition;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;

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
