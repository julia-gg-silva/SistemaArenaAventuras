import java.util.ArrayList;

public class Desafio {
    private int id;
    private String nome;
    private int dificuldade;
    private ArrayList<Heroi> listaParticipantes;
    private boolean status;

    public Desafio( String nome, int dificuldade, int id) {
        this.id = id;
        this.nome = nome;
        this.dificuldade = dificuldade;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        this.dificuldade = dificuldade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
