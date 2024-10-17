package com.managent.cafe.Controller;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Usuario;
import com.managent.cafe.Service.CategoriaService;
import com.managent.cafe.Service.UsuarioService;
import com.managent.cafe.Util.AppSettings;
import com.managent.cafe.Util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/url/usuario")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class UsuarioController {
    @Autowired
    private UsuarioService usuService;

    @GetMapping
    @ResponseBody
    public List<Usuario> listaUsuario() {
        return usuService.listaUsuario();
    }

    @PostMapping("/registraUsuario")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> insertaUsuario(@RequestBody Usuario obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Usuario objSalida =  usuService.insertaActualizaUsuario(obj);
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

    @PutMapping("/actualizaUsuario")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> actualizaUsuario(@RequestBody Usuario obj) {
        Map<String, Object> salida = new HashMap<>();
        try {
            Usuario objSalida =  usuService.insertaActualizaUsuario(obj);
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

    @DeleteMapping("/eliminaUsuario/{id}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> eliminaUsuario(@PathVariable("id") int idUsuario) {
        Map<String, Object> salida = new HashMap<>();
        try {
            usuService.eliminaUsuario(idUsuario);
            salida.put("mensaje", Constantes.MENSAJE_ELI_EXITOSO);
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", Constantes.MENSAJE_ELI_ERROR);
        }
        return ResponseEntity.ok(salida);
    }
}
