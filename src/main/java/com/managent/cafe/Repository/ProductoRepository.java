package com.managent.cafe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;   

import com.managent.cafe.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {


}
