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
    
    public void EventoModel(){
        id = 0;
        nombre = "";
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
