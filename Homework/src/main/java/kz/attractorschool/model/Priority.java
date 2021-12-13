package kz.attractorschool.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
    High("Высокий"),
    Average("Средний"),
    Short("Низкий");

    private String call;
}
