package com.managent.cafe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managent.cafe.Entity.Producto;
import com.managent.cafe.Repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoRepository repository;

	@Override
	public List<Producto> listaProducto() {
		return repository.findAll();
	}

	@Override
	public Producto insertaActualizaProducto(Producto obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaProducto(int idProducto) {
		repository.deleteById(idProducto);
	}

}
