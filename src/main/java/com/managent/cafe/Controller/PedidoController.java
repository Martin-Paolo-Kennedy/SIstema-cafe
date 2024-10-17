package com.managent.cafe.Controller;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Pedido;
import com.managent.cafe.Service.CategoriaService;
import com.managent.cafe.Service.PedidoService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/pedido")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class PedidoController {
    @Autowired
    private PedidoService pedService;

    @GetMapping
    @ResponseBody
    public List<Pedido> listaPedido() {
        return pedService.listaPedido();
    }

    @PostMapping("/registraPedido")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaPedido(@RequestBody Pedido obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Pedido objSalida =  pedService.insertaActualizaPedido(obj);
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

    @PutMapping("/actualizaPedido")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaPedido(@RequestBody Pedido obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Pedido objSalida =  pedService.insertaActualizaPedido(obj);
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

    @DeleteMapping("/eliminaPedido/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaPedido(@PathVariable("id") int idPedido) {
        Map<String, Object> salida = new HashMap<>();
        try {
            pedService.eliminaPedido(idPedido);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
