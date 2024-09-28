package com.managent.cafe.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    private String nombreProveedor;

    private String contacto;

    private String direccion;

    private String ciudad;

    private String telefono;
}
