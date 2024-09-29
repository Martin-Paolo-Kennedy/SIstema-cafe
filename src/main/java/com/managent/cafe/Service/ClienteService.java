package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Cliente;

import java.util.List;

public interface ClienteService {
    public abstract List<Cliente> listaCliente();
    public abstract Cliente insertaActualizaCliente(Cliente obj);
    public abstract void eliminaCliente(int idCliente);
}
