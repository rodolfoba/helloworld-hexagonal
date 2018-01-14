package com.github.rodolfoba.helloworld.adapter.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.github.rodolfoba.helloworld.domain.GreetingMessage;
import com.github.rodolfoba.helloworld.domain.GreetingMessageId;
import com.github.rodolfoba.helloworld.domain.GreetingRepository;

public class JpaGreetingRepository implements GreetingRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<GreetingMessage> findAllMessages() {
        String jpql = "select this from GreetingMessage this";
        TypedQuery<GreetingMessageEntity> query = em.createQuery(jpql, GreetingMessageEntity.class);
        
        List<GreetingMessage> messages = new ArrayList<>();
        for (GreetingMessageEntity entity : query.getResultList()) {
            messages.add(new GreetingMessage(new GreetingMessageId(UUID.fromString(entity.getId())), entity.getMessage()));
        }
        
        return messages;
    }

}
