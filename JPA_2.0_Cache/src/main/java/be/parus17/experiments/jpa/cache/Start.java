package be.parus17.experiments.jpa.cache;

import be.parus17.experiments.jpa.cache.domain.Person;
import be.parus17.experiments.jpa.cache.service.PersonService;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;

import javax.persistence.EntityManagerFactory;

/**
 * Created with IntelliJ IDEA.
 * Person: Peter
 * Date: 29/09/12
 * Time: 19:04
 * To change this template use File | Settings | File Templates.
 */
public class Start {
    private static final Logger LOGGER = LoggerFactory.getLogger(Start.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");

        PersonService personService = context.getBean("personService", PersonService.class);

        Person verstrpe1 = personService.findPersonByUserName("verstrpe");
        Person verstrpe2 = personService.findPersonByUserName("verstrpe");

        EntityManagerFactoryInfo emfi = context.getBean("entityManagerFactory", EntityManagerFactoryInfo.class);
        EntityManagerFactoryImpl emf = (EntityManagerFactoryImpl) emfi.getNativeEntityManagerFactory();
        LOGGER.debug(emf.getSessionFactory().getStatistics().toString());
    }
}
