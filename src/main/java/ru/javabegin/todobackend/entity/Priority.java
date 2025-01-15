package ru.javabegin.todobackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "priority", schema = "todolist", catalog = "javabeginhiber")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Priority {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @Column(name = "color", nullable = false, length = -1)
    private String color;

//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private UserDataEntity user;

    @OneToMany(mappedBy = "priority", fetch = FetchType.LAZY)
    private List<Task> tasks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Priority that = (Priority) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
