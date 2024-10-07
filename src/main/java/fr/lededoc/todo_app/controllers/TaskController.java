package fr.lededoc.todo_app.controllers;

import fr.lededoc.todo_app.api.TaskApi;
import fr.lededoc.todo_app.dtos.TaskDto;
import fr.lededoc.todo_app.mappers.TaskMapper;
import fr.lededoc.todo_app.repositories.TaskRepository;
import fr.lededoc.todo_app.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController implements TaskApi {

    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public TaskController(TaskRepository taskRepository, TaskService taskService) {
        this.taskRepository = taskRepository;
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
        return null;
    }

    @Override
    public ResponseEntity<TaskDto> updateTask(Integer id, TaskDto taskDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteTask(Integer id) {
        return null;
    }
}
