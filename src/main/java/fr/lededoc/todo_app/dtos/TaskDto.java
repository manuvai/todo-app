package fr.lededoc.todo_app.dtos;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {
    private Integer id;
    private String label;
    private Boolean isDone;
    private Date creationDate;
}
