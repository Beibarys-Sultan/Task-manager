package org.biba.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.biba.task_manager.entities.TaskStatus;

@Data
public class TaskUpdateRequestDto {

    @NotBlank(message = "can not be blank")
    @Size(max = 100, message = "can not be greater than 100")
    private String title;
    private String description;
    private TaskStatus status;
}
