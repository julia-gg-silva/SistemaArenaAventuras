public class Arqueiro extends Heroi{

    private int destreza;

    public Arqueiro(String nome, int nivel, int destreza) {
        super(nome, nivel);
        if(destreza <= 0){
            System.err.println("Destreza inválida! Atribuindo valor padrão 1");
            this.destreza = 1;
        }else{
            this.destreza = destreza;
        }
    }

    @Override
    public int atacar() {
        int dano = destreza * this.getNivel() + 5;
        for(Item item : getInventario()){
            if(item instanceof Espada){
                dano += ((Espada) item).getBonus();
            }
        }

        return dano;
    }

    @Override
    public String toString() {
        return super.toString() + " - Destreza: " + destreza;
    }

    public int getDestreza() {
        return destreza;
    }
}
