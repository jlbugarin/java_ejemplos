/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpaejemplo;

import com.consultorjava.jpa.Manufacturer;
import com.consultorjava.jpa.contoller.ManufacturerJpaController;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jlbugarin
 */
public class JpaEjemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaEjemploPU");
        ManufacturerJpaController mjc = new ManufacturerJpaController(emf);
        Manufacturer m = new Manufacturer();
        
        m.setEmail("jbugarin@consultorjava.com");
        m.setCity("Lima");
        m.setFax("1111");
        m.setState("90");
        m.setZip("90");
        m.setRep("REP");
        m.setPhone("999999");
        m.setManufacturerId(Integer.MAX_VALUE);
        m.setName("ILUMINATIC");
        m.setAddressline1("dir 1");
        m.setAddressline2("dir 2");
        
        mjc.create(m);
        
        
        
        
        
        
        
        
    }
    
}
