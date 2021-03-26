package data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "public.rubric")
public class Rubric implements Serializable {
    @Id
    private Integer id;
    private String name;

    public Rubric() {
    }

    public Rubric(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rubric rubric = (Rubric) o;
        return Objects.equals(id, rubric.id) && Objects.equals(name, rubric.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Rubric{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}