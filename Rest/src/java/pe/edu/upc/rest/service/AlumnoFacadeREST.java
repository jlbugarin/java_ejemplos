/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.rest.service;

import java.io.File;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import pe.edu.upc.rest.Alumno;

/**
 *
 * @author pcsijbug
 */
@Stateless
@Path("alumno")
public class AlumnoFacadeREST extends AbstractFacade<Alumno> {
    @PersistenceContext(unitName = "RestPU")
    private EntityManager em;

    public AlumnoFacadeREST() {
        super(Alumno.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Alumno entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Alumno entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Alumno find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Alumno> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Alumno> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("/imagen")
    @Consumes("imagen/png")
    public Response obtenerImagen(){
        
        //url fisica del archivo
        File imagen = new File("E:\\melcocha.png");
        Response.ResponseBuilder resp = Response.ok( imagen);
        resp.header("Content-Disposition","attachment; filename=pepito.png");
        
        
        return resp.build();
    
    
    }
    
    @GET
    @Path("/excel")
    @Produces("application/vnd.ms-excel")
    public Response obtenerExcel(){
        
        //url fisica del archivo
        File imagen = new File("E:\\excel.xlsx");
        Response.ResponseBuilder resp = Response.ok( imagen);
        resp.header("Content-Disposition","attachment; filename=e.xls");
        
        
        
        return resp.build();
    
    
    }
    
    @GET
    @Path("/pdf")
    @Produces("application/pdf")
    public Response obtenerPdf(){
        
        //url fisica del archivo
        File imagen = new File("E:\\p.pdf");
        Response.ResponseBuilder resp = Response.ok( imagen);
        resp.header("Content-Disposition","attachment; filename=archivo.pdf");
        
        
        
        return resp.build();
    
    
    }
    
}
