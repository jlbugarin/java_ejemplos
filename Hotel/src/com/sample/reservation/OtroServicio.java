/**
 * 
 */
package com.sample.reservation;

import com.sample.reservation.database.Storage;
import com.sample.reservation.exception.StorageException;

/**
 * @author jlbugarin
 *
 */
public class OtroServicio {
	
	
	public String reservaUpc(String nombre, int numeroHabitacion){
		
		 Storage storage = new Storage();
		 String mensaje = "";
		 try {
			boolean var = storage.proceedReservation(nombre, numeroHabitacion);
			
			if (var){
				
				mensaje = "ok";
			}else{
				
				mensaje = "error";
				
			}
			
		} catch (StorageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mensaje;
	}
	

}
