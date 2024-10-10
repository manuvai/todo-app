package fr.lededoc.todo_app.services;

import fr.lededoc.todo_app.controllers.exceptions.EntityNotFound;
import fr.lededoc.todo_app.dtos.TaskListDto;
import fr.lededoc.todo_app.mappers.TaskListMapper;
import fr.lededoc.todo_app.models.TaskList;
import fr.lededoc.todo_app.repositories.TaskListRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TaskListService {
    private final TaskListRepository taskListRepository;

    public TaskListService(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    public List<TaskListDto> fetchAll() {
        return taskListRepository.findAll()
                .stream()
                .map(TaskListMapper.INSTANCE::entityToDto)
                .toList();
    }

    public List<TaskListDto> fetchAllByQuery(String q) {
        return q == null
                ? Collections.emptyList()
                : taskListRepository.findTaskListByLabelIsContainingIgnoreCase(q)
                        .stream()
                        .map(TaskListMapper.INSTANCE::entityToDto)
                        .toList();
    }

    public TaskListDto fetchById(Integer id) {
        TaskList taskList = findById(id);

        return taskList == null
                ? null
                : TaskListMapper.INSTANCE.entityToDto(taskList);
    }

    public TaskListDto create(TaskListDto taskListDto) {
        TaskList taskList = TaskListMapper.INSTANCE.dtoToEntity(taskListDto);

        if (taskList.getId() != null) {
            // TODO Throw an error
        }

        taskList = taskListRepository.save(taskList);

        return TaskListMapper.INSTANCE.entityToDto(taskList);
    }

    public TaskListDto update(TaskListDto taskListDto) {
        TaskList taskList = TaskListMapper.INSTANCE.dtoToEntity(taskListDto);
        taskList = taskListRepository.save(taskList);

        return TaskListMapper.INSTANCE.entityToDto(taskList);
    }

    public void delete(Integer id) {
        TaskList taskList = findById(id);

        taskListRepository.delete(taskList);

    }

    private TaskList findById(Integer id) {
        return id == null
                ? null
                : taskListRepository.findById(id)
                        .orElseThrow(EntityNotFound::new);
    }
}
