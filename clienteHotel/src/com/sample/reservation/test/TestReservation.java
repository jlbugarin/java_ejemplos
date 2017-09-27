package com.sample.reservation.test;

import java.rmi.RemoteException;
import java.util.Calendar;

import com.sample.reservation.ReservationService;
import com.sample.reservation.ReservationServiceProxy;
import com.sample.reservation.dto.Reservation;
import com.sample.reservation.exception.ReservationManagementException;

public class TestReservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReservationService res = new ReservationServiceProxy();
		
		
		
		Calendar ca = Calendar.getInstance();
		Calendar ca2 = Calendar.getInstance();
		
		try {
			
			boolean resp = res.addReservation(666, "Upecino", ca, ca2);
			System.out.println("RESPUESTA -> " + resp);
			
			
			
		} catch (ReservationManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
