package org.biba.task_manager.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {

    private int errorCode;
    private String error;
    private String errorMessage;
    private Map<String, String> validationErrors;
    private LocalDateTime timestamp;
}
