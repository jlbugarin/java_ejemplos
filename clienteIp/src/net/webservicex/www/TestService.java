package net.webservicex.www;

import org.apache.axis.AxisFault;

public class TestService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GeoIPServiceSoap ip;
		try {
			ip = new GeoIPServiceSoapProxy();
			GeoIP a = ip.getGeoIP("200.0.118.173");
			System.out.println("RESP -> "+a.getCountryName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
