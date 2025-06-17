package org.biba.task_manager.mappers;

import org.biba.task_manager.dto.TaskCreateRequestDto;
import org.biba.task_manager.dto.TaskResponseDto;
import org.biba.task_manager.entities.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskEntity toEntity(TaskCreateRequestDto taskCreateRequestDto) {
        return TaskEntity.builder()
                .title(taskCreateRequestDto.getTitle())
                .description(taskCreateRequestDto.getDescription())
                .taskStatus(taskCreateRequestDto.getStatus())
                .build();
    }

    public TaskResponseDto toResponse(TaskEntity taskEntity) {
        return TaskResponseDto.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getTaskStatus())
                .createdAt(taskEntity.getCreatedAt())
                .updatedAt(taskEntity.getUpdatedAt())
                .build();
    }
}
