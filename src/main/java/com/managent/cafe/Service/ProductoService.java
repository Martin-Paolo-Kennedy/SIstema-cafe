package com.managent.cafe.Service;

import java.util.List;

import com.managent.cafe.Entity.Producto;

public interface ProductoService {
	public abstract List<Producto> listaProducto();
    public abstract Producto insertaActualizaProducto(Producto obj);
    public abstract void eliminaProducto(int idEmpleado);
}
