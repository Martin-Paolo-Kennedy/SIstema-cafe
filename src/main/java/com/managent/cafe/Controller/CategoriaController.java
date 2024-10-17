package com.managent.cafe.Controller;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Service.CategoriaService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/categoria")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CategoriaController {
    @Autowired
    private CategoriaService catService;

    @GetMapping
    @ResponseBody
    public List<Categoria> listaCategoria() {
        return catService.listaCategoria();
    }

    @PostMapping("/registraCategoria")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaCategoria(@RequestBody Categoria obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Categoria objSalida =  catService.insertaActualizaCategoria(obj);
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

    @PutMapping("/actualizaCategoria")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaCategoria(@RequestBody Categoria obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Categoria objSalida =  catService.insertaActualizaCategoria(obj);
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

    @DeleteMapping("/eliminaCategoria/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaCategoria(@PathVariable("id") int idCategoria) {
        Map<String, Object> salida = new HashMap<>();
        try {
            catService.eliminaCategoria(idCategoria);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
