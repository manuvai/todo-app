package fr.lededoc.todo_app.repositories;

import fr.lededoc.todo_app.models.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

    List<TaskList> findTaskListByLabelIsContainingIgnoreCase(String q);
}
