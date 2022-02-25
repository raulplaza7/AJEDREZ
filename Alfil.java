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
public class Alfil extends Pieza{
   

    public Alfil(String color) {
       super(color);
    }
    
        /**
     *
     * @param movimiento
     * @return validoMovimiento
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento){
    boolean validoMovimiento = false;
   if(movimiento.isDiagonal()){
    validoMovimiento = true;
    }
    return validoMovimiento;
    }
    
    
}
