/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtabla;

enum enumDenominacion{
    MILILITROS,
    MEDIOLITROS,
    LITROS,
    DOSLITROS,
    TRESLITROS
}

/**
 *
 * @author Ghost
 */
public class PredictorModel {
    int id;
    String nombre;
    int cantidad;
    int denominacion;
}
