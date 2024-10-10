package fr.lededoc.todo_app.dtos;

import io.swagger.v3.oas.annotations.media.ExampleObject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TaskDto implements Serializable {
    private Integer id;
    private String label;
    private Boolean isDone;
    private Date creationDate;
    private List<TaskDto> subTasks;

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setSubTasks(List<TaskDto> subTasks) {
        this.subTasks = subTasks;
    }

    public List<TaskDto> getSubTasks() {
        return subTasks;
    }
}
