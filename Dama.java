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
public class Dama extends Pieza {

    
    public Dama(String color) {
        super(color);
    }

    /**
     *
     * @param movimiento
     * @return validoMovimiento
     */
    @Override
    public boolean validoMovimiento(Movimiento movimiento) {
        boolean validoMovimiento = false;
        if (movimiento.isDiagonal() || movimiento.isHorizontal() || movimiento.isVertical()) {
            validoMovimiento = true;

        }

        return validoMovimiento;
    }

}
