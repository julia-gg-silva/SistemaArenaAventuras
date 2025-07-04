public class Pocao implements Item{

    private int cura;

    Pocao(){
        this.cura = 30;
    }

    public int getCura() {
        return cura;
    }

    @Override
    public String descricao() {
        return " --Poção de Vida--";
    }


}
