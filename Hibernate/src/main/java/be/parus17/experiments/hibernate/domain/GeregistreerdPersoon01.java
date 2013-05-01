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
public class GeregistreerdPersoon01 implements Serializable {
    @Id
    private String id = IdGenerator.createId();
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "geregistreerdPersoon")
    private Set<GeregistreerdPersoonVersie01> versies = new TreeSet<GeregistreerdPersoonVersie01>();
    @OneToOne
    @JoinColumn(name = "huidige_versie_id")
    private GeregistreerdPersoonVersie01 huidigeVersie;

    public synchronized void addVersie(GeregistreerdPersoonVersie01 versie) {
        versie.setGeregistreerdPersoon(this);
        this.huidigeVersie = versie;
        this.versies.add(versie);
    }
}
