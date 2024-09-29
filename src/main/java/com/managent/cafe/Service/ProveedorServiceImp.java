package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Proveedor;
import com.managent.cafe.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServiceImp implements ProveedorService{
    @Autowired
    private ProveedorRepository repository;

    @Override
    public List<Proveedor> listaProveedor() {
        return repository.findAll();
    }

    @Override
    public Proveedor insertaActualizaProveedor(Proveedor obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaProveedor(int idProveedor) {
        repository.deleteById(idProveedor);
    }
}
