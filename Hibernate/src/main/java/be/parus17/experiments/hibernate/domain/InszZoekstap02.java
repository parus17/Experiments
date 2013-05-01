package be.parus17.experiments.hibernate.domain;

import be.parus17.experiments.hibernate.util.IdGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InszZoekstap02 {
    @Id
    private String id = IdGenerator.createId();
}
