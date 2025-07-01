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
        return forca * getNivel();
    }

    @Override
    public String toString(){
        return super.toString() + " - Força: " + forca;
    }
}
