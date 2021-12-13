package kz.attractorschool.utils;

import kz.attractorschool.model.Priority;
import kz.attractorschool.model.Task;
import kz.attractorschool.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.stream.Stream;

@Configuration
public class PreloadDatabaseWithData {
//    @Bean
//    CommandLineRunner initDatabase(TaskRepository repository) {
//
//        repository.deleteAll();
//
//        return (args) -> Stream.of(tasks())
//                .peek(System.out::println)
//                .forEach(repository::save);
//    }
//
//    private Task[] tasks() {
//        return new Task[]{
//                new Task(1, "Задача", LocalDateTime.now(),LocalDateTime.now(),"task description", Priority.valueOf("short")),
//                new Task(2,"Просмотр", LocalDateTime.now(),LocalDateTime.now(),"test description", Priority.valueOf("short")),
//                new Task(3,"Готовка", LocalDateTime.now(),LocalDateTime.now(),"test description", Priority.valueOf("short")),
//                new Task(4,"Чтение", LocalDateTime.now(),LocalDateTime.now(),"test description", Priority.valueOf("short")),
//                new Task(5,"Бег", LocalDateTime.now(),LocalDateTime.now(),"test description", Priority.valueOf("short")),
//                new Task(6,"Что-то еще", LocalDateTime.now(),LocalDateTime.now(),"test description", Priority.valueOf("short")),
//                new Task(7,"Поспать", LocalDateTime.now(),LocalDateTime.now(),"test description", Priority.valueOf("short"))};
//
//    }
}
