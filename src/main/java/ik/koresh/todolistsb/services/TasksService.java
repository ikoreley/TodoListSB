package ik.koresh.todolistsb.services;


import ik.koresh.todolistsb.models.Task;
import ik.koresh.todolistsb.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class TasksService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Task> findAll(){
        return tasksRepository.findAll();
    }

    public Task findOne(int id){
        Optional<Task> foundTask = tasksRepository.findById(id);
        return foundTask.orElse(null);
    }

    @Transactional
    public void save(Task task){
        tasksRepository.save(task);
    }

    @Transactional
    public void update(int id, Task updateTask){
        updateTask.setId(id);
        tasksRepository.save(updateTask);
    }

    @Transactional
    public void delete(int id){
        tasksRepository.deleteById(id);
    }
}
