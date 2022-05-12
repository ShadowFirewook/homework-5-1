public class Boss {
    private int HP;
    private int DMG;
    private String Shield;

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        if (HP <= 0){
            System.out.println("Недопустимое значение здоровья");
        }
        else {
        this.HP = HP;
        }
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        if (DMG <= 0){
            System.out.println("Недопустимое значение урона");
        }else {
            this.DMG = DMG;
        }
    }

    public String getShield() {
        return Shield;
    }

    public void setShield(String shield) {
        Shield = shield;
    }
}
