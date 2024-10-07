package fr.lededoc.todo_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Task implements Serializable {
    @Id
    private Integer id;

    @Column
    private String label;
    @Column
    private Boolean isDone;
    @Column
    private Date creationDate;

    @OneToMany
    private List<Task> subTasks;

}
