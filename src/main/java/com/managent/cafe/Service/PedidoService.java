package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Pedido;

import java.util.List;

public interface PedidoService {
    public abstract List<Pedido> listaPedido();
    public abstract Pedido insertaActualizaPedido(Pedido obj);
    public abstract void eliminaPedido(int idPedido);
}
