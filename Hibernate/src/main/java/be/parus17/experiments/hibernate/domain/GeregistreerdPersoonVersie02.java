package be.parus17.experiments.hibernate.domain;

import be.parus17.experiments.hibernate.util.IdGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class GeregistreerdPersoonVersie02 {
    @Id
    private String id = IdGenerator.createId();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "grp_versie_id")
    private Set<InszOpzoeking02> inszOpzoekingen = new TreeSet<InszOpzoeking02>();
    @OneToOne
    @JoinColumn(name = "laatste_insz_opzoeking_id")
    private InszOpzoeking02 laatsteOpzoeking;

    public Set<InszOpzoeking02> getInszOpzoekingen() {
        return inszOpzoekingen;
    }

    public void setInszOpzoekingen(Set<InszOpzoeking02> inszOpzoekingen) {
        this.inszOpzoekingen = inszOpzoekingen;
    }

    public InszOpzoeking02 getLaatsteOpzoeking() {
        return laatsteOpzoeking;
    }

    public void setLaatsteOpzoeking(InszOpzoeking02 laatsteOpzoeking) {
        this.laatsteOpzoeking = laatsteOpzoeking;
    }
}
