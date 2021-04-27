/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.democotillon.model.service;

import com.analistas.democotillon.model.domain.Articulo;
import com.analistas.democotillon.model.repository.IArticuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author migue
 */
@Service
public class ArticuloServiceImpl implements IArticuloService {

    //  DI (Dependence Injection)  es un tipo de IoC (Inversion of Control), 
    // (dónde no es el objeto el encargado de instanciarse, sino un contenedor o un evento externo
    // Recordar: Principio de Hollywood
    @Autowired
    IArticuloRepository artRepo;
    
    @Override
    public List<Articulo> buscarTodo() {
        return artRepo.findAll();
    }
    
    @Override
    public List<Articulo> buscarPor(String texto) {
        return artRepo.buscarPor(texto);
    }
    
    @Override
    public Articulo buscarPorId(Integer id) {
        return artRepo.findById(id).orElse(null);
    }
    
    @Override
    public void guardar(Articulo articulo) {
        artRepo.save(articulo);
    }
    
    @Override
    public void borrar(Integer id) {
        artRepo.deleteById(id);
    }
    
}
