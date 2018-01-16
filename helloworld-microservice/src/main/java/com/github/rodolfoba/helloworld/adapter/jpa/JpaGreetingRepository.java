package com.github.rodolfoba.helloworld.adapter.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.github.rodolfoba.helloworld.domain.Greeting;
import com.github.rodolfoba.helloworld.domain.GreetingMessage;
import com.github.rodolfoba.helloworld.domain.GreetingMessageId;
import com.github.rodolfoba.helloworld.domain.GreetingRepository;

@Stateless
public class JpaGreetingRepository implements GreetingRepository {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<GreetingMessage> findAllMessages() {
        String jpql = "select this from GreetingMessage this";
        TypedQuery<GreetingMessageEntity> query = em.createQuery(jpql, GreetingMessageEntity.class);
        
        List<GreetingMessage> messages = new ArrayList<>();
        for (GreetingMessageEntity entity : query.getResultList()) {
            messages.add(new GreetingMessage(new GreetingMessageId(entity.getId()), entity.getMessage()));
        }
        
        return messages;
    }

    @Transactional
    @Override
    public void register(Greeting greeting) {
        GreetingEntity entity = new GreetingEntity();
        entity.setGreetingMessage(em.find(GreetingMessageEntity.class, greeting.getMessage().getId().getValue()));
        entity.setVisitorIP(greeting.getVisitor().getIp());
        entity.setVisitorUserAgent(greeting.getVisitor().getUserAgent());
        em.persist(entity);
    }

}
