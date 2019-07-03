package de.schwetschke.jfrdemo.repository;

import de.schwetschke.jfrdemo.repository.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PizzaRepository extends JpaRepository<Pizza, UUID> {
}
