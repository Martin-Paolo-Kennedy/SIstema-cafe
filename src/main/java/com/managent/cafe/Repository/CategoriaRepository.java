package com.managent.cafe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.managent.cafe.Entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	@Query("select c from categorias c where c.nombreCategoria like ?1")
    public List<Categoria> listaPorNombreLike(String nombres);

}
