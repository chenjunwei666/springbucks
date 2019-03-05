package com.coffee.springbucks.repository;

import com.coffee.springbucks.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeOrderRepository extends CrudRepository<CoffeeOrder,Long> {
}
