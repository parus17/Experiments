package be.parus17.experiments.hibernate.domain;

import be.parus17.experiments.hibernate.util.IdGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class GeregistreerdPersoonVersie01 implements Serializable {
    @Id
    private String id = IdGenerator.createId();
    @ManyToOne
    @JoinColumn(name = "entiteit_id")
//    @Column(name = "entiteit_id")
    private GeregistreerdPersoon01 geregistreerdPersoon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GeregistreerdPersoon01 getGeregistreerdPersoon() {
        return geregistreerdPersoon;
    }

    public void setGeregistreerdPersoon(GeregistreerdPersoon01 geregistreerdPersoon) {
        this.geregistreerdPersoon = geregistreerdPersoon;
    }
}
