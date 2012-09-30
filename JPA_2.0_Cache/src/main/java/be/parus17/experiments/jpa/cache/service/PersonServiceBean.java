package be.parus17.experiments.jpa.cache.service;

import be.parus17.experiments.jpa.cache.domain.Person;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Peter
 * Date: 30/09/12
 * Time: 09:23
 * To change this template use File | Settings | File Templates.
 */
@Named("personService")
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PersonServiceBean implements PersonService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person findPersonByUserName(String userName) {
        return entityManager.createQuery("select p from Person p where p.userName=:userName", Person.class)
                .setParameter("userName", userName)
                .setHint("org.hibernate.cacheable", true)
                .getSingleResult();
    }

}
