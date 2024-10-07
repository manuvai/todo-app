package fr.lededoc.todo_app.api;

import fr.lededoc.todo_app.dtos.TaskDto;
import fr.lededoc.todo_app.models.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

public interface TaskApi {

    @GetMapping("/tasks")
    ResponseEntity<List<TaskDto>> getTasks();

    @GetMapping("/tasks/{id}")
    ResponseEntity<TaskDto> getTask(@PathVariable @NonNull Integer id);

    @PostMapping("/tasks")
    ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto);

    @PutMapping("/tasks/{id}")
    ResponseEntity<TaskDto> updateTask(
            @PathVariable @NonNull Integer id,
            @RequestBody TaskDto taskDto);

    @DeleteMapping("/tasks/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable @NonNull Integer id);
}
