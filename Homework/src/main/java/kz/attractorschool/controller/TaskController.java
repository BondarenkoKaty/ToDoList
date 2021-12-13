package kz.attractorschool.controller;

import kz.attractorschool.dto.TaskDTO;
import kz.attractorschool.model.Priority;
import kz.attractorschool.model.SortDirection;
import kz.attractorschool.model.Task;
import kz.attractorschool.repository.TaskRepository;
import kz.attractorschool.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public String productsHandle(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "to_do_list";
    }

//    /add_task

    @GetMapping("/add_task")
    public String getPageAddTask(Model model) {
        model.addAttribute("priority", List.of(Priority.values()));
        return "add_task";
    }

//    /sort_task_name

//    @GetMapping("/sort_task_name")
//    public String sortTaskAsc(Model model,
//                              @RequestParam( defaultValue = "SortByNameAsc", required = false) SortDirection order) {
//        taskService.getSort(order);
//        List<Task> tasks = taskService.getTasks();
//        model.addAttribute("order", taskService.switchOrder(order));
//        model.addAttribute("tasks", tasks);
//        return "to_do_list";
//    }

    @PostMapping("/add_task")
    public String addTask(TaskDTO dto){
        taskService.add(dto);
        return "redirect:/";

    }

    @GetMapping ("task/{id}/")
    public String getPageDetails(Model model, @PathVariable Integer id){
        model.addAttribute("task", taskService.taskDetails(id));
        return "details_task";
    }

//    /task/${task.id}/close

    @PostMapping("/task/{id}/close")
    public String close(@PathVariable Integer id){
        taskService.closeTask(id);
        return "redirect:/";
    }

    @PostMapping("/task/{id}/open")
    public String open(@PathVariable Integer id){
        taskService.openTask(id);
        return "redirect:/";
    }

//    /task/${task.id}/remove
    @PostMapping("/task/{id}/remove")
    public String removeTask(@PathVariable Integer id){
        taskService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/sort_task_name")
    public String getSort(@RequestParam(defaultValue = "SortByTitleAsc", required = false)SortDirection sort,
                              @RequestParam(defaultValue = "1",required = false) int page, Model model){
        int currentPage = page - 1;
        if (currentPage < 0){
            currentPage = 0;
        }
        var sortObject = taskService.getSort(sort);
        Pageable pageable = PageRequest.of(currentPage,5, sortObject);
        var tasks = taskService.findAll(pageable);
        model.addAttribute("tasks",tasks.toList());
        model.addAttribute("sort", sort);
//        model.addAttribute("tasks",tasks);

        model.addAttribute("hasNext", tasks.hasNext());
        model.addAttribute("hasPrevious", tasks.hasPrevious());


        return "to_do_list";
    }
}
