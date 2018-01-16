package com.github.rodolfoba.helloworld.adapter.jpa;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Greeting")
@Table(name = "tb_greeting")
public class GreetingEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "greeting_message_id")
    private GreetingMessageEntity greetingMessage;

    @Column(name = "visitor_ip")
    private String visitorIP;

    @Column(name = "visitor_useragent")
    private String visitorUserAgent;

    @Column(name = "visit_time")
    private LocalDateTime visitTime;

    public GreetingEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GreetingMessageEntity getGreetingMessage() {
        return greetingMessage;
    }

    public void setGreetingMessage(GreetingMessageEntity greetingMessage) {
        this.greetingMessage = greetingMessage;
    }

    public String getVisitorIP() {
        return visitorIP;
    }

    public void setVisitorIP(String visitorIP) {
        this.visitorIP = visitorIP;
    }

    public String getVisitorUserAgent() {
        return visitorUserAgent;
    }

    public void setVisitorUserAgent(String visitorUserAgent) {
        this.visitorUserAgent = visitorUserAgent;
    }

}
