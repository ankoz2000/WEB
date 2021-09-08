package app.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "dictionaries")
@Proxy(lazy=false)
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
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "condition")
    private String condition;

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

    @Override
    public String toString() {
        return String.format(
                "Dictionary[id=%d, name='%s', condition='%s']",
                id, name, condition);
    }
}
