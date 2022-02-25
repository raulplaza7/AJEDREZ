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
public class Caballo extends Pieza {

    

    public Caballo(String color) {
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
        if (Math.abs(movimiento.saltoHorizontal()) == 1 && Math.abs(movimiento.saltoVertical()) == 2) {
            validoMovimiento = true;
        }

        if (Math.abs(movimiento.saltoVertical()) == 1 && Math.abs(movimiento.saltoHorizontal()) == 2) {
            validoMovimiento = true;
        }

        return validoMovimiento;
    }

}
