package src.main.java.com.br.blackjack.domain;

import src.main.java.com.br.blackjack.enumerator.JogadorEnum;

import java.util.LinkedList;

public class Jogador {
    private final LinkedList<Carta> cartas = new LinkedList<>();
    private int pontuacao = 0;
    private final JogadorEnum tipoJogador;

    public Jogador(final JogadorEnum tipoJogador) {
        this.tipoJogador = tipoJogador;
    }

    public LinkedList<Carta> getCartas() {
        return cartas;
    }

    public void recebeCarta(final Carta carta) {
        cartas.add(carta);
        pontuacao += carta.getValor();
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public JogadorEnum getTipoJogador() {
        return tipoJogador;
    }
}