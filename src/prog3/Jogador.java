package prog3;

public class Jogador {
    private String nome;
    private Tabuleiro t;

    public Jogador() {
    }
    
    public Jogador(Tabuleiro t, String nome) {
        this.t = t;
        this.nome = nome;
    }
    
    public void jogar(int l, int c, char simbolo) {
        if (t.verificarPosicao(l, c)) {
            t.jogar(l, c, simbolo);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tabuleiro getT() {
        return t;
    }

    public void setT(Tabuleiro t) {
        this.t = t;
    }

}
