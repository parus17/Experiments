package be.parus17.experiments.hibernate;

import be.parus17.experiments.hibernate.domain.GeregistreerdPersoon01;
import be.parus17.experiments.hibernate.domain.GeregistreerdPersoonVersie01;
import org.junit.Assert;
import org.junit.Test;

import javax.persistence.Query;
import java.util.List;

public class JPA01Test extends JPABaseTest {
    @Test
    public void testGeregistreerdPersoon01() throws Exception {
        GeregistreerdPersoon01 grp = new GeregistreerdPersoon01();
        GeregistreerdPersoonVersie01 grpv = new GeregistreerdPersoonVersie01();
        grp.addVersie(grpv);

        getEntityManager().persist(grp);
    }

//    @Test
    public void testGeregistreerdPersoon02() throws Exception {
        GeregistreerdPersoon01 grp = new GeregistreerdPersoon01();
        GeregistreerdPersoonVersie01 grpv = new GeregistreerdPersoonVersie01();
        grp.addVersie(grpv);

        getEntityManager().persist(grp);
    }

//    @Test
    public void testGeregistreerdPersoon03() throws Exception {
        Query query = getEntityManager().createQuery("select grp from GeregistreerdPersoon01 grp");
        // Query query = getEntityManager().createQuery("select grp from GeregistreerdPersoon01 grp join fetch grp.huidigeVersie grpv");

        List<GeregistreerdPersoon01> grps = query.getResultList();

        Assert.assertEquals(2, grps.size());
    }
}
