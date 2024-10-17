package com.managent.cafe.Service;

import com.managent.cafe.Entity.Rol;
import com.managent.cafe.Repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImp implements RolService{
    @Autowired
    private RolRepository repository;

    @Override
    public List<Rol> listaRol() {
        return repository.findAll();
    }
}
