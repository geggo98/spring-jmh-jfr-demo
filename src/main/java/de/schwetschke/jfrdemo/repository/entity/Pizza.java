package de.schwetschke.jfrdemo.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pizza")
@Data
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topping_id")
    private UUID id;

    @Column(name = "pizza_name")
    private String name;

    @ElementCollection
    @CollectionTable(name="pizza_topping", joinColumns=@JoinColumn(name="topping_id"))
    @Column(name="topping_name")
    private List<String> toppings;
}
