import com.sun.source.tree.ReturnTree;

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
                    System.out.printf("Força: "+ ((Guerreiro) heroi).getForca());
                }else if(heroi instanceof Mago){
                    System.out.println("Inteligencia: "+ ((Mago) heroi).getInteligencia());
                }else if(heroi instanceof Arqueiro){
                    System.out.println("Destreza: " + ((Arqueiro) heroi).getDestreza());
                }
            }
        }
    }

    public Heroi buscarHeroiPorNome(String nome){
        for(Heroi heroi : herois){
            if(heroi.getNome().equalsIgnoreCase(nome)){
                return heroi;
            }
        }
        return null;
    }

    public void atualizarHeroiGerenciamento(Heroi heroi, int nivel, int vidaAtual){
        if(nivel < 1 || vidaAtual < 1){
            System.out.println("Valores inválidos! tente novamente.");
            return;
        }

        heroi.setNivel(nivel);
        heroi.setVidaAtual(vidaAtual);
        heroi.setVidaMaxima(heroi.getNivel()*100);

        System.out.println("Nível de '" + heroi.getNome()+ "' atualizado para "+ heroi.getNivel()+ ".\nVida atual ajustada para "+ heroi.getVidaAtual());
    }

    public void removerHeroi(Heroi heroi) {
        herois.remove(heroi);
        System.out.println("Herói '" + heroi.getNome()+ "' removido com sucesso!" );
    }

    public void criarDesafioGerenciamento(String nome, int dificuldade, int contadorIds) {

        Desafio desafio = new Desafio(nome, dificuldade, contadorIds);
        this.desafios.add(desafio);
        System.out.println("Desafio '"+ desafio.getNome()+"' criado com ID "+desafio.getId()+", Dificuldade: "+desafio.getDificuldade());
    }

    public Desafio buscarDesafioPorNome(String nome){
        for(Desafio desafio : desafios){
            if(desafio.getNome().equalsIgnoreCase(nome)){
                return desafio;
            }
        }
        return null;
    }

    public Desafio buscarDesafioPorId(int id){
        for(Desafio desafio : desafios){
            if(desafio.getId() == id){
                return desafio;
            }
        }
        return null;
    }

    public void atualizarDesafioGerenciamento(Desafio desafio, String nome, int dificuldade) {
        if(nome.isEmpty() || dificuldade > 3 || dificuldade < 1){
            System.out.println("Valores inválidos! tente novamente.");
            return;
        }else{
            desafio.setNome(nome);
            desafio.setDificuldade(dificuldade);

            System.out.println("Dificuldade de '"+ desafio.getNome() + "' alterada para "+ desafio.getDificuldade() + (desafio.getDificuldade() == 1 ? "(Facil)" : desafio.getDificuldade() == 2 ? "(Medio)" :  desafio.getDificuldade()==3 ? "(Difícil)" : ""));
        }

    }

    public void removerDesafio(Desafio desafio){
        desafios.remove(desafio);

        System.out.println("Desafio ID "+ desafio.getId() +" removido com sucesso!");
    }

    public void adicionarDesafio(Desafio desafio) {

    }

    public void atualizarHeroi(Heroi heroi){

    }

    public void bucarHeroi(Heroi heroi) {

    }


}
