package modelos;

public class CelaObj {
    private int id;
    private String localicazao;
    private int capacidade;
    private int nr_de_reclusos;
    private String tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalicazao() {
        return localicazao;
    }

    public void setLocalicazao(String localicazao) {
        this.localicazao = localicazao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getNr_de_reclusos() {
        return nr_de_reclusos;
    }

    public void setNr_de_reclusos(int nr_de_reclusos) {
        this.nr_de_reclusos = nr_de_reclusos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
