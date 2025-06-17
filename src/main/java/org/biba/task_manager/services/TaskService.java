package org.biba.task_manager.services;

import lombok.RequiredArgsConstructor;
import org.biba.task_manager.dto.TaskCreateRequestDto;
import org.biba.task_manager.dto.TaskResponseDto;
import org.biba.task_manager.dto.TaskUpdateRequestDto;
import org.biba.task_manager.entities.TaskEntity;
import org.biba.task_manager.handler.TaskNotFoundException;
import org.biba.task_manager.mappers.TaskMapper;
import org.biba.task_manager.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;

    public List<TaskResponseDto> getTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .collect(Collectors.toList());
    }

    public TaskResponseDto getTaskById(UUID id) {
        return taskRepository.findById(id)
                .map(taskMapper::toResponse)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    public TaskResponseDto createTask(TaskCreateRequestDto newTask) {
        TaskEntity savedTask = taskRepository.save(taskMapper.toEntity(newTask));
        return taskMapper.toResponse(savedTask);
    }

    public TaskResponseDto updateTask(UUID id, TaskUpdateRequestDto updatedTask) {
        TaskEntity foundTask  = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        if (updatedTask.getTitle() != null) {
            foundTask.setTitle(updatedTask.getTitle());
        }
        if (updatedTask.getDescription() != null) {
            foundTask.setDescription(updatedTask.getDescription());
        }
        if (updatedTask.getStatus() != null) {
            foundTask.setTaskStatus(updatedTask.getStatus());
        }

        TaskEntity savedTask = taskRepository.save(foundTask);
        return taskMapper.toResponse(savedTask);
    }

    public void deleteTask(UUID id) {
        TaskEntity task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        taskRepository.delete(task);
    }
}
