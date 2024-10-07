package fr.lededoc.todo_app.mappers;

import fr.lededoc.todo_app.dtos.TaskDto;
import fr.lededoc.todo_app.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    static TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto entityToDto(Task entity);
}
