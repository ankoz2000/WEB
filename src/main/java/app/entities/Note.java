package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    public Note(int id, String text, int dictionaryKey) {
        this.text = text;
        this.dictionaryKey = dictionaryKey;
    }

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notes")
    private int dictionaryKey;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getDictionaryKey() {
        return dictionaryKey;
    }

    public void setDictionaryKey(int dictionaryKey) {
        this.dictionaryKey = dictionaryKey;
    }
}
