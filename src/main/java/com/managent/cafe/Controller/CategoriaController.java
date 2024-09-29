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

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Service.CategoriaService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;

@RestController
@RequestMapping
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class CategoriaController {
	@Autowired
    private CategoriaService catService;

    @GetMapping
    @ResponseBody
    public List<Categoria> listaCategoria() {
        return catService.listaCategoria();
    }
    //http://localhost:8090/url/categoria/listaCategoriaPorNombreLike/Condiments
    @GetMapping("/listaCategoriaPorNombreLike/{nom}")
    @ResponseBody
    public ResponseEntity<List<Categoria>> listaCategoriaPorNombreLike(@PathVariable("nom") String nom) {
        List<Categoria> lista  = null;
        try {
            if (nom.equals("todos")) {
                lista = catService.listaCategoriaPorNombreLike("%");
            }else {
                lista = catService.listaCategoriaPorNombreLike("%" + nom + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registraCategoria")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaCategoria(@RequestBody Categoria obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            obj.setIdCategoria(0);
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
