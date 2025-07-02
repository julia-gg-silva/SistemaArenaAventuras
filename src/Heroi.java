import java.util.ArrayList;

public abstract class Heroi {
    private String nome;
    private String classe;
    private int nivel = 1;
    private int vidaAtual;
    private int vidaMaxima;
    private int experiencia = 0;
    private boolean statusVivo = true;
    private ArrayList<Item> inventario;

    public Heroi(String nome, int nivel) {
       this.nome = nome;
       this.nivel = nivel;
    }

    public abstract int atacar();

    public void receberDano(int dano){
        this.vidaAtual -= dano;
        if(this.vidaAtual <= 0){
        this.statusVivo = false;
        }
    }

    public void ganharExperiencia(int xp){
       this.experiencia += xp;

       while(this.experiencia >= 100){
           this.experiencia -= 100;
           this.nivel ++;
           this.vidaMaxima = this.nivel * 100;
           this.vidaAtual = this.vidaMaxima;

           System.out.println("Heroi" + this.nome + " subiu de nível para " + this.nivel);
       }
    }

    public void adicionarItem(Item i){
        inventario.add(i);
        System.out.println("O Item " + i.descricao() + " Foi adicionado ao inventário do Heroi" + this.nome);
    }

    public void listarInventario(){
        for(Item i : inventario){
            System.out.println("- " + i.descricao());
        }
    }

    public String toString(){
        return this.nome + " - Nível" + this.nivel +" - "+ "Vida: " +
                this.vidaAtual + "/" + this.vidaMaxima + " - " + "XP: " +
                this.experiencia;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVidaAtual(){
     return vidaAtual;
    }

    public boolean getStatusVivo() {
        return statusVivo;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setStatusVivo(boolean statusVivo) {
        this.statusVivo = statusVivo;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
