/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientepokemon;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.HttpVersion;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import pe.edu.upc.modelo.Poke;
import pe.edu.upc.modelo.ResPokemon;

/**
 *
 * @author pcsijbug
 */
public class ClientePokemon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        String a = Request.Get("http://pokeapi.co/api/v1/pokedex/1/")
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute().returnContent().asString();
        
        System.out.println(a);
        
        Gson gson = new Gson();
        
        ResPokemon poke = gson.fromJson(a, ResPokemon.class);
        
        System.out.println("Total Pokemons : " + poke.getPokemon().size());
        
        
        //llamada rest 
        
       /* Request.Post("http://localhost:8080/RESTUPC/webresources/pe.edu.upc.servicios.rest.alumno/")
                .useExpectContinue()
                .version(HttpVersion.HTTP_1_1)
                .bodyString("{\"id\":105,\"nombre\":\"MARTEL\"}", ContentType.APPLICATION_JSON)
                .execute();
        
        System.out.println("paso... ");
        
        Request.Put("http://localhost:8080/RESTUPC/webresources/pe.edu.upc.servicios.rest.alumno/105/")
                .useExpectContinue()
                .version(HttpVersion.HTTP_1_1)
                .bodyString("{\"id\":105,\"nombre\":\"MARTES\"}", ContentType.APPLICATION_JSON)
                .execute();
        */
        System.out.println("fin..");
        
        //con get seleccionar objeto alumno
        
        /*String aa = Request.Get("http://localhost:8080/RESTUPC/webresources/pe.edu.upc.servicios.rest.alumno/105")
                .useExpectContinue()
                .version(HttpVersion.HTTP_1_1)
                .bodyString("{\"id\":105,\"nombre\":\"MARTEL\"}", ContentType.APPLICATION_JSON)
                .execute().returnContent().asString();
        */
        
        String aa = Request.Get("http://localhost:8080/RESTUPC/webresources/pe.edu.upc.servicios.rest.alumno/105")
                .connectTimeout(1000)
                .socketTimeout(1000)
                .execute().returnContent().asString();
        
        System.out.println(aa);
        
    }
    
}
