package com.managent.cafe.Service;

import com.managent.cafe.Entity.Categoria;
import com.managent.cafe.Entity.Usuario;

import java.util.List;

public interface UsuarioService {
    public abstract List<Usuario> listaUsuario();
    public abstract Usuario insertaActualizaUsuario(Usuario obj);
    public abstract void eliminaUsuario(int idUsuario);
}
