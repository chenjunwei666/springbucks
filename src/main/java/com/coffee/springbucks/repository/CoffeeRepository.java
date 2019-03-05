package com.coffee.springbucks.repository;

import com.coffee.springbucks.model.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee,Long> {
}
