package xyz.vaith.springbootbucks;

import lombok.extern.log4j.Log4j2;
import org.aspectj.weaver.ast.Or;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import xyz.vaith.springbootbucks.entity.Coffee;
import xyz.vaith.springbootbucks.entity.CoffeeOrder;
import xyz.vaith.springbootbucks.entity.OrderStatus;
import xyz.vaith.springbootbucks.repository.CoffeeOrderRepository;
import xyz.vaith.springbootbucks.repository.CoffeeRepository;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@Log4j2
public class SpringBootBucksApplication implements ApplicationRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBucksApplication.class, args);
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        initOrders();
        findOrders();
    }


    private void initOrders() {
        Coffee latte = Coffee.builder().name("latte").price(Money.of(CurrencyUnit.of("CNY"), 30.0)).build();
        coffeeRepository.save(latte);
        log.info("Coffee:  {}", latte);

        Coffee espresso = Coffee.builder().name("espresso").price(Money.of(CurrencyUnit.of("CNY"), 20.0)).build();
        coffeeRepository.save(espresso);
        log.info("Coffee: {}", espresso);

        CoffeeOrder order = CoffeeOrder.builder().customer("Li Lei").items(Collections.singletonList(espresso)).state(OrderStatus.INTI).build();
        coffeeOrderRepository.save(order);
        log.info("Order: {}", order);

        order = CoffeeOrder.builder().customer("Li Lei").items(Arrays.asList(espresso, latte)).state(OrderStatus.INTI).build();
        coffeeOrderRepository.save(order);
        log.info("Order: {}", order);

    }

    private void findOrders() {
        coffeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).forEach(c -> log.info("Loading {}", c));
        List<CoffeeOrder> list = coffeeOrderRepository.findTop3ByOrderByUpdateTimeDescIdAsc();
        log.info("findTop3ByOrderByUpdateTimeDescIdAsc: {}", list);

        list = coffeeOrderRepository.findByCustomerOrderById("Li Lei");
        log.info("findByCustomerOrderById: {}", list);

        list.forEach(c -> {
            log.info("Order {}", c.getId());
            c.getItems().forEach(i -> {
                log.info("  Item {}", i);
            });
        });

        list = coffeeOrderRepository.findByItems_Name("latte");
        log.info("findByItems_Name: {}", getJoinedOrderId(list));
    }

    private String getJoinedOrderId(List<CoffeeOrder> list) {
        return list.stream().map(o -> o.getId().toString())
                .collect(Collectors.joining(","));
    }

}
