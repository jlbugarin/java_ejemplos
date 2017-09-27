/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientews;

import pe.edu.upc.cliente.Currency;
import pe.edu.upc.ip.GeoIP;

/**
 *
 * @author pcsijbug
 */
public class ClienteWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double algo  = conversionRate(Currency.CLP, Currency.PEN);
        
        System.out.println("VALOR: " + algo);
        
        
        GeoIP algo2 = getGeoIP("62.210.215.114");
        
        System.out.println("VALOR: " + algo2.getCountryName());
        
    }

    private static double conversionRate(pe.edu.upc.cliente.Currency fromCurrency, pe.edu.upc.cliente.Currency toCurrency) {
        pe.edu.upc.cliente.CurrencyConvertor service = new pe.edu.upc.cliente.CurrencyConvertor();
        pe.edu.upc.cliente.CurrencyConvertorSoap port = service.getCurrencyConvertorSoap();
        return port.conversionRate(fromCurrency, toCurrency);
    }

    private static GeoIP getGeoIP(java.lang.String ipAddress) {
        pe.edu.upc.ip.GeoIPService service = new pe.edu.upc.ip.GeoIPService();
        pe.edu.upc.ip.GeoIPServiceSoap port = service.getGeoIPServiceSoap();
        return port.getGeoIP(ipAddress);
    }
    
}
