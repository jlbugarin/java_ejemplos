/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresioneslambda;

import com.consultorjava.interfaces.Calculadora;

/**
 *
 * @author jlbugarin
 */
public class ExpresionesLambda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calculadora multipicar = (x,y)->x*y;
        int producto = multipicar.calcular(2, 2);
        System.err.println("producto: "+ producto);
        
        Calculadora restar = (x,y)-> x-y;
        int resta = restar.calcular(2, 2);
        System.err.println("resta: "+ resta);
        
        Calculadora sumar = (x,y)-> x+y;
        int suma =  sumar.calcular(2, 2);
        System.err.println("suma: "+ suma);
        
    }
    
}
