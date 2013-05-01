package be.parus17.experiments.hibernate;

import be.parus17.experiments.hibernate.util.JPAUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class JPABaseTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Before
    public void setUp() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void tearDown() throws Exception {
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @BeforeClass
    public static void setUpCsass() throws Exception {
        entityManagerFactory = JPAUtil.getEntityManagerFactory();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        entityManagerFactory.close();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
