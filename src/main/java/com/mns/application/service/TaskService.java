package com.mns.application.service;

import com.mns.application.model.Task;
import com.mns.application.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Integer id) {
        return taskRepository.findById(id).get();
    }

    public Task deleteById(Integer id) {
        Task task = taskRepository.findById(id).get();
        taskRepository.delete(task);
        return task;
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }






}
