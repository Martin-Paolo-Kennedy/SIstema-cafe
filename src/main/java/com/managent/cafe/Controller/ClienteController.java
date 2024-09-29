package com.managent.cafe.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.managent.cafe.Entity.Cliente;
import com.managent.cafe.Service.ClienteService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;

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
    //http://localhost:8090/url/categoria/listaCategoriaPorNombreLike/Condiments
    @GetMapping("/listaClientePorNombreLike/{nom}")
    @ResponseBody
    public ResponseEntity<List<Cliente>> listaClientePorNombreLike(@PathVariable("nom") String nom) {
        List<Cliente> lista  = null;
        try {
            if (nom.equals("todos")) {
                lista = cliService.listaClientePorNombreLike("%");
            }else {
                lista = cliService.listaClientePorNombreLike("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
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
