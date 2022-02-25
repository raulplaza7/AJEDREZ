/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

/**
 *
 * @author raul
 */
public abstract class Pieza {

    private String color;
    private String nombre;

    public Pieza(String color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    public Pieza(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    
    public abstract boolean validoMovimiento(Movimiento movimiento);

    @Override
    public String toString() {
        return this.getClass().getSimpleName().charAt(0)+ Character.toString(color.charAt(0));
    }
    
    
    

}
