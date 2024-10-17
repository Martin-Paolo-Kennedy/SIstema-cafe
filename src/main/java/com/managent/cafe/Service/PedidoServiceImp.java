package com.managent.cafe.Service;

import com.managent.cafe.Entity.Pedido;
import com.managent.cafe.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImp implements PedidoService {
    @Autowired
    private PedidoRepository repository;

    @Override
    public List<Pedido> listaPedido() {
        return repository.findAll();
    }

    @Override
    public Pedido insertaActualizaPedido(Pedido obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaPedido(int idPedido) {
        repository.deleteById(idPedido);
    }
}
