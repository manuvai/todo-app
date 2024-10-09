package fr.lededoc.todo_app.mappers;

import fr.lededoc.todo_app.dtos.TaskDto;
import fr.lededoc.todo_app.models.Task;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    @Mapping(source = "id", target = "key")
    @Mapping(source = "label", target = "label")
    TaskDto entityToDto(Task entity);

    @InheritInverseConfiguration
    Task dtoToEntity(TaskDto dto);
}
