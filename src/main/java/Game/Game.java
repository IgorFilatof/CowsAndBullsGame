package Game;

import java.util.Random;


public class Game {
    private int[] sys = new int[4];
    int numberCows = 0;
    int numberBulls = 0;

    public void setNumberCows(int numberCows) {
        this.numberCows = numberCows;
    }

    public void setNumberBulls(int numberBulls) {
        this.numberBulls = numberBulls;
    }

    public int[] makeSecretNumber() {
        Random rand = new Random();
        sys[0] = rand.nextInt(9) + 1;

        sys[1] = rand.nextInt(10);
        while (sys[1] == sys[0]) {
            sys[1] = rand.nextInt(10);
        }


        sys[2] = rand.nextInt(10);
        while (sys[2] == sys[1] || sys[2] == sys[0]) {
            sys[2] = rand.nextInt(10);
        }


        sys[3] = rand.nextInt(10);
        while (sys[3] == sys[1] || sys[3] == sys[0] || sys[3] == sys[2]) {
            sys[3] = rand.nextInt(10);
        }

        System.out.println(sys[0] + " " + sys[1] + " " + sys[2] + " " + sys[3]);
        return sys;
    }

    public int checkBulls(int numberUser) {
        int[] massUser = new int[4];

        for (int i = 3; i >= 0; i--) {
            massUser[i] = numberUser % 10;
            numberUser /= 10;
        }


        for (int i = 0; i < 4; i++) {
            if (massUser[i] == sys[i]) {
                numberBulls++;
            }
        }
        return numberBulls;
    }


    public int checkCows(int numberUser) {
        int[] massUser = new int[4];
        for (int i = 3; i >= 0; i--) {
            massUser[i] = numberUser % 10;
            numberUser /= 10;
        }
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (sys[j] == massUser[k]&&massUser[j]!=sys[j]) {
                    numberCows++;
                    continue;
                }
            }

        }

        return numberCows;

    }



}