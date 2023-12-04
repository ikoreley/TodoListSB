package ik.koresh.todolistsb.util;

import ik.koresh.todolistsb.models.Task;
import ik.koresh.todolistsb.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TaskValidator implements Validator {
    private final TasksService tasksService;

    @Autowired
    public TaskValidator(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Task.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Task task = (Task) target;
        Task taskBD = tasksService.findOne(task.getDescription());
        if (taskBD != null && task.getId() != taskBD.getId()){
            errors.rejectValue("description", "", "This description is already taken");
        }

    }
}
