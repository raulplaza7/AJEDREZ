/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez;

import java.util.Scanner;

/**
 *
 * @author raul
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lector = new Scanner(System.in);
        boolean fin = false;
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        String jugada = null;
        Movimiento mov = null;

        do {
            tablero.pintarTablero();
           System.out.println("Turno de: " + juego); //toString Turno
           System.out.println("Introduce jugada como en el ejemplo: A1A2");
           jugada = lector.nextLine();
           mov = juego.validarJugada(jugada, tablero);
           if (mov != null) {
               if (tablero.devuelvePieza(mov.getPosInicial()).validoMovimiento(mov)) {
                   tablero.ponPieza(tablero.devuelvePieza(mov.getPosInicial()), mov.getPosFinal());
                   tablero.quitarPieza(mov.getPosInicial());
                }

            }
           juego.cambiarTurno();

       } while (fin == false);

    }

}
