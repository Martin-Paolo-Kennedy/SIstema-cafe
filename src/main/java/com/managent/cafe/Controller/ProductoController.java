package com.managent.cafe.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;
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

import com.managent.cafe.Entity.Producto;
import com.managent.cafe.Service.ProductoService;


@RestController
@RequestMapping
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProductoController {
	@Autowired
    private ProductoService proService;

    @GetMapping
    @ResponseBody
    public List<Producto> listaProducto() {
        return proService.listaProducto();
    }

    //Prueba
    @PostMapping("/registraProducto")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaProducto(@RequestBody Producto obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdProducto(0);
            Producto objSalida =  proService.insertaActualizaProducto(obj);
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

    @PutMapping("/actualizaProducto")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaProducto(@RequestBody Producto obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
        	Producto objSalida =  proService.insertaActualizaProducto(obj);
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

    @DeleteMapping("/eliminaProducto/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaProducto(@PathVariable("id") int idProducto) {
        Map<String, Object> salida = new HashMap<>();
        try {
        	proService.eliminaProducto(idProducto);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}