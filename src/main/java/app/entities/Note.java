package app.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {

    public Note(int id, String text) {
        this.text = text;
    }

    public Note() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "text")
    private String text;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "note")
    private List<Dictionary> dictionaries;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
