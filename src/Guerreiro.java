public class Guerreiro extends Heroi{

    private int forca;

    public Guerreiro(String nome, int nivel, int forca) {
        super(nome, nivel);
        if(forca <= 0){
            System.err.println("Força inválida! Atribuindo valor padrão 1");
            this.forca = 1;
        }else{
            this.forca = forca;
        }
    }

    @Override
    public int atacar() {
        int dano =  forca * getNivel();

        for(Item item : getInventario()){
            if(item instanceof Espada){
                dano += ((Espada) item).getBonus();
            }
        }

        return dano;
    }

    @Override
    public String toString(){
        return super.toString() + " - Força: " + forca;
    }

    public int getForca() {
        return forca;
    }
}
