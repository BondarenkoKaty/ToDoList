package kz.attractorschool.dto;

import kz.attractorschool.model.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskDTO {
    private String title;
    private String description;
    private String priority;
    private String status;
    private String executor;
}
