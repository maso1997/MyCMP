package com.example.demo.Domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="ValidationQuestions")

public class ValidationQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "validation_question_seq")
    @SequenceGenerator(name = "validation question_seq", sequenceName = "validation_question_sequence", allocationSize = 1)
    Long question_id;

    @ManyToOne
    @JoinColumn(name = "grid_id", referencedColumnName = "grid_id")

    private ValidationGrid validationGrid;
    private String question_text;
    private Date due_date;

    @ManyToOne
    @JoinColumn(name = "assigned_to_id", referencedColumnName = "user_id")
    private User assignedTo;

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public ValidationGrid getValidationGrid() {
        return validationGrid;
    }

    public void setValidationGrid(ValidationGrid validationGrid) {
        this.validationGrid = validationGrid;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(User assignedTo) {
        this.assignedTo = assignedTo;
    }
}