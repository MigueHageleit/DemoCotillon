/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.democotillon.model.service;

import com.analistas.democotillon.model.domain.Articulo;
import java.util.List;

/**
 *
 * @author migue
 */
public interface IArticuloService {
    
    public List<Articulo> buscarTodo();
    
    public List<Articulo> buscarPor(String texto);
    
    public Articulo buscarPorId(Integer id);
    
    public void guardar(Articulo articulo);
    
    public void borrar(Integer id);
    
}
