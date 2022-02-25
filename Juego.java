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
public class Juego {

    private boolean turno; //false blanco true negras

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public Movimiento validarJugada(String jugada, Tablero tablero) {
        Movimiento mov = null;
        //1. sacar 4 enteros del String-> fila inicial, columnainicial, ...
        int filaInicial, columnaInicial, filaFinal, columnaFinal;
        jugada = jugada.toUpperCase();
        //traducción
        if (jugada.length() != 4) {
            System.out.println("La jugada tiene que ser de 4 caracteres. Ejemplo: A4A6");

        } else if (!(jugada.charAt(0) >= 65 && jugada.charAt(0) <= 72)) {
            System.out.println("El primer caracter" + jugada.charAt(0) + " no esta comprendido en el tablero ");
        } else if (!(jugada.charAt(1) >= 49 && jugada.charAt(1) <= 56)) {
            System.out.println("El segundo caracter " + jugada.charAt(2) + "no esta comprendido en el tablero");
        } else if (!(jugada.charAt(2) >= 65 && jugada.charAt(2) <= 72)) {
            System.out.println("El tercer caracter " + jugada.charAt(2) + "no esta comprendido en el tablero");

        } else if (!(jugada.charAt(3) >= 49 && jugada.charAt(3) <= 56)) {
            System.out.println("El cuarto caracter " + jugada.charAt(2) + "no esta comprendido en el tablero");

        }

        columnaInicial = jugada.charAt(0) - 65;
        filaInicial = jugada.charAt(1) - 49;//ojo si queremos que empiece en fila 8-> 0->7
        columnaFinal = jugada.charAt(2) - 65;
        filaFinal = jugada.charAt(3) - 49;
        filaInicial = 7 - filaInicial;
        filaFinal = 7 - filaFinal;
        //aquí ? hay pieza

        if (!tablero.hayPieza(filaInicial, columnaInicial)) {
            System.out.println("No hay pieza en la posición inicial.");
        } else if (tablero.hayPieza(filaInicial, columnaInicial) && tablero.devuelvePieza(filaInicial, columnaInicial).getColor().equalsIgnoreCase(this.traducirString()) == false) {
            System.out.println("No muevas las piezas del contrario");
        } else if (tablero.hayPieza(filaFinal, columnaFinal) && tablero.devuelvePieza(filaFinal, columnaFinal).getColor().equalsIgnoreCase(this.traducirString()) == true) {
            System.out.println("No puedes mover tu pieza a un lugar donde ya hay otra pieza de tu color");

        } else {//si todo ok se crea movimiento
            mov = new Movimiento(new Posicion(filaInicial, columnaInicial), new Posicion(filaFinal, columnaFinal));
        }

        return mov;
    }
    
  

    @Override
    public String toString() {
        if (turno == false) {
            return "Estas en el turno de: BLANCAS";
        } else {
            return "Estas en el turno de: NEGRAS";
        }

    }

    public String traducirString() {
        String turnoString = "blanco";
        if (turno == true) {
            turnoString = "negro";
        }
        return turnoString;
    }

    public void cambiarTurno() {
        if (turno == true) {
            turno = false;
        } else {
            turno = true;
        }
    }

}
