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
public class InszOpzoeking02 {
    @Id
    private String id = IdGenerator.createId();
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "insz_opzoeking_id")
    private Set<InszZoekstap02> versies = new TreeSet<InszZoekstap02>();
    @OneToOne
    @JoinColumn(name = "laatste_insz_zoekstap_id")
    private InszZoekstap02 laatsteZoekstap;

    public Set<InszZoekstap02> getVersies() {
        return versies;
    }

    public void setVersies(Set<InszZoekstap02> versies) {
        this.versies = versies;
    }

    public InszZoekstap02 getLaatsteZoekstap() {
        return laatsteZoekstap;
    }

    public void setLaatsteZoekstap(InszZoekstap02 laatsteZoekstap) {
        this.laatsteZoekstap = laatsteZoekstap;
    }
}
