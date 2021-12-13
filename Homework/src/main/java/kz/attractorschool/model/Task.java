package kz.attractorschool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Task {
    @Id
    private Integer id;
    private String title;
    private LocalDateTime creationDate;
    private LocalDateTime openDate;
    private LocalDateTime closeData;
    private String description;
    private Priority priority;
    private String status;
    private String executor;

    public Task(Integer id, String title,
                String description, Priority priority, String executor) {
        this.id = id;
        this.title = title;
        this.creationDate = LocalDateTime.now();
        this.description = description;
        this.priority = priority;
        this.status = "Новая";
        this.executor = executor;
    }


}
