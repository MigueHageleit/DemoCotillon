/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analistas.democotillon.web.controller;

import com.analistas.democotillon.model.domain.Articulo;
import com.analistas.democotillon.model.service.IArticuloService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author migue
 */
@Controller
@RequestMapping("/articulos")
@SessionAttributes("articulo")
public class ArticuloController {

    @Autowired
    IArticuloService artServ;

    @GetMapping("/listado")
    public String verListado(Model model) {

        model.addAttribute("titulo", "Lista de Articulos en Stock");
        model.addAttribute("tituloForm", "Lista de Articulos");
        model.addAttribute("articulos", artServ.buscarTodo());

        return "articulos/list";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("titulo", "Nuevo Articulo");
        model.addAttribute("tituloForm", "Completar los Campos");
        model.addAttribute("articulo", new Articulo());

        return "articulos/form";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model, RedirectAttributes redirect) {
        
        model.addAttribute("titulo", "Modificar Articulo");
        model.addAttribute("tituloForm", "Editar los Campos");
        model.addAttribute("articulo", artServ.buscarPorId(id));
        
        return "articulos/form";
    }

    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable int id, Model model, RedirectAttributes redirect) {
        artServ.borrar(id);
        redirect.addFlashAttribute("borrado", "Articulo Eliminado..");

        return "redirect:/articulos/listado";
    }
    
    
    
     @PostMapping("/buscar")
    public String buscar(Model model, String buscar) {
    
         model.addAttribute("titulo", "Listado de Articulos - Que contenga: " + buscar);
        model.addAttribute("articulos", artServ.buscarPor(buscar));        
        return "articulos/list";
    }
    
    
    @PostMapping("/guardar")
    public String guardar(@Valid  Articulo articulo, BindingResult result, Model model, 
            RedirectAttributes redirect, SessionStatus status) {
        
        if(result.hasErrors())
            return "articulos/form";
        
        if(articulo.getId() == 0)
            redirect.addFlashAttribute("creado", "Nuevo Articulo añadido.");
        else
            redirect.addFlashAttribute("editado", "Articulo " + articulo.getDescripcion() + "modificado.");
        
        artServ.guardar(articulo);
        status.isComplete();
    
        return "redirect:/articulos/listado";
    }
}
