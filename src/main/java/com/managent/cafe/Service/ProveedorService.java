package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Proveedor;

import java.util.List;

public interface ProveedorService {
    public abstract List<Proveedor> listaProveedor();
    public abstract Proveedor insertaActualizaProveedor(Proveedor obj);
    public abstract void eliminaProveedor(int idProveedor);
}
