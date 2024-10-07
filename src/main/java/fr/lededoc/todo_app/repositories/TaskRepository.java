package fr.lededoc.todo_app.repositories;

import fr.lededoc.todo_app.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
