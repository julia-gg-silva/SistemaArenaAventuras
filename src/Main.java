import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final Gerenciamento ger = new Gerenciamento();

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        int opcao = 0;
        do {
            System.out.println("=== ARENA DE AVENTURAS ===");
            System.out.println("1. Gerenciar Heróis");
            System.out.println("2. Gerenciar Desafios");
            System.out.println("3. Participação de Desafios");
            System.out.println("4. Consulta de Relatórios");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção: _");
            opcao = sc.nextInt();
        } while (opcao != 5);
        switch (opcao) {
            case 1:
                menuGerenciarHerois();
                break;
            case 2:
                menuGerenciarDesafios();
                break;
            case 3:
                menuParticiparDesafios();
                break;
            case 4:
                menuRelatorios();
                break;
            case 5:
                System.out.println("== Sistema encerrado! ==");
                break;
        }
    }

    private static void menuRelatorios() {
        System.out.println("--- Consultas e Relatórios ---");
        System.out.println("1. Listar Heróis");
        System.out.println("2. Listar Desafios");
        System.out.println("3. Buscar Herói por Nome");
        System.out.println("4. Exibir Inventário de Herói");
        System.out.println("5. Agrupar Heróis por Nível");
        System.out.println("6. Agrupar Desafios por Dificuldade");
        System.out.println("7. Voltar ao Menu Principal");
        System.out.println("Escolha: _");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                listarHerois();
                break;
            case 2:
                listarDesafios();
                break;
            case 3:
                buscarHeroi();
                break;
            case 4:
                exibirInventario();
                break;
            case 5:
                agruparPorNivel();
                break;
            case 6:
                agruparDesafioPorDificuldade();
                break;
            case 7:
                break;
            default:
                System.err.println("Opção invalida! Tente novamente!");
        }
    }

    private static void menuParticiparDesafios() {
        System.out.println("--- Participação em Desafios ---");
        System.out.println("1. Adicionar Herói a Desafio");
        System.out.println("2. Remover Herói de Desafio");
        System.out.println("3. Iniciar Desafio");
        System.out.println("4. Voltar ao menu Principal");
        System.out.println("Escolha: _");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                addHeroiADesafio();
                break;
            case 2:
                removerHeroiDeDesafio();
                break;
            case 3:
                iniciarDesafio();
                break;
            case 4:
                break;
            default:
                System.err.println("Opção invalida! Tente novamente!");
        }
    }

    private static void menuGerenciarDesafios() {
        System.out.println("--- Gerenciar Desafios ---");
        System.out.println("1. Criar Deasfio");
        System.out.println("2. Atualizar Desafio");
        System.out.println("3. Remover Desafio");
        System.out.println("4. Voltar ao menu Principal");
        System.out.println("Escolha: _");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                criarDesafio();
                break;
            case 2:
                atualizarDesafio();
                break;
            case 3:
                removerDesafio();
                break;
            case 4:
                break;
            default:
                System.err.println("Opção invalida! Tente novamente!");
        }
    }

    private static void menuGerenciarHerois() {
        System.out.println("--- Gerenciar Heróis ---");
        System.out.println("1. Criar Herói");
        System.out.println("2. Atualizar Herói");
        System.out.println("3. Remover Herói");
        System.out.println("4. Voltar ao menu Principal");
        System.out.println("Escolha: _");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                criarHeroi();
                break;
            case 2:
                atualizarHeroi();
                break;
            case 3:
                removerHeroi();
                break;
            case 4:
                break;
            default:
                System.err.println("Opção invalida! Tente novamente!");
        }
    }

    private static void criarHeroi() {
        System.out.println("--- Criar Heroi ---");

        System.out.println("Informe o nome do Heroi");
        String nome = sc.nextLine();

        System.out.println("\n Informe a Classe (1-Guerreiro, 2-Mago, 3-Arqueiro): ");
        int classe = sc.nextInt();

        System.out.println("\n Informe o Nível inicial: ");
        int nivel = sc.nextInt();

        if (classe == 1) {
            System.out.println("\n Informe o valor da Força: ");
            int forca = sc.nextInt();

            Guerreiro guerreiro = new Guerreiro(nome, nivel, forca);
            ger.adicionarHeroi(guerreiro);

        } else if (classe == 2) {
            System.out.println("\n Informe o valor da Inteligência: ");
            int inteligencia = sc.nextInt();

            Mago mago = new Mago(nome, nivel, inteligencia);

        } else if (classe == 3) {
            System.out.println("\n Informe o valor da Destreza: ");
            int destreza = sc.nextInt();

            Arqueiro arqueiro = new Arqueiro(nome, nivel, destreza);
        }
    }


}