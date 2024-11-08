package springboot.tp2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.tp2.Entity.Task;
import springboot.tp2.Repository.TaskRepository;
@Service
public class TaskService {
    

private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    //  nouvelle tache
    public Task createTask(Task task) {
        System.out.println("Adding task: " + task);

        return taskRepository.save(task);
    }

    // RECUPERONS  toutes les tache
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // RECUPERONS une tache par ID
    public Task getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    // Modifions une tache existante par ID
    public Task updateTask(Long id, Task updatedTask) {
        if (taskRepository.existsById(id)) {
            updatedTask.setId(id); 
            return taskRepository.save(updatedTask);
        }
        return null;
    }
    // Supprimons une tache par ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    

}

