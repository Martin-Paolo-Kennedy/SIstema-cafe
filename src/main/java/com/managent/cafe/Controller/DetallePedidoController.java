package com.managent.cafe.Controller;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.DetallePedido;
import com.managent.cafe.Service.CategoriaService;
import com.managent.cafe.Service.DetallePedidoService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/pedidoDetalle")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detpedService;

    @GetMapping
    @ResponseBody
    public List<DetallePedido> listaPedidoDetalle() {
        return detpedService.listaDetallePedido();
    }

    @PostMapping("/registraPedidoDetalle")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaPedidoDetalle(@RequestBody DetallePedido obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            DetallePedido objSalida =  detpedService.insertaActualizaDetallePedido(obj);
            if (objSalida == null) {
                salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
            } else {
                salida.put("mensaje", Constantes.MENSAJE_REG_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_REG_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @PutMapping("/actualizaPedidoDetalle")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaPedidoDetalle(@RequestBody DetallePedido obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            DetallePedido objSalida =  detpedService.insertaActualizaDetallePedido(obj);
            if (objSalida == null) {
                salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
            } else {
                salida.put("mensaje", Constantes.MENSAJE_ACT_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(salida);
    }

    @DeleteMapping("/eliminaPedidoDetalle/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaPedidoDetalle(@PathVariable("id") int idDetallePedido) {
        Map<String, Object> salida = new HashMap<>();
        try {
            detpedService.eliminaDetallePedido(idDetallePedido);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
