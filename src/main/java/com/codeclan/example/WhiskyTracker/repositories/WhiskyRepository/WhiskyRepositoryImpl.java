package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.platform.commons.function.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import org.hibernate.HibernateException;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findWhiskiesFromDistilleryByWhiskyAge(Long id, int age) {
    List<Whisky> result = null;
    Session session = entityManager.unwrap(Session.class);


     try {
         Criteria cr = session.createCriteria(Whisky.class);
         cr.createAlias("distillery", "distilleryAlias");
         cr.add(Restrictions.eq("distilleryAlias.id", id));
         cr.add(Restrictions.eq("age", age));
         result = cr.list();
     }

        catch (HibernateException ex){
         ex.printStackTrace();
     }
        return result;
    }

    @Transactional
    public List<Whisky> findWhiskiesFromAParticularRegion (String region) {
        List<Whisky> result = null;
        Session session = entityManager.unwrap(Session.class);


        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.createAlias("distillery", "distilleryAlias");
            cr.add(Restrictions.eq("distilleryAlias.region", region ));
            result = cr.list();
        }

        catch (HibernateException ex){
            ex.printStackTrace();
        }
        return result;
    }



}
