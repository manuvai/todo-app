package fr.lededoc.todo_app.dtos;

import java.io.Serializable;
import java.util.Date;

public class TaskDto implements Serializable {
    private Integer key;
    private String label;
    private Boolean isDone;
    private Date creationDate;

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

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }
}
