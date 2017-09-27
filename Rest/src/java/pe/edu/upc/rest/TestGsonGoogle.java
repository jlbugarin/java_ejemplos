/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.rest;

import com.google.gson.Gson;

/**
 *
 * @author pcsijbug
 */
public class TestGsonGoogle {
    
    public static void main(String r[]){
        
        
        Alumno a = new Alumno();
        a.setId(Long.MIN_VALUE);
        a.setNombre("pepito");
        
        Gson g = new Gson();
        String algo = g.toJson(a);
        
        System.out.println("JSON -> " + algo);
        
        
        Alumno aa = g.fromJson("{\"id\":-9223372036854775808,\"nombre\":\"pepito\"}", Alumno.class);
        
        System.out.println("OBJETO -> " +aa.getNombre());
        
    
    }
    
}
