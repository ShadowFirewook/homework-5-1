import java.util.Random;

public class Main {




    public static int bossHP = 1100;
    public static int heroesHP[] = {300, 270, 250};
    public static int healerHP = 350;
    public static int luckyHP = 200;
    public static int luckyDMG = 50;
    public static int bossDMG = 65;
    public static int heroesDMG[] = {20, 25, 30};
    public static int roundNumber = 0;
    public static String bossDEF;
    public static String heroesTypeATK[] = {"���������� �����", "���������� �����", "������������ �����"};

    public static void main(String[] args) {
        Boss boss1 = new Boss();
        boss1.setHP(1000);
        boss1.setDMG(60);
        boss1.setShield("����������");
        System.out.println("�������� �����: " + boss1.getHP() + "; ���� �����: " + boss1.getDMG() + "; ��� ������ �����: " + boss1.getShield());
        statistics();
        while (!isGameFinished()) {
            round();
        }
    }

    public static void round() {
        roundNumber++;
        chooseBossDEF();
        heroesHits();
        luckyHits();
        bossHits();
        healHeroes();
        statistics();
    }

    public static void chooseBossDEF() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesTypeATK.length);
        bossDEF = heroesTypeATK[randomIndex];
        System.out.println("���� ������: " + bossDEF);
    }

    public static void statistics() {
        System.out.println("__________����� " + roundNumber + "__________");
        System.out.println("�������� �����: " + bossHP + " (" + bossDMG + " ������ �����)");
        for (int i = 0; i < heroesHP.length; i++) {
            System.out.println(heroesTypeATK[i] + "; �������� �����: " + heroesHP[i] + " (" + heroesDMG[i] + " ������ �����)");
        }
        System.out.println("�������� ��������� " + luckyHP + " (" + luckyDMG + " ������ �����)");
        System.out.println("�������� ������: " + healerHP + " ������ ��������");

    }

    public static boolean isGameFinished() {
        if (bossHP <= 0) {
            System.out.println("����� ��������!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHP.length; i++) {
            if (heroesHP[i] > 0 || healerHP > 0 || luckyHP > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("���� �������!");
        }
        return allHeroesDead;
    }

    public static void bossHits() {
        Random random = new Random();
        random.nextBoolean();
        for (int i = 0; i < heroesHP.length; i++) {
            if (heroesHP[i] <= 0) {
                continue;
            }
            if (heroesHP[i] - bossDMG <= 0) {
                heroesHP[i] = 0;
            } else {
                heroesHP[i] = heroesHP[i] - bossDMG;
            }
        }
        if (!random.nextBoolean()) {
            if (luckyHP > 0) {
                luckyHP = luckyHP - bossDMG;
                System.out.println("��������� �� �������");
            }
        } else {
            System.out.println("�������� �������� �� ����� �����!");
        }
        if (luckyHP < 0) {
            luckyHP = 0;
        }
        if (healerHP > 0) {
            healerHP = healerHP - bossDMG;
        }
        if (healerHP <= 0) {
            healerHP = 0;
        }

    }

    public static void heroesHits() {
        for (int i = 0; i < heroesDMG.length; i++) {
            if (bossHP <= 0 || heroesHP[i] <= 0) {
                continue;
            }
            if (heroesTypeATK[i] == bossDEF) {
                Random random = new Random();
                int coef = random.nextInt(6) + 3;
                int critDMG = heroesDMG[i] * coef;
                if (bossHP - critDMG <= 0) {
                    bossHP = 0;
                } else {
                    bossHP = bossHP - critDMG;
                }
                System.out.println("����������� ����: " + critDMG + " ������");
            } else {
                if (bossHP - heroesDMG[i] <= 0) {
                    bossHP = 0;
                } else {
                    bossHP = bossHP - heroesDMG[i];
                }
            }
        }
    }

    public static void healHeroes() {
        for (int i = 0; i < heroesHP.length; i++) {
            if (heroesHP[i] < 100 && heroesHP[i] > 0 && healerHP > 0) {
                heroesHP[i] = heroesHP[i] + 40;
                System.out.println("����� ����������� 40 ������ �������� ����� �������");
                break;
            }
        }
    }

    public static void luckyHits() {
        if (luckyHP > 0) {
            bossHP = bossHP - luckyDMG;
        }
        if (bossHP < 0) {
            bossHP = 0;
        }
    }
}
