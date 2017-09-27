/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.modelo;

import java.util.List;

/**
 *
 * @author pcsijbug
 */
public class ResPokemon {
    
    private String name;
    private String modified;
    private String created;
    private List<Poke> pokemon;
    private String resource_uri;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the modified
     */
    public String getModified() {
        return modified;
    }

    /**
     * @param modified the modified to set
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * @return the created
     */
    public String getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * @return the pokemon
     */
    public List<Poke> getPokemon() {
        return pokemon;
    }

    /**
     * @param pokemon the pokemon to set
     */
    public void setPokemon(List<Poke> pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * @return the resource_uri
     */
    public String getResource_uri() {
        return resource_uri;
    }

    /**
     * @param resource_uri the resource_uri to set
     */
    public void setResource_uri(String resource_uri) {
        this.resource_uri = resource_uri;
    }

    
    
}
