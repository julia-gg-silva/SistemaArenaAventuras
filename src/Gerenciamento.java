import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;

public class Gerenciamento {

    private ArrayList<Heroi> herois;
    private ArrayList<Desafio> desafios;

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
                if (heroi instanceof Guerreiro) {
                    System.out.printf("Força: " + ((Guerreiro) heroi).getForca());
                } else if (heroi instanceof Mago) {
                    System.out.println("Inteligencia: " + ((Mago) heroi).getInteligencia());
                } else if (heroi instanceof Arqueiro) {
                    System.out.println("Destreza: " + ((Arqueiro) heroi).getDestreza());
                }
            }
        }
    }

    public Heroi buscarHeroiPorNome(String nome) {
        for (Heroi heroi : herois) {
            if (heroi.getNome().equalsIgnoreCase(nome)) {
                return heroi;
            }
        }
        return null;
    }

    public void listarHerois() {
        System.out.println("--- Lista de Heróis ---");
        for (Heroi heroi : herois) {
            System.out.println("Nome: " + heroi.getNome());
            System.out.println("Classe: " + heroi.getClass().getSimpleName());
            System.out.println("Nível: " + heroi.getNivel());
            System.out.println("Vida: " + heroi.getVidaAtual());
            System.out.println("Experiência: " + heroi.getExperiencia());
            System.out.println("Itens\n: " + heroi.getInventario());
        }
    }

    public void listarDesafios() {
        System.out.println("--- Lista de Desafios ---");
        for (Desafio desafio : desafios) {
            System.out.println("ID: " + desafio.getId());
            System.out.println("Nome: " + desafio.getNome());
            System.out.println("Dificuldade: " + desafio.getDificuldade());
            System.out.println("Status: " + desafio.getStatus());
            System.out.println("Lista participantes: \n" + desafio.getListaParticipantes());
        }
    }


    public void atualizarHeroiGerenciamento(Heroi heroi, int nivel, int vidaAtual) {
        if (nivel < 1 || vidaAtual < 1) {
            System.out.println("Valores inválidos! tente novamente.");
            return;
        }

        heroi.setNivel(nivel);
        heroi.setVidaAtual(vidaAtual);
        heroi.setVidaMaxima(heroi.getNivel() * 100);

        System.out.println("Nível de '" + heroi.getNome() + "' atualizado para " + heroi.getNivel() + ".\nVida atual ajustada para " + heroi.getVidaAtual());
    }

    public void removerHeroi(Heroi heroi) {
        herois.remove(heroi);
        System.out.println("Herói '" + heroi.getNome() + "' removido com sucesso!");
    }

    public void criarDesafioGerenciamento(String nome, int dificuldade, int contadorIds) {

        Desafio desafio = new Desafio(nome, dificuldade, contadorIds);
        this.desafios.add(desafio);
        System.out.println("Desafio '" + desafio.getNome() + "' criado com ID " + desafio.getId() + ", Dificuldade: " + desafio.getDificuldade());
    }

    public Desafio buscarDesafioPorNome(String nome) {
        for (Desafio desafio : desafios) {
            if (desafio.getNome().equalsIgnoreCase(nome)) {
                return desafio;
            }
        }
        return null;
    }

    public Desafio buscarDesafioPorId(int id) {
        for (Desafio desafio : desafios) {
            if (desafio.getId() == id) {
                return desafio;
            }
        }
        return null;
    }

    public void atualizarDesafioGerenciamento(Desafio desafio, String nome, int dificuldade) {
        if (nome.isEmpty() || dificuldade > 3 || dificuldade < 1) {
            System.out.println("Valores inválidos! tente novamente.");
            return;
        } else {
            desafio.setNome(nome);
            desafio.setDificuldade(dificuldade);

            System.out.println("Dificuldade de '" + desafio.getNome() + "' alterada para " + desafio.getDificuldade() + (desafio.getDificuldade() == 1 ? "(Facil)" : desafio.getDificuldade() == 2 ? "(Medio)" : desafio.getDificuldade() == 3 ? "(Difícil)" : ""));
        }

    }

    public void removerDesafio(Desafio desafio) {
        desafios.remove(desafio);

        System.out.println("Desafio ID " + desafio.getId() + " removido com sucesso!");
    }

    public void addHeroiADesafioGerenciamento(int id, String nome) {
        Desafio desafio = buscarDesafioPorId(id);
        Heroi heroi = buscarHeroiPorNome(nome);
        if (desafio == null || heroi == null) {
            System.out.println("Desafio e/ou Herói não existe! Tente novamente.");
            return;
        } else if (!heroi.getStatusVivo()) {
            System.out.println("Somentei Heróis vivos podem ser adicionados a um Desafio");
        } else if (desafio.getListaParticipantes().contains(heroi)) {
            System.out.println("O Herói já está participando desse desafio.");
        } else {
            desafio.getListaParticipantes().add(heroi);
            System.out.println("Herói '" + heroi.getNome() + "' foi adicionado a Desafio " + desafio.getNome() + "'");
        }
    }

    public void removerHeroiDeDesafioGerenciamento(int id, String nome) {

        Desafio desafio = buscarDesafioPorId(id);
        Heroi heroi = buscarHeroiPorNome(nome);

        if (desafio == null || heroi == null) {
            System.out.println("Desafio e/ou Herói não existe! Tente novamente.");
            return;
        } else if (desafio.getListaParticipantes().contains(heroi)) {
            desafio.getListaParticipantes().remove(heroi);
            System.out.println("Herói '" + heroi.getNome() + "' foi removido do Desafio " + desafio.getNome() + "'");
        } else {
            System.out.println("O Herói informado não está participando desse desafio.");
        }
    }

    public void iniciarDesafioGerenciamento(int id) {
        Desafio desafio = buscarDesafioPorId(id);
        int minimoParticipantes = desafio.getDificuldade() + 1;
        boolean itemPocao = true;

        if (desafio.getStatus()) {
            System.out.println("Este desafio já foi concluído! Tente outro desafio.");
        } else if (desafio.getListaParticipantes().size() < minimoParticipantes) {
            System.out.println("O Desafio não possuí participantes suficientes!");
            System.out.println("Quantidade de participantes necessários para este desafio: " + minimoParticipantes);
        } else {
            System.out.println("Iniciando Desafio '" + desafio.getNome() + "' (ID " + desafio.getId() + ")...");
            for (Heroi heroi : desafio.getListaParticipantes()) {
                int nivelAntes = heroi.getNivel();

                int dano = heroi.atacar();

                int xp = desafio.getDificuldade() * 50;
                heroi.ganharExperiencia(xp);
                int nivelDepois = heroi.getNivel();

                Item item;
                if (itemPocao) {
                    item = new Pocao();
                } else {
                    item = new Espada();
                }
                heroi.getInventario().add(item);
                itemPocao = !itemPocao;

                System.out.print("- " + heroi.getNome() + ": +" + xp + "XP");

                if (nivelDepois > nivelAntes) {
                    System.out.print(" (Subiu para o Nível " + nivelDepois + ")");
                } else {
                    System.out.println(" (Permanece no Nível " + nivelAntes + ")");
                }

                if (item instanceof Pocao) {
                    System.out.print(", recebeu Poção de Vida (+" + ((Pocao) item).getCura() + " HP)");
                } else {
                    System.out.print(" recebeu Espada(+ " + ((Espada) item).getBonus() + " de Dano)");
                }
            }

            System.out.println("Desafio '" + desafio.getNome() + "' concluído!");
            desafio.setStatus(true);
        }
    }


    public void exibirInventarioGerenciamento(String nome) {

        Heroi heroi = buscarHeroiPorNome(nome);

        if (heroi != null) {
            for (Heroi hero : herois) {
                System.out.println(hero.getInventario());
            }

        } else {
            System.out.println("Herói não encontrado! Tente novamente.");
        }
    }

    public void agruparPorNivel() {
        for (int nivel = 1; nivel <= 5; nivel++) {
            boolean encontrado = false;

            for (Heroi heroi : herois) {
                if (heroi.getNivel() == nivel) {
                    if (!encontrado) {
                        System.out.println("Nível " + nivel + ":");
                        encontrado = true;
                    }
                    System.out.println("- " + heroi.getNome());
                }
            }
        }
    }

    public void agruparDesafioPorDificuldade() {
        System.out.println("Fácil: ");
        for (Desafio desafio : desafios) {
            if (desafio.getDificuldade() == 1) {
                System.out.println("ID: " + desafio.getId() + " | Nome: " + desafio.getNome());
            }
        }
        System.out.println("\nMédio: ");
        for (Desafio desafio : desafios) {
            if (desafio.getDificuldade() == 2) {
                System.out.println("ID: " + desafio.getId() + " | Nome: " + desafio.getNome());
            }
        }

        System.out.println("Dificíl: ");
        for (Desafio desafio : desafios) {
            if (desafio.getDificuldade() == 3) {
                System.out.println("ID: " + desafio.getId() + " | Nome: " + desafio.getNome());
            }
        }



    }
}
