public class Mago extends Heroi{

    int inteligencia;

    public Mago(String nome, int nivel, int inteligencia) {
        super(nome, nivel);
        if(inteligencia <= 0){
            System.err.println("Inteligência inválida! Atribuindo valor padrão 1");
            this.inteligencia = 1;
        }else{
            this.inteligencia = inteligencia;
        }
    }


    @Override
    public int atacar() {
        return inteligencia * this.getNivel() + 10;
    }

    @Override
    public String toString() {
        return super.toString() + " - Inteligencia: " + inteligencia;
    }

    public int getInteligencia() {
        return inteligencia;
    }
}
