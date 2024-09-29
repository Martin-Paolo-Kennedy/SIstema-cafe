package com.managent.cafe.Controller;

import com.managent.cafe.Entity.Cliente;
import com.managent.cafe.Service.ClienteService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/cliente")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ClienteController {
    @Autowired
    private ClienteService cliService;

    @GetMapping
    @ResponseBody
    public List<Cliente> listaCliente() {
        return cliService.listaCliente();
    }

    @PostMapping("/registraCliente")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaCliente(@RequestBody Cliente obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdCliente(0);
            Cliente objSalida =  cliService.insertaActualizaCliente(obj);
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

    @PutMapping("/actualizaCliente")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaCliente(@RequestBody Cliente obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Cliente objSalida =  cliService.insertaActualizaCliente(obj);
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

    @DeleteMapping("/eliminaCliente/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaCliente(@PathVariable("id") int idCliente) {
        Map<String, Object> salida = new HashMap<>();
        try {
            cliService.eliminaCliente(idCliente);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
