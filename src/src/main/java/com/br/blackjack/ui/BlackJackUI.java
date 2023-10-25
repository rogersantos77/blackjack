package src.main.java.com.br.blackjack.ui;

import src.main.java.com.br.blackjack.domain.Baralho;
import src.main.java.com.br.blackjack.domain.BlackJack;
import src.main.java.com.br.blackjack.domain.Jogador;
import src.main.java.com.br.blackjack.enumerator.JogadorEnum;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BlackJackUI extends JFrame {
    private final Jogador jogador = new Jogador(JogadorEnum.JOGADOR);
    private final Jogador mesa = new Jogador(JogadorEnum.MESA);
    private final Baralho baralho = new Baralho();

    private final JLabel placarJogador = BlackJackUIUtil.rotulo("0");
    private final JLabel placarMesa = BlackJackUIUtil.rotulo("0");

    private final JButton novaCarta = BlackJackUIUtil.botao("NOVA CARTA");

    private final JLayeredPane cartasJogador = new JLayeredPane();
    private final JLayeredPane cartasMesa = new JLayeredPane();

    public BlackJackUI() {
        setTitle("Jogo 21 | BlackJack");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        setResizable(false);
        setMinimumSize(new Dimension(800, 600));

        add(BlackJackUIUtil.painel(BlackJackUIUtil.rotulo("JOGADOR: "), placarJogador, cartasJogador));
        add(BlackJackUIUtil.painel(BlackJackUIUtil.rotulo("MESA: "), placarMesa, cartasMesa));
        add(BlackJackUIUtil.botao(novaCarta));

        novaCarta.addActionListener(o -> {
            this.comprarCartaEAtualizarPlacar(jogador, placarJogador, cartasJogador);
            this.comprarCartaEAtualizarPlacar(mesa, placarMesa, cartasMesa);
            this.validaPontuacao();
        });

        setVisible(true);
    }

    private void comprarCartaEAtualizarPlacar(Jogador jogador, JLabel placar, JLayeredPane cartas) {
        comprarCarta(jogador, placar);
        adicionarCartaAoPainel(jogador, cartas);
    }

    private void validaPontuacao() {
        var partida = new BlackJack().avaliarPontuacao(jogador, mesa);

        if (partida.JOGO_ENCERRADO) BlackJackUIUtil.modal(this, partida.RESULTADO);
    }

    private void adicionarCartaAoPainel(final Jogador jogador, final JLayeredPane painel) {
        painel.removeAll();

        var cartas = jogador.getCartas();

        for (int i = 0, j = cartas.size(); i < j; i++) {
            try {
                var imagemMenor = new ImageIcon(ImageIO.read(getClass().getResource(cartas.get(i).getImagem()))).getImage().getScaledInstance(100, 150, Image.SCALE_SMOOTH);

                var imagem = new ImageIcon(imagemMenor);
                var cartaLabel = new JLabel(imagem);

                int x = 20 + i * 60;
                int y = 40;

                cartaLabel.setBounds(x, y, imagem.getIconWidth(), imagem.getIconHeight());
                painel.setLayer(cartaLabel, i);
                painel.add(cartaLabel);
            }
            catch (IOException e) {
            }
        }

        painel.revalidate();
    }

    private void comprarCarta(final Jogador jogador, final JLabel placar) {
        jogador.recebeCarta(this.baralho.distribuirCarta());
        placar.setText(String.valueOf(jogador.getPontuacao()));
    }
}