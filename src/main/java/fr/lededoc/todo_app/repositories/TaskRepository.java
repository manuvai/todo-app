package fr.lededoc.todo_app.repositories;

import fr.lededoc.todo_app.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
