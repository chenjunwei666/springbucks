package com.coffee.springbucks;

import com.coffee.springbucks.model.Coffee;
import com.coffee.springbucks.model.CoffeeOrder;
import com.coffee.springbucks.model.OrderState;
import com.coffee.springbucks.repository.CoffeeOrderRepository;
import com.coffee.springbucks.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.Function;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class SpringbucksApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;
    @Autowired
    private CoffeeOrderRepository orderRepository;

    public static void main(String[] args) {
       SpringApplication.run(SpringbucksApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initOrders();
        findOrders();
    }


    private void initOrders(){
        Coffee espresso = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"),20.0)).build();

        coffeeRepository.save(espresso);
        log.info("Coffee: {}",espresso);

        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"),30.0)).build();

        coffeeRepository.save(latte);
        log.info("Coffee:{}",latte);

        CoffeeOrder order = CoffeeOrder.builder()
                .customer("kobe")
                .items(Collections.singletonList(espresso))
                .state(OrderState.INIT)
                .build();

        orderRepository.save(order);
        log.info("Order:{}",order);

        order = CoffeeOrder.builder()
                .customer("bryant")
                .items(Arrays.asList(espresso,latte))
                .state(OrderState.INIT)
                .build();

        orderRepository.save(order);
        log.info("Order:{}",order);
    }

    private void findOrders(){
        coffeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"))
                .forEach(coffee -> log.info("Loading {}",coffee));



        //orderRepository.

    }
}
