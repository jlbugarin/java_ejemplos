package com.consultorjava.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controlador {
	
	 @RequestMapping("hola")
	    @ResponseBody
	    public String getMessage(){
	        return "Hola, mundillo!";
	    }

	    @RequestMapping("chau")
	    @ResponseBody
	    public String getMessage2(){
	        return "chau, mundillo!";
	    }

}
