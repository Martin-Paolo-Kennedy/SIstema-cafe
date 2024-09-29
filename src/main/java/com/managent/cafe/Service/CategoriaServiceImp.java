package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Repository.CategoriaRepository;
import com.managent.cafe.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {
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
}
