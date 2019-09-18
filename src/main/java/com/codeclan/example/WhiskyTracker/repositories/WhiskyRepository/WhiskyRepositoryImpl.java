package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

//    @Transactional
//    public List<Whisky> findWhiskiesFromDistilleryByWhiskyAge(int age) {
//        List<Whisky> result = null;
//        Session session = entityManager.unwrap(Session.class);
//
//        Criteria cr = session.createCriteria(Whisky.class);
//        cr.createAlias("distilleries.whiskies", "distillerywhiskiesAlias");
//        cr.add(Restrictions.eq("whiskyAlias.age", age));
//        result = cr.list();
//
//        return result;
//    }





}
