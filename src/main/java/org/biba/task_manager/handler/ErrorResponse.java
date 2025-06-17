package org.biba.task_manager.handler;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {

    private int errorCode;
    private String error;
    private String errorMessage;
    private LocalDateTime timestamp;
}
