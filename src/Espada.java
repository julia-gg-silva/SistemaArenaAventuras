public class Espada implements Item{

    private int bonus;

    public Espada(){
        this.bonus = 7;
    }

    public int getBonus() {
        return bonus;
    }



    @Override
    public String descricao() {
        return "--Espada--";
    }
}
