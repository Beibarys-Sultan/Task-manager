package org.biba.task_manager.dto;

import lombok.Builder;
import lombok.Data;
import org.biba.task_manager.entities.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TaskResponseDto {

    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
