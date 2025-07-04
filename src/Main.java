import com.sun.security.jgss.GSSUtil;

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
                ger.listarHerois();
                break;
            case 2:
                ger.listarDesafios();
                break;
            case 3:
                buscarHeroi();
                break;
            case 4:
                exibirInventario();
                break;
            case 5:
                ger.agruparPorNivel();
                break;
            case 6:
                ger.agruparDesafioPorDificuldade();
                break;
            case 7:
                break;
            default:
                System.err.println("Opção invalida! Tente novamente!");
        }
    }

    private static void exibirInventario() {
        System.out.println("--- Exibir inventário do Herói ---");
        System.out.println("Informe o nome do Herói que deseja verificar o inventário");
        String nome = sc.next();

        ger.exibirInventarioGerenciamento(nome);
    }

    private static void buscarHeroi() {
        System.out.println("--- Buscar Heroi ---");
        System.out.println("Informe o nome do Heroi que deseja buscar: ");
        String nome = sc.next();

        Heroi heroi = ger.buscarHeroiPorNome(nome);

        if(heroi != null) {
            System.out.println("Nome: " + heroi.getNome());
            System.out.println("Classe: " + heroi.getClass().getSimpleName());
            System.out.println("Nível: " + heroi.getNivel());
            System.out.println("Vida: " + heroi.getVidaAtual());
            System.out.println("Experiência: " + heroi.getExperiencia());
            System.out.println("Itens\n: " + heroi.getInventario());
        }else{
            System.out.println("Heroi não encontrado! Tente novamente!");
            return;
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

    private static void iniciarDesafio() {

        System.out.println("--- Inciar Desafio ---");
        System.out.println("Informe o ID do desafio que deseja realizar: ");
        int id = sc.nextInt();

        ger.iniciarDesafioGerenciamento(id);
    }


    private static void removerHeroiDeDesafio() {

        System.out.println("--- Removendo Herói de Desafio ---");

        System.out.println("Informe o ID do Desafio: ");
        int id = sc.nextInt();

        System.out.println("Informe o Nome do Herói que deseja remover de Desafio: ");
        String nome = sc.next();

        ger.removerHeroiDeDesafioGerenciamento(id, nome);
    }

    private static void addHeroiADesafio() {
        System.out.println("--- Adicionar Herói a Desafio ---");

        System.out.println("Informe o ID do Desafio: ");
        int id = sc.nextInt();

        System.out.println("Informe o Nome do Herói que deseja adicionar no Desafio: ");
        String nome = sc.next();

        ger.addHeroiADesafioGerenciamento(id, nome);
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

    private static void removerDesafio() {

        System.out.println("--- Remover Desafio ---");

        System.out.println("Informe o ID do Desafio que deseja remover: ");
        int id = sc.nextInt();

        Desafio desafio = ger.buscarDesafioPorId(id);

        if (desafio == null) {
            System.out.println("O Desafio não existe! Tente novamente!");
            return;
        }else {
            System.out.println("Você tem certeza que deseja remover o Desafio '" + desafio.getNome()+"'?");
            System.out.println("Sim - 1 | Não - 2");
            int opcao = sc.nextInt();
            if(opcao == 1){
                ger.removerDesafio(desafio);
            }else if(opcao == 2){
                System.out.println("Ação cancelada!");
                return;
            }else{
                System.out.println("Valor inválido! Tente novamente!");
                return;
            }
        }
    }

    private static void atualizarDesafio() {

        System.out.println("--- Atulizar Desafio ---");

        sc.nextLine();
        System.out.println("Informe o ID do Desafio que deseja atualizar: ");
        int id = sc.nextInt();

        Desafio desafio = ger.buscarDesafioPorId(id);

        if (desafio == null) {
            System.out.println("O Desafio não existe! Tente novamente!");
            return;
        }else{
            System.out.println("- Alterar atributos -");
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Dificuldade (1-3): ");
            int dificuldade = sc.nextInt();

            ger.atualizarDesafioGerenciamento(desafio, nome, dificuldade);
        }
    }

    private static void criarDesafio() {
        int contadorIds = 0;
        System.out.println("--- Criar Desafio ---");

        System.out.println("Informe o nome do Desafio: ");
        String nome = sc.nextLine();

        Desafio desafio = ger.buscarDesafioPorNome(nome);

        if (desafio != null) {
            System.out.println("O Desafio já existe! Tente novamente!");
            return;
        }else {
            System.out.println("\n Informe a Dificuldade (1-3): ");
            int dificuldade = sc.nextInt();

            contadorIds++;

            ger.criarDesafioGerenciamento(nome, dificuldade, contadorIds);
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

    private static void removerHeroi() {
        System.out.println("--- Remover Herói ---");

        sc.nextLine();
        System.out.println("Informe o nome do Herói que deseja remover: ");
        String nome = sc.nextLine();

        Heroi heroi = ger.buscarHeroiPorNome(nome);

        if(heroi == null){
            System.out.println("O Herói não existe! Tente novamente!");
            return;
        }else{
            System.out.println("Você tem certeza que deseja remover o Herói '" + heroi.getNome()+"'?");
            System.out.println("Sim - 1 | Não - 2");
            int opcao = sc.nextInt();
            if(opcao == 1){
                ger.removerHeroi(heroi);
            }else if(opcao == 2){
                System.out.println("Ação cancelada!");
                return;
            }else{
                System.out.println("Valor inválido! Tente novamente!");
                return;
            }
        }
    }

    private static void atualizarHeroi() {
        System.out.println("--- Atulizar Herói ---");

        sc.nextLine();
        System.out.println("Informe o nome do Herói que deseja atualizar: ");
        String nome = sc.nextLine();

        Heroi heroi = ger.buscarHeroiPorNome(nome);

        if (heroi == null) {
            System.out.println("O Herói não existe! Tente novamente!");
            return;
        }else{
            System.out.println("- Alterar atributos -");
            System.out.println("Nivel: ");
            int nivel = sc.nextInt();
            System.out.println("Vida Atual: ");
            int vidaAtual = sc.nextInt();

            ger.atualizarHeroiGerenciamento(heroi, nivel, vidaAtual);
        }
    }

    private static void criarHeroi() {
        System.out.println("--- Criar Herói ---");

        System.out.println("Informe o nome do Herói");
        String nome = sc.nextLine();

        Heroi heroi = ger.buscarHeroiPorNome(nome);

        if (heroi != null) {
            System.out.println("O Herói já existe! Tente novamente!");
            return;
        }

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
            ger.adicionarHeroi(mago);

        } else if (classe == 3) {
            System.out.println("\n Informe o valor da Destreza: ");
            int destreza = sc.nextInt();

            Arqueiro arqueiro = new Arqueiro(nome, nivel, destreza);
            ger.adicionarHeroi(arqueiro);
        }
    }


}