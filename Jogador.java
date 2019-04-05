
public class Jogador {

    private int id;
    private String nome;
    private int numBolas;

    Jogador(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.numBolas = 15;
    }

    public int getIdentifier() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getBolas() {
        return numBolas;
    }

    public void incrementarBolas() {
        numBolas++;
    }

    public void decrementarBolas() {
        numBolas--;
    }
}