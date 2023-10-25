package src.main.java.com.br.blackjack.domain;

public class BlackJack {
    public boolean JOGO_ENCERRADO = false;
    public String RESULTADO;

    public BlackJack avaliarPontuacao(final Jogador jogador, final Jogador mesa) {
        var pontuacaoJogador = jogador.getPontuacao();
        var pontuacaoMesa = mesa.getPontuacao();

        if ((pontuacaoJogador > 21 && pontuacaoMesa > 21) || (jogador == mesa)) {
            this.JOGO_ENCERRADO = true;
            this.RESULTADO = "EMPATE";
        }

        else if (pontuacaoJogador == 21 || (pontuacaoMesa > 21 && pontuacaoJogador <= 21)) {
            this.JOGO_ENCERRADO = true;
            this.RESULTADO = String.format("%s VENCEU", jogador.getTipoJogador());
        }

        else if (pontuacaoMesa == 21 || (pontuacaoJogador > 21 && pontuacaoMesa <= 21)) {
            this.JOGO_ENCERRADO = true;
            this.RESULTADO = String.format("%s VENCEU", mesa.getTipoJogador());
        }

        else if (pontuacaoJogador > 21) {
            this.JOGO_ENCERRADO = true;
            this.RESULTADO = String.format("%s VENCEU", mesa.getTipoJogador());

        }

        else if (pontuacaoMesa > 21) {
            this.JOGO_ENCERRADO = true;
            this.RESULTADO = String.format("%s VENCEU", jogador.getTipoJogador());
        }

        else {
            this.JOGO_ENCERRADO = false;
            this.RESULTADO = null;
        }

        return this;
    }
}
