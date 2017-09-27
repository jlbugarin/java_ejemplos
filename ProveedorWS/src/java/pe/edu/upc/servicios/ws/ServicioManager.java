/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.servicios.ws;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author pcsijbug
 */
@WebService(serviceName = "ServicioManager")
public class ServicioManager {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        
        try {
           /* Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("cmd / c/ shutdown -s -t 15 cmd");
            int exitVal = proc.exitValue();
            System.out.println("Process exitValue: " + exitVal);
            */
            
            String command = "shutdown -s -t 15";
    Process child = Runtime.getRuntime().exec(command);

    // Get output stream to write from it
    /*OutputStream out = child.getOutputStream();

    out.write("cd C:/ /r/n".getBytes());
    out.flush();
    out.write("shutdown -s -t 2 /r/n".getBytes());
    out.close();
      */      
            
        } catch (Exception ex) {
            Logger.getLogger(ServicioManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "Hola mi querido " + txt + " !";
    }
}
