package com.managent.cafe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managent.cafe.Entity.Cliente;
import com.managent.cafe.Repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
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

    @Override
    public List<Cliente> listaClientePorNombreLike(String nombres) {
        return repository.listaPorNombreLike(nombres);
    }

}
