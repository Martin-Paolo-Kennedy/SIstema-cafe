package com.managent.cafe.Service;

import com.managent.cafe.Entity.Cliente;
import com.managent.cafe.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> listaCliente() {
        return repository.findAll();
    }

    @Override
    public Cliente insertaActualizaCliente(Cliente obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaCliente(int idCliente) {
        repository.deleteById(idCliente);
    }
}
