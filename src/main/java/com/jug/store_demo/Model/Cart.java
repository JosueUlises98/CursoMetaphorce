package com.jug.store_demo.Model;

import jakarta.persistence.*;

@Entity
@Table
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_sequence"
    )

    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Cart() { }

    public Cart(User user) {
        this.user = user;
    }
}
