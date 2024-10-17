package com.managent.cafe.Service;

import com.managent.cafe.Entity.Usuario;
import com.managent.cafe.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService{
    @Autowired
    private UsuarioRepository repository;
    @Override
    public List<Usuario> listaUsuario() {
        return repository.findAll();
    }

    @Override
    public Usuario insertaActualizaUsuario(Usuario obj) {
        return repository.save(obj);
    }

    @Override
    public void eliminaUsuario(int idUsuario) {
        repository.deleteById(idUsuario);
    }
}
