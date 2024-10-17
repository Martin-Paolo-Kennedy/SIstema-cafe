package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.DetallePedido;
import com.managent.cafe.Repository.DetallePedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository repository;

    @Override
    public List<DetallePedido> listaDetallePedido() {
        return repository.findAll();
    }

    @Override
    public DetallePedido insertaActualizaDetallePedido(DetallePedido obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaDetallePedido(int idDetallePedido) {
        repository.deleteById(idDetallePedido);
    }
}
