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
public class Rey extends Pieza {


    public Rey(String color) {
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
        
        if (movimiento.isHorizontal() && Math.abs(movimiento.saltoHorizontal()) == 1) {
            validoMovimiento = true;
            if (movimiento.isVertical() && Math.abs(movimiento.saltoVertical()) == 1) {
                validoMovimiento = true;
                if (movimiento.isDiagonal() && Math.abs(movimiento.saltoHorizontal()) == 1 && Math.abs(movimiento.saltoVertical()) == 1) {
                    validoMovimiento = true;

                }
            }

        }

        return validoMovimiento;
    }

}
