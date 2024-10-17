package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.DetallePedido;

import java.util.List;

public interface DetallePedidoService {
    public abstract List<DetallePedido> listaDetallePedido();
    public abstract DetallePedido insertaActualizaDetallePedido(DetallePedido obj);
    public abstract void eliminaDetallePedido(int idDetallePedido);
}
