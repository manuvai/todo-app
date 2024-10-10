package fr.lededoc.todo_app.api;

import fr.lededoc.todo_app.dtos.TaskListDto;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskListApi {

    @GetMapping("/task-lists")
    ResponseEntity<List<TaskListDto>> getTaskLists(@RequestParam(name = "q", required = false) String q);

    @GetMapping("/task-lists/{id}")
    ResponseEntity<TaskListDto> getTaskList(@PathVariable @NonNull Integer id);

    @PostMapping("/task-lists")
    ResponseEntity<Void> createTaskList(@RequestBody TaskListDto taskListDto);

    @PutMapping("/task-lists/{id}")
    ResponseEntity<TaskListDto> updateTaskList(
            @PathVariable @NonNull Integer id,
            @RequestBody TaskListDto taskListDto);

    @DeleteMapping("/task-lists/{id}")
    ResponseEntity<Void> deleteTask(@PathVariable @NonNull Integer id);
}
