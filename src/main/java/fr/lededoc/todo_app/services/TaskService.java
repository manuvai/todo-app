package fr.lededoc.todo_app.services;

import fr.lededoc.todo_app.controllers.exceptions.EntityNotFound;
import fr.lededoc.todo_app.dtos.TaskDto;
import fr.lededoc.todo_app.mappers.TaskMapper;
import fr.lededoc.todo_app.models.Task;
import fr.lededoc.todo_app.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task findById(Integer id) {
        return id == null
                ? null
                : taskRepository.findById(id)
                        .orElseThrow(EntityNotFound::new);
    }

    public List<TaskDto> fetchAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper.INSTANCE::entityToDto)
                .toList();
    }

    public TaskDto fetchById(Integer id) {
        return id == null
                ? null
                : TaskMapper.INSTANCE.entityToDto(findById(id));
    }
}
