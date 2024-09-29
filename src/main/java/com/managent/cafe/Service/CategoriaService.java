package com.managent.cafe.Service;

import java.util.List;

import com.managent.cafe.Entity.Categoria;

public interface CategoriaService {
	public abstract List<Categoria> listaCategoria();
    public abstract Categoria insertaActualizaCategoria(Categoria obj);
    public abstract void eliminaCategoria(int idCategoria);
    public abstract List<Categoria> listaCategoriaPorNombreLike(String nombres);

}
