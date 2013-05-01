package be.parus17.experiments.hibernate.domain;

import be.parus17.experiments.hibernate.util.IdGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class GeregistreerdPersoon02 implements Serializable {
    @Id
    private String id = IdGenerator.createId();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "entiteit_id", nullable = false)
    private Set<GeregistreerdPersoonVersie02> versies = new TreeSet<GeregistreerdPersoonVersie02>();
    @OneToOne
    @JoinColumn(name = "huidige_versie_id")
    private GeregistreerdPersoonVersie02 huidigeVersie;

    public synchronized void addVersie(GeregistreerdPersoonVersie02 versie) {
        this.huidigeVersie = versie;
        this.versies.add(versie);
    }
}
