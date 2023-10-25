package src.main.java.com.br.blackjack.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BlackJackUIUtil {
    public static JLabel rotulo(final String conteudo) {
        var rotulo = new JLabel(conteudo);
        rotulo.setFont(new Font("Arial", Font.BOLD, 18));
        rotulo.setForeground(Color.WHITE);
        return rotulo;
    }

    public static JButton botao(final String conteudo) {
        var botao = new JButton(conteudo);
        botao.setBackground(new Color(0x509B68));
        botao.setForeground(Color.WHITE);
        botao.setBorder(borda());
        return botao;
    }

    public static Border borda() {
        var espacoInterno = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        var espessuraBorda = BorderFactory.createLineBorder(new Color(0x3f8254), 2);
        return BorderFactory.createCompoundBorder(espessuraBorda, espacoInterno);
    }

    public static JPanel botao(final JButton botao) {
        var painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));

        var caixa = Box.createHorizontalBox();
        caixa.add(Box.createHorizontalGlue());
        caixa.add(botao);
        caixa.add(Box.createHorizontalGlue());

        painel.add(Box.createVerticalGlue());
        painel.add(caixa);
        painel.add(Box.createVerticalGlue());
        return painel;
    }

    public static JPanel painel(JLabel label, JLabel placar, JLayeredPane cartas) {
        var painel = new JPanel();
        painel.setBorder(BlackJackUIUtil.borda());
        painel.setLayout(new BoxLayout(painel, BoxLayout.X_AXIS));
        painel.add(label);
        painel.add(placar);
        painel.add(cartas);
        painel.setBackground(new Color(0x509B68));
        return painel;
    }

    public static void modal(JFrame quadroPrincipal, String mensagem) {
        var modal = new JDialog(quadroPrincipal, "FIM DA PARTIDA", true);
        modal.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        modal.setSize(new Dimension(300, 100));
        modal.setResizable(false);

        var painelBotao = new JPanel();
        var encerrarPartida = new JButton("ENCERRAR PARTIDA");
        var novaPartida = new JButton("NOVA PARTIDA");

        encerrarPartida.addActionListener(e -> quadroPrincipal.dispose());

        novaPartida.addActionListener(o -> {
            quadroPrincipal.dispose();
            new BlackJackUI();
        });

        painelBotao.add(encerrarPartida);
        painelBotao.add(novaPartida);

        var painel = new JPanel();
        painel.add(new JLabel(mensagem));
        painel.add(painelBotao);

        modal.add(painel);
        modal.setLocationRelativeTo(quadroPrincipal);
        modal.setVisible(true);
    }
}
