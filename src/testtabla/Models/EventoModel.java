/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtabla.Models;

/**
 *
 * @author Ghost
 */
public class EventoModel {
    int id;
    String nombre;
    Boolean disponible;

    
    public EventoModel(){
        id = 0;
        nombre = "";
        disponible = true;
    }
    
    public EventoModel(int nid, String nnombre, Boolean ndis){
        this.id = nid;
        this.nombre = nnombre;
        this.disponible = ndis;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setDisponible(Boolean disponible){
        this.disponible = disponible;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public Boolean getDisponible(){
        return this.disponible;
    }
}
