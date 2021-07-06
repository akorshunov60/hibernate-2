package com.example.hibernate2.model.repository;

import com.example.hibernate2.model.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Data
@RequiredArgsConstructor
@Repository
public class ProductRepositoryImpl implements ProductRepository {

/*
    // привязка через конфигурационный файл hibernate.cfg.xml
    EntityManagerFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    EntityManager em = factory.createEntityManager();
*/

    private final EntityManager em;

    @Override
    public List<Product> findAll() {

        em.getTransaction().begin();
        List<Product> list = em.createNamedQuery("Product.findAll", Product.class).getResultList();
        em.getTransaction().commit();
        return list;
    }

    @Override
    public List<Product> findAllSortedByName() {

        em.getTransaction().begin();
//        // именованный запрос
        List<Product> list = em.createNamedQuery("Product.findAllSortedByName", Product.class).getResultList(); //ASCENDENCE

//        // обычный запрос
//        List<Product> list = em.createQuery("FROM product p ORDER BY p.name desc", Product.class).getResultList(); //DESCENDENCE

/*
        // нативный SQL-запрос
        List<Product> list = em
                .createNativeQuery("SELECT * FROM products.product p ORDER BY p.name", Product.class)
                .getResultList();
 */

/*
        // с использованием Criteria API
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> productQuery = cb.createQuery(Product.class);
        Root<Product> productRoot = productQuery.from(Product.class);
        productQuery.select(productRoot)
                    .orderBy(cb.desc(productRoot.get("name")));
        List<Product> list = em.createQuery(productQuery).getResultList();
*/
        em.getTransaction().commit();
        return list;
    }

    @Override
    public void saveOrUpdate(Product product) {

        em.getTransaction().begin();
        if (product.getId() == null) { em.persist(product); }
        em.merge(product);
        em.getTransaction().commit();
    }

    @Override
    public Product findById(Long id) {

        em.getTransaction().begin();
        Product product =  em.createNamedQuery("Product.findById", Product.class)
                .setParameter("id", id)
                .getSingleResult();
        em.getTransaction().commit();
        return product;
    }

    @Override
    public void deleteById(Long id) {

        em.getTransaction().begin();
        em.createNamedQuery("Product.deleteById")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
