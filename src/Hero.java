public class Hero {
    private int HP;
    private int DMG;
    private String Power;

    public Hero(int HP,int DMG,String Power){
        this.HP = HP;
        this.DMG = DMG;
        this.Power = Power;
    }
    public Hero(int HP,int DMG){

    }

    public int getHP() {
        return HP;
    }

    public int getDMG() {
        return DMG;
    }

    public String getPower() {
        return Power;
    }
}
