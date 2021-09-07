package app.entities;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @JoinColumn(name = "dictionary", nullable = false)
    @ManyToOne(cascade = CascadeType.DETACH)
    private Dictionary dictionary;

    public Note() {

    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "translate")
    private String translate;

    @Transactional
    public Dictionary getDictionary() {
        return dictionary;
    }

    @Transactional
    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }
}
