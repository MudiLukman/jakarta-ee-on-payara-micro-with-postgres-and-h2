package com.kontrol.javaeedemo.grocery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class GroceryService {

    @Inject GroceryRepository groceryRepository;

    public List<Grocery> findAll() {
        return groceryRepository.findAll();
    }

    @Transactional
    public Grocery create(Grocery grocery) {
        return groceryRepository.save(grocery);
    }
}
