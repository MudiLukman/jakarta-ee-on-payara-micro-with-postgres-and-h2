package com.kontrol.javaeedemo.grocery;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class GroceryRepository {

    @PersistenceContext(unitName = "groceryPU")
    EntityManager entityManager;

    public List<Grocery> findAll() {
        return entityManager.createQuery(
                "SELECT g FROM Grocery AS g", Grocery.class)
                .getResultList();
    }

    public Grocery save(Grocery request) {
        Grocery grocery = new Grocery();
        grocery.name = request.name;
        grocery.price = request.price;
        entityManager.persist(grocery);
        return find(grocery.id);
    }

    public Grocery find(UUID id) {
        return entityManager.find(Grocery.class, id);
    }
}
