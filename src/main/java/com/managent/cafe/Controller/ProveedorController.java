package com.managent.cafe.Controller;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Producto;
import com.managent.cafe.Entity.Proveedor;
import com.managent.cafe.Service.CategoriaService;
import com.managent.cafe.Service.ProveedorService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/proveedor")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class ProveedorController {
    @Autowired
    private ProveedorService provService;

    @GetMapping
    @ResponseBody
    public List<Proveedor> listaProveedor() {
        return provService.listaProveedor();
    }

    @PostMapping("/registraProveedor")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaProveedor(@RequestBody Proveedor obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Proveedor objSalida =  provService.insertaActualizaProveedor(obj);
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

    @PutMapping("/actualizaProveedor")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaProveedor(@RequestBody Proveedor obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Proveedor objSalida =  provService.insertaActualizaProveedor(obj);
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

    @DeleteMapping("/eliminaProveedor/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaProveedor(@PathVariable("id") int idProveedor) {
        Map<String, Object> salida = new HashMap<>();
        try {
            provService.eliminaProveedor(idProveedor);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
