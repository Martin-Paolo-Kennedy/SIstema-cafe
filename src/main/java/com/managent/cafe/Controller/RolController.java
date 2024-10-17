package com.managent.cafe.Controller;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Rol;
import com.managent.cafe.Service.CategoriaService;
import com.managent.cafe.Service.RolService;
import com.managent.cafe.Util.AppSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/url/rol")
@CrossOrigin(origins = AppSettings.URL_CROSS_ORIGIN)
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    @ResponseBody
    public List<Rol> listaCategoria() {
        return rolService.listaRol();
    }

}
