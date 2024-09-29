package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Producto;

import java.util.List;

public interface CategoriaService {
    public abstract List<Categoria> listaCategoria();
    public abstract Categoria insertaActualizaCategoria(Categoria obj);
    public abstract void eliminaCategoria(int idCategoria);
}
