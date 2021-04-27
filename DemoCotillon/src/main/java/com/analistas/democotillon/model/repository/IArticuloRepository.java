/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.democotillon.model.repository;

import com.analistas.democotillon.model.domain.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author migue
 */
public interface IArticuloRepository extends JpaRepository<Articulo, Integer>{
    
    @Query("SELECT a FROM Articulo a WHERE a.descripcion LIKE %:texto%")
	List<Articulo> buscarPor(@Param("texto") String texto);
    
}
