package fr.lededoc.todo_app.services;

import fr.lededoc.todo_app.controllers.exceptions.EntityNotFound;
import fr.lededoc.todo_app.dtos.TaskDto;
import fr.lededoc.todo_app.mappers.TaskMapper;
import fr.lededoc.todo_app.models.Task;
import fr.lededoc.todo_app.repositories.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public TaskDto create(TaskDto dto) {
        Task task = TaskMapper.INSTANCE.dtoToEntity(dto);
        task.setCreationDate(new Date());

        Task newTask = taskRepository.save(task);

        return TaskMapper.INSTANCE.entityToDto(newTask);
    }

    public TaskDto update(TaskDto dto) {
        Task task = TaskMapper.INSTANCE.dtoToEntity(dto);

        Task taskToUpdate = findById(task.getId());
        populateUpdatedTask(taskToUpdate, task);

        taskToUpdate = taskRepository.save(taskToUpdate);

        return TaskMapper.INSTANCE.entityToDto(taskToUpdate);
    }

    public void delete(Integer id) {
        taskRepository.delete(findById(id));
    }

    public TaskDto fetchById(Integer id) {
        return id == null
                ? null
                : TaskMapper.INSTANCE.entityToDto(findById(id));
    }

    private static void populateUpdatedTask(Task taskToUpdate, Task task) {
        if (taskToUpdate == null || task == null) {
            return;
        }
        taskToUpdate.setDone(task.getDone());
        taskToUpdate.setLabel(task.getLabel());
        taskToUpdate.setSubTasks(task.getSubTasks());
    }
}
