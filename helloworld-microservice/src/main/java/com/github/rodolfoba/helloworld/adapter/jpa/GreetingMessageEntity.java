package com.github.rodolfoba.helloworld.adapter.jpa;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "GreetingMessage")
@Table(name = "tb_greeting_message")
public class GreetingMessageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private UUID id;
    
    @Column(name = "text")
    private String message;
    
    public GreetingMessageEntity() {
        super();
    }
    
    public UUID getId() {
        return id;
    }
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}
