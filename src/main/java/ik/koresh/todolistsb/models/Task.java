package ik.koresh.todolistsb.models;


import ik.koresh.todolistsb.util.StartSymbolUpperCase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Description should be between 2 and 30 characters")
    @Column(name = "description")
    @StartSymbolUpperCase
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Min(value = 0, message = "Age should be greater than 0")
    @Column(name = "deadline")
    private int deadline;

    public Task() {}

    public Task(String description, Status  status, int deadline) {
        this.description = description;
        this.status = status;
        this.deadline = deadline;
    }
}
