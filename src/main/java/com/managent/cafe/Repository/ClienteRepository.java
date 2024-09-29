package com.managent.cafe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.managent.cafe.Entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	@Query("select c from Cliente c where c.nombreCliente like ?1")
    public List<Cliente> listaPorNombreLike(String nombres);

}
