package de.schwetschke.jfrdemo.benchmark;

import de.schwetschke.jfrdemo.repository.PizzaRepository;
import de.schwetschke.jfrdemo.repository.entity.Pizza;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootTest
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@RunWith(SpringRunner.class)
public class JpaBenchmark extends AbstractJfrBenchmark {
    private static PizzaRepository pizzaRepository;

    @Autowired
    private void setPizzaRepository(PizzaRepository pizzaRepository) {
        JpaBenchmark.pizzaRepository = pizzaRepository;
    }

    @Setup(Level.Trial)
    public void setupBenchmark() {
        final Pizza pizza = new Pizza();
        pizza.setName("Hawaii");
        pizza.getToppings().add("Ham");
        pizza.getToppings().add("Ananas");
        pizzaRepository.save(pizza);
    }


    @Benchmark
    public void benchmarkFetchAll() {
        final List<Pizza> all = pizzaRepository.findAll();
        final int size = all.size();
    }
}
