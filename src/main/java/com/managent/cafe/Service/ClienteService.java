package com.managent.cafe.Service;

import java.util.List;

import com.managent.cafe.Entity.Cliente;

public interface ClienteService {
	public abstract List<Cliente> listaCliente();
    public abstract Cliente insertaActualizaCliente(Cliente obj);
    public abstract void eliminaCliente(int idCliente);
    public abstract List<Cliente> listaClientePorNombreLike(String nombres);

}
