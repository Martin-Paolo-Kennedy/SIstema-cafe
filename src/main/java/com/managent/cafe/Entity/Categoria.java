package com.managent.cafe.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(nullable = false, unique = true, length = 100)
    private String nombreCategoria;
}
