package org.biba.task_manager.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.biba.task_manager.dto.TaskResponseDto;
import org.biba.task_manager.entities.TaskStatus;
import org.biba.task_manager.handler.TaskNotFoundException;
import org.biba.task_manager.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.UUID;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getTaskById_shouldReturnTask_whenTaskExists() throws Exception {

        UUID taskId = UUID.randomUUID();
        TaskResponseDto task = TaskResponseDto.builder()
                .id(taskId)
                .title("Test Title")
                .description("Test Description")
                .status(TaskStatus.COMPLETED)
                .build();

        when(taskService.getTaskById(taskId)).thenReturn(task);

        mockMvc.perform(get("/tasks/" + taskId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(taskId.toString()))
                .andExpect(jsonPath("$.title").value(task.getTitle()))
                .andExpect(jsonPath("$.description").value(task.getDescription()));
    }

    @Test
    public void getTaskById_shouldReturn404_whenTaskDoesNotExist() throws Exception {

        UUID taskId = UUID.randomUUID();

        when(taskService.getTaskById(taskId))
                .thenThrow(new TaskNotFoundException(taskId));

        mockMvc.perform(get("/tasks/" + taskId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.errorCode").value("404"))
                .andExpect(jsonPath("$.error").value("Not Found"))
                .andExpect(jsonPath("$.errorMessage").value("Task with id " + taskId + " not found"));
    }
}
