package fr.lededoc.todo_app.controllers;

import fr.lededoc.todo_app.api.TaskListApi;
import fr.lededoc.todo_app.dtos.TaskListDto;
import fr.lededoc.todo_app.services.TaskListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskListController implements TaskListApi {

    private TaskListService taskListService;

    public TaskListController(TaskListService taskListService) {
        this.taskListService = taskListService;
    }

    @Override
    public ResponseEntity<List<TaskListDto>> getTaskLists(String q) {
        List<TaskListDto> taskListDtoList = q == null
                ? taskListService.fetchAll()
                : taskListService.fetchAllByQuery(q);

        return ResponseEntity.ok(taskListDtoList);
    }

    @Override
    public ResponseEntity<TaskListDto> getTaskList(Integer id) {
        TaskListDto taskListDto = taskListService.fetchById(id);

        return ResponseEntity.ok(taskListDto);
    }

    @Override
    public ResponseEntity<Void> createTaskList(TaskListDto taskListDto) {

        taskListService.create(taskListDto);

        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<TaskListDto> updateTaskList(Integer id, TaskListDto taskListDto) {

        // TODO Check identifiant

        TaskListDto updatedTaskListDto = taskListService.update(taskListDto);

        return ResponseEntity.ok(updatedTaskListDto);
    }

    @Override
    public ResponseEntity<Void> deleteTask(Integer id) {

        taskListService.delete(id);

        return ResponseEntity.ok(null);
    }
}
