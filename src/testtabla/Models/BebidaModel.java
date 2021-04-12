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
public class BebidaModel {
    int id;
    String nombre;
    int denominacion;
    Boolean disponible;
    
    public BebidaModel(){
        id = 0;
        nombre = "";
        denominacion = 0;
        disponible = true;
    }
    
    public BebidaModel(int nid, String nnombre, int nden, Boolean ndis){
        id = nid;
        nombre = nnombre;
        denominacion = nden;
        disponible = ndis;
    }
    
    public BebidaModel(BebidaModel obj){
        this.id = obj.getId();
        this.nombre = obj.getNombre();
        this.denominacion = obj.getDenominacion();
        this.disponible = obj.getDisponible();
    }
    
    public void setId(int i){
        this.id = i;
    }
    
    public void setNombre(String nom){
        this.nombre = nom;
    }
    
    public void setDenominacion(int den){
        this.denominacion = den;
    }
    
    public void setDisponible(Boolean dis){
        this.disponible = dis;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getDenominacion(){
        return this.denominacion;
    }
    
    public Boolean getDisponible(){
        return this.disponible;
    }
    
}
