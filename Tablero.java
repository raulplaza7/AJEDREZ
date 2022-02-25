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
public class Tablero {

    protected Pieza[][] tablero;

    public Tablero() {
        tablero = new Pieza[8][8];
        tablero[0][0] = new Torre("blanco");
        tablero[0][1] = new Caballo("blanco");
        tablero[0][2] = new Alfil("blanco");
        tablero[0][3] = new Dama("blanco");
        tablero[0][4] = new Rey("blanco");
        tablero[0][5] = new Alfil("blanco");
        tablero[0][6] = new Caballo("blanco");
        tablero[0][7] = new Torre("blanco");
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon("blanco");

        }

        tablero[7][0] = new Torre("negro");
        tablero[7][1] = new Caballo("negro");
        tablero[7][2] = new Alfil("negro");
        tablero[7][3] = new Dama("negro");
        tablero[7][4] = new Rey("negro");
        tablero[7][5] = new Alfil("negro");
        tablero[7][6] = new Caballo("negro");
        tablero[7][7] = new Torre("negro");
        for (int i = 0; i < 8; i++) {
            tablero[6][i] = new Peon("negro");

        }
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                tablero[i][j] = null;

            }
        }//no hace falta

    }

    public void pintarTablero() {
        System.out.println(" A B C D E F G H");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i);
            for (int j = 0; j < 8; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j]);
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println("");

        }
    }

    public boolean hayPieza(int fila, int columna) {
        boolean hayPieza = false;
        if (tablero[fila][columna] != null) {
            hayPieza = true;
        }

        return hayPieza;

    }

    public boolean hayPieza(Posicion posicion) {
        return hayPieza(posicion.getFila(), posicion.getColumna());
    }

    public boolean hayPiezasEntre(Posicion posicion, Movimiento mov, Tablero tablero) {
        boolean hayPiezasEntre = false;
        if (mov.isVertical()) {
            int filaMayor, filaMenor;

            if (mov.getPosInicial().getFila() < mov.getPosFinal().getFila()) {
                filaMayor = mov.getPosFinal().getFila();
                filaMenor = mov.getPosInicial().getFila();

            } else {
                filaMenor = mov.getPosFinal().getFila();
            }
            filaMayor = mov.getPosInicial().getFila();

            for (int i = filaMenor + 1; i < filaMayor && hayPiezasEntre == false; i++) {
               if(tablero.hayPieza(i, mov.getPosInicial().getColumna()))
                hayPiezasEntre = true;

            }

        } 
        
        /*if ((mov.getPosInicial().getFila()) < (mov.getPosFinal().getFila())) {
                for (int i = (mov.getPosInicial().getFila()) + 1; i < (mov.getPosFinal().getFila())&& hayPiezasEntre == false; i++) {
                    //if (tablero.tablero[i][(mov.getPosFinal().getFila())]!){
                    if (tablero.hayPieza(i, mov.getPosFinal().getColumna())) {
                        hayPiezasEntre = false;
                    }

                }
            } else if ((mov.getPosInicial().getFila()) > (mov.getPosFinal().getFila())) {
                for (int i = (mov.getPosFinal().getFila()) + 1; i < (mov.getPosInicial().getFila())&& hayPiezasEntre == false; i++) {
                    if (tablero.hayPieza(i, mov.getPosFinal().getColumna())) {
                        hayPiezasEntre = false;

                    }

                }

            }
        } */
        
        
        else if (mov.isHorizontal()) {
            if ((mov.getPosInicial().getColumna()) < (mov.getPosFinal().getColumna())) {
                for (int i = (mov.getPosInicial().getColumna()) + 1; i < (mov.getPosFinal().getColumna()) && hayPiezasEntre == false; i++) {
                    if (tablero.hayPieza(mov.getPosInicial().getFila(), i)) {
                        hayPiezasEntre = true;
                    }

                }

            } else if ((mov.getPosInicial().getColumna()) > (mov.getPosFinal().getColumna())) {
                for (int i = (mov.getPosFinal().getColumna()) + 1; i < (mov.getPosInicial().getColumna()) && hayPiezasEntre == false; i++) {
                    if (tablero.hayPieza(mov.getPosInicial().getFila(), i)) {
                        hayPiezasEntre = true;
                    }

                }

            }

        } else {
//1 bien
            if (((mov.getPosInicial().getFila()) < (mov.getPosFinal().getFila())) && ((mov.getPosInicial().getColumna()) < (mov.getPosFinal().getColumna()))) {

                for (int i = (mov.getPosInicial().getFila()) + 1; i < (mov.getPosFinal().getFila()) && hayPiezasEntre == false; i++) {
                    for (int j = (mov.getPosInicial().getColumna()) + 1; j < (mov.getPosFinal().getColumna()) && hayPiezasEntre == false; j++) {
                        if (tablero.hayPieza(i, j)) {
                            hayPiezasEntre = true;

                        }

                    }

                }
//2 bien
            } else if (((mov.getPosInicial().getFila()) < (mov.getPosFinal().getFila())) && ((mov.getPosInicial().getColumna()) > (mov.getPosFinal().getColumna()))) {

                for (int i = (mov.getPosInicial().getFila()) + 1; i < (mov.getPosFinal().getFila()) && hayPiezasEntre == false; i++) {
                    for (int j = (mov.getPosFinal().getColumna()) - 1; j < (mov.getPosInicial().getColumna()) && hayPiezasEntre == false; j--) {
                        if (tablero.hayPieza(i, j)) {
                            hayPiezasEntre = true;

                        }

                    }

                }
//3 bien
            } else if (((mov.getPosInicial().getFila()) > (mov.getPosFinal().getFila())) && ((mov.getPosInicial().getColumna()) < (mov.getPosFinal().getColumna()))) {

                for (int i = (mov.getPosFinal().getFila()) - 1; i < (mov.getPosFinal().getFila()) && hayPiezasEntre == false; i--) {
                    for (int j = (mov.getPosInicial().getColumna()) + 1; j < (mov.getPosFinal().getColumna()) && hayPiezasEntre == false; j++) {
                        if (tablero.hayPieza(i, j)) {
                            hayPiezasEntre = true;

                        }

                    }

                }
//4 bien
            } else if (((mov.getPosInicial().getFila()) > (mov.getPosFinal().getFila())) && ((mov.getPosInicial().getColumna()) > (mov.getPosFinal().getColumna()))) {

                for (int i = (mov.getPosFinal().getFila()) - 1; i < (mov.getPosFinal().getFila()) && hayPiezasEntre == false; i--) {
                    for (int j = (mov.getPosFinal().getColumna()) - 1; j < (mov.getPosInicial().getColumna()) && hayPiezasEntre == false; j--) {
                        if (tablero.hayPieza(i, j)) {
                            hayPiezasEntre = true;

                        }

                    }

                }

            }

        }

        return hayPiezasEntre;
    }

    public void ponPieza(Pieza figura, int fila, int columna) {
        if (this.hayPieza(fila, columna)) {
            System.out.println("oye que ya tiene una pieza ahi");
        } else {
            tablero[fila][columna] = figura;
        }

    }

    public void ponPieza(Pieza figura, Posicion posicion) {
        this.ponPieza(figura, posicion.getFila(), posicion.getColumna());
    }

    public void quitarPieza(int fila, int columna) {
        if (hayPieza(fila, columna)) {
            tablero[fila][columna] = null;
        }

    }

    public void quitarPieza(Posicion posicion) {
        this.quitarPieza(posicion.getFila(), posicion.getColumna());
    }

    public Pieza devuelvePieza(int fila, int columna) {

        return tablero[fila][columna];

    }

    public Pieza devuelvePieza(Posicion posicion) {
        return devuelvePieza(posicion.getFila(), posicion.getColumna());
    }

}
