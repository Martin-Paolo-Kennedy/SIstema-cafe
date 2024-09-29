package com.managent.cafe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
    private CategoriaRepository repository;

    @Override
    public List<Categoria> listaCategoria() {
        return repository.findAll();
    }

    @Override
    public Categoria insertaActualizaCategoria(Categoria obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaCategoria(int idCategoria) {
        repository.deleteById(idCategoria);
    }

    @Override
    public List<Categoria> listaCategoriaPorNombreLike(String nombres) {
        return repository.listaPorNombreLike(nombres);
    }

}
