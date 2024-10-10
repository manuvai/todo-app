package fr.lededoc.todo_app.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TaskListDto implements Serializable {
    private Integer id;
    private String label;
    private List<TaskDto> tasks;

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

    public void setTasks(List<TaskDto> tasks) {
        this.tasks = tasks;
    }

    public List<TaskDto> getTasks() {
        return tasks;
    }
}
