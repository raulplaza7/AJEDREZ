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
public class Movimiento {

    private Posicion posInicial;
    private Posicion posFinal;

    public Posicion getPosInicial() {
        return posInicial;
    }

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }

    public boolean isVertical() {
        boolean isVertical = false;
        if (this.posInicial.getColumna() == this.posFinal.getColumna()) {
            isVertical = true;
        }
        return isVertical;
    }

    public boolean isHorizontal() {
        boolean isHorizontal = false;
        if (this.posInicial.getFila() == this.posFinal.getFila()) {
            isHorizontal = true;
        }
        return isHorizontal;
    }

    public boolean isDiagonal() {
        boolean isDiagonal = false;
        if (this.saltoHorizontal() == this.saltoVertical()) {
            isDiagonal = true;
        }
        return isDiagonal;
    }

    public int saltoHorizontal() {
        int saltoHorizontal;
        saltoHorizontal = Math.abs(this.posInicial.getFila()) - Math.abs(this.posFinal.getFila());

        return saltoHorizontal;

    }

    public int saltoVertical() {
        int saltoVertical;
        saltoVertical = Math.abs(this.posInicial.getColumna()) - Math.abs(this.posFinal.getColumna());
        
        return saltoVertical;

    }

}
