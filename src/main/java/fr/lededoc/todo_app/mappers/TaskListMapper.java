package fr.lededoc.todo_app.mappers;

import fr.lededoc.todo_app.dtos.TaskListDto;
import fr.lededoc.todo_app.models.TaskList;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TaskMapper.class})
public interface TaskListMapper {

    TaskListMapper INSTANCE = Mappers.getMapper(TaskListMapper.class);

    TaskListDto entityToDto(TaskList entity);

    @InheritInverseConfiguration
    TaskList dtoToEntity(TaskListDto dto);
}
