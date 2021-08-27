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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "dictionary_key")
    //@ManyToOne(optional = false, cascade = CascadeType.ALL)
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
