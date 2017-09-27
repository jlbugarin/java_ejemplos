/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iluminatic.demo.controller;

import com.iluminatic.demo.model.Prospecto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jlbugarin
 */
@Controller
@RequestMapping("/iluminatic/registro")
public class RestController {
    
    @RequestMapping(value="{nombre}", method=RequestMethod.GET)
    
    public @ResponseBody Prospecto getProspectoJson(@PathVariable String nombre){
        
        Prospecto pro = new Prospecto();
        pro.setNombre(nombre);
        pro.setEmail("jbugarin@iluminatic.com");
        
        return pro;
    
    } 
    
    
}
