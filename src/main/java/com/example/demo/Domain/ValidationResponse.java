package com.example.demo.Domain;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ValidationResponses")
public class ValidationResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "validation_response_seq")
    @SequenceGenerator(name = "validation_response_seq", sequenceName = "validation_response_sequence", allocationSize = 1)
    private Long response_id;
    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private ValidationQuestion question;
    @ManyToOne
    @JoinColumn(name = "responder_id", referencedColumnName = "user_id")
    private User responder;
    private String response_text;
    private Date response_date;
    private String status;

    public Long getResponse_id() {
        return response_id;
    }

    public void setResponse_id(Long response_id) {
        this.response_id = response_id;
    }

    public ValidationQuestion getQuestion() {
        return question;
    }

    public void setQuestion(ValidationQuestion question) {
        this.question = question;
    }

    public User getResponder() {
        return responder;
    }

    public void setResponder(User responder) {
        this.responder = responder;
    }

    public String getResponse_text() {
        return response_text;
    }

    public void setResponse_text(String response_text) {
        this.response_text = response_text;
    }

    public Date getResponse_date() {
        return response_date;
    }

    public void setResponse_date(Date response_date) {
        this.response_date = response_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}