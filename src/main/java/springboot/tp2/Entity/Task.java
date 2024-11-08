package springboot.tp2.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "La description ne peut pas être vide")
    @Size(max = 255, message = "La description ne peut pas dépasser 255 caractères")
    private String description;

    @NotNull(message = "La date de création ne peut pas être nulle")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @NotNull(message = "La date d'échéance ne peut pas être nulle")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public Task(Long id, String description, Date creationDate, Date dueDate) {
        this.id = id;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public Task() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
