
public class Jogador {

    private Int id;
    private String nome;
    private Int numBolas;

    Jogador(Int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.numBolas = 15;
    }

    public String getIdentifier() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Int getBolas() {
        return numBolas;
    }

    public void incrementarBolas() {
        numBolas++;
    }

    public void decrementarBolas() {
        numBolas--;
    }
}