package be.parus17.experiments.hibernate;

import be.parus17.experiments.hibernate.domain.GeregistreerdPersoon02;
import be.parus17.experiments.hibernate.domain.GeregistreerdPersoonVersie02;
import be.parus17.experiments.hibernate.domain.InszOpzoeking02;
import be.parus17.experiments.hibernate.domain.InszZoekstap02;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

public class JPA02Test extends JPABaseTest {
    @Test
    public void testGeregistreerdPersoon01() throws Exception {
        GeregistreerdPersoon02 grp = new GeregistreerdPersoon02();
        GeregistreerdPersoonVersie02 grpv = new GeregistreerdPersoonVersie02();
        grp.addVersie(grpv);

//        InszOpzoeking02 inszOpzoeking = new InszOpzoeking02();
//        InszZoekstap02 inszZoekstap = new InszZoekstap02();
//        inszOpzoeking.getVersies().add(inszZoekstap);
//        inszOpzoeking.setLaatsteZoekstap(inszZoekstap);
//
//        grpv.getInszOpzoekingen().add(inszOpzoeking);
//        grpv.setLaatsteOpzoeking(inszOpzoeking);

        getEntityManager().persist(grp);
    }

//    @Test
    public void testGeregistreerdPersoon02() throws Exception {
        GeregistreerdPersoon02 grp = new GeregistreerdPersoon02();
        GeregistreerdPersoonVersie02 grpv = new GeregistreerdPersoonVersie02();
        grp.addVersie(grpv);

        InszOpzoeking02 inszOpzoeking = new InszOpzoeking02();
        InszZoekstap02 inszZoekstap = new InszZoekstap02();
        inszOpzoeking.getVersies().add(inszZoekstap);
        inszOpzoeking.setLaatsteZoekstap(inszZoekstap);

        grpv.getInszOpzoekingen().add(inszOpzoeking);
        grpv.setLaatsteOpzoeking(inszOpzoeking);

        getEntityManager().persist(grp);
    }

//    @Test
    public void testGeregistreerdPersoon03() throws Exception {
        Query query = getEntityManager().createQuery("select grp from GeregistreerdPersoon02 grp");

        List<GeregistreerdPersoon02> grps = query.getResultList();

        Assert.assertEquals(2, grps.size());
    }
}
