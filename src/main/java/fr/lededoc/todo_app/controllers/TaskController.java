package fr.lededoc.todo_app.controllers;

import fr.lededoc.todo_app.api.TaskApi;
import fr.lededoc.todo_app.dtos.TaskDto;
import fr.lededoc.todo_app.mappers.TaskMapper;
import fr.lededoc.todo_app.repositories.TaskRepository;
import fr.lededoc.todo_app.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class TaskController implements TaskApi {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<TaskDto> taskDtoList = taskService.fetchAll();

        return ResponseEntity.ok(taskDtoList);
    }

    @Override
    public ResponseEntity<TaskDto> getTask(Integer id) {

        TaskDto taskDto = taskService.fetchById(id);

        return ResponseEntity.ok(taskDto);
    }

    @Override
    public ResponseEntity<Void> createTask(TaskDto taskDto) {
        TaskDto newTask = taskService.create(taskDto);

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Integer id, TaskDto taskDto) {

        // TODO Vérifier id
        TaskDto updatedDto = taskService.update(taskDto);

        return ResponseEntity.ok(updatedDto);
    }

    @Override
    public ResponseEntity<Void> deleteTask(Integer id) {

        taskService.delete(id);

        return ResponseEntity.ok(null);
    }
}
