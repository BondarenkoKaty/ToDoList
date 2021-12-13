package kz.attractorschool.service;

import kz.attractorschool.dto.TaskDTO;
import kz.attractorschool.model.Priority;
import kz.attractorschool.model.SortDirection;
import kz.attractorschool.model.Task;
import kz.attractorschool.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public void remove(int id){
        taskRepository.deleteById(id);
    }

    public List<Task> getTasks(){
        return (List<Task>)taskRepository.findAll();
    }

    public Page<Task> findAll(Pageable pageable){
        return taskRepository.findAll(pageable);
    }

    public int count(){
        if (taskRepository.count() == 0){
            return 1;
        }
        List<Task> taskList = (List<Task>) taskRepository.findAll();
        return taskList.get(taskList.size() - 1).getId() + 1;
    }


    public Task add(TaskDTO dto){
        Task task = new Task(count(), dto.getTitle(),dto.getDescription(), Priority.valueOf(dto.getPriority()), dto.getExecutor());
        taskRepository.save(task);
        return task;
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public Task taskDetails(int id){
        return taskRepository.findById(id).orElseThrow();
    }

    public Task closeTask(int id){
        Task task = taskDetails(id);
        task.setStatus("Закрытая");
        task.setCloseData(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Task openTask(int id){
        Task task = taskDetails(id);
        task.setStatus("Открыта");
        task.setOpenDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

//    public SortDirection switchOrder(SortDirection order){
//        switch (order){
//            case SortByNameAsc:
//                return SortDirection.SortByNameAsc;
//            default:
//                return SortDirection.SortByNameDesc;
//        }
//    }

    public Sort getSort(SortDirection sortDirection){
        switch (sortDirection){
            case SortByNameAsc:
                return Sort.by(Sort.Order.asc("title"));
            case SortByNameDesc:
                return Sort.by("title").descending();
            case SortByPriorityAsc:
                return  Sort.by("priority").ascending();
            case SortByPriorityDesc:
                return Sort.by("priority").descending();
            case SortByStatusAsc:
                return  Sort.by("status").ascending();
            case SortByStatusDesc:
                return Sort.by("status").descending();
            case SortByCreationDateAsc:
                return Sort.by("creationDate").ascending();
            case SortByCreationDateDesc:
                return Sort.by("creationDate").descending();
            default:
                return Sort.by("title").ascending();

        }
    }
}
