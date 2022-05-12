public class Boss {
    private int HP;
    private int DMG;
    private String Shield;

    public int getHP() {
        return HP;
    } 

    public void setHP(int HP) {
        if (HP <= 0){
            System.out.println("Íåäîïóñòèìîå çíà÷åíèå çäîðîâüÿ");
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
            System.out.println("Íåäîïóñòèìîå çíà÷åíèå óðîíà");
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
