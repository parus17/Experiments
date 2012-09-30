package be.parus17.experiments.jpa.cache.service;

import be.parus17.experiments.jpa.cache.domain.Person;

import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: Peter
 * Date: 30/09/12
 * Time: 09:14
 * To change this template use File | Settings | File Templates.
 */
public interface PersonService {

    Person findPersonByUserName(String userName);

}
