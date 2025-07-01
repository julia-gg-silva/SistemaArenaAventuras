import java.util.ArrayList;

public class Gerenciamento {

    private ArrayList<Heroi> herois;
    private  ArrayList<Desafio> desafios;

    public Gerenciamento() {
        this.herois = new ArrayList<>();
        this.desafios = new ArrayList<>();
    }

    public void adicionarHeroi(Heroi heroi) {
        for (Heroi h : herois) {
            if (h.getNome().equalsIgnoreCase(heroi.getNome())) {
                System.out.println("Herói já cadastrado.");
                return;
            } else {
                this.herois.add(h);
                System.out.println("Herói " + heroi.getNome() + " (" + heroi.getClass().getSimpleName()
                        + ") " + "criado com sucesso! " + "Nível: " + heroi.getNivel() + " Vida: " +
                        heroi.getVidaAtual() + " ");
                if(heroi instanceof Guerreiro){
                    System.out.printf("Força: "+ heroi.getForca());
                }
            }
        }
    }

    public void adicionarDesafio(Desafio desafio) {

    }

    public void atualizarHeroi(Heroi heroi){

    }

    public void bucarHeroi(Heroi heroi) {

    }


}
