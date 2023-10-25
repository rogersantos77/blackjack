package src.main.java.com.br.blackjack.domain;

public class Carta {
    private final String valor;
    private final String naipe;

    public Carta(final String valor, final String naipe) {
        this.valor = valor;
        this.naipe = naipe;
    }

    public int getValor() {
        switch (valor) {
            case "A":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            default:
                return 10; // Para cartas "10", "J", "Q" e "K"
        }
    }

    @Override
    public String toString() {
        return String.format("%s-%s", this.valor, this.naipe);
    }

    public String getImagem() {
        return "/cartas/" + this + ".png";
    }
}