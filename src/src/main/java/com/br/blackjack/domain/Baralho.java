package src.main.java.com.br.blackjack.domain;

import java.util.Collections;
import java.util.LinkedList;

public class Baralho {
    // FIFO
    private LinkedList<Carta> cartas = new LinkedList<>();

    public Baralho() {
        montarBaralho();
        embaralhar();
        distribuirCarta();
    }

    private void montarBaralho() {
        var valores = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        var naipes = new String[]{"PAUS", "OUROS", "COPAS", "ESPADAS"};

        for (var naipe : naipes) {
            for (var valor : valores) {
                cartas.add(new Carta(valor, naipe));
            }
        }
    }

    private void embaralhar() {
        Collections.shuffle(cartas);
    }

    public Carta distribuirCarta() {
        return cartas.poll();
    }
}