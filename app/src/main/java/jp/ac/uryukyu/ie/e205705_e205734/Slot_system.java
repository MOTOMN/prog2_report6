package jp.ac.uryukyu.ie.e205705_e205734;

public class Slot_system extends Exception {
    int slotArray[] = new int[3];
    int count[] = new int[3];
    int skill;

    public int getskill() {
        return this.skill;
    }

    public int Slot() {

        for (int i = 0; i < 3; i++) {
            slotArray[i] = 0;
            count[i] = 0;
            skill = 0;
        }

        System.out.println("     1か2か3を入力してください。     ");
        while (count[0] == 0 || count[1] == 0 ) {

            int num = new Exception().TryInt();

            System(num, 1, 0, 0);
            System(num, 2, 1, 1);
            if (num == 1 || num == 2 ) {
                System.out.println("     残りの数字を押してください     ");
            } else {
                System.out.println("     1~3の範囲で入力してください     ");
            }
        }
        if (slotArray[0] == slotArray[1] ) {
            System.out.println("＞＞     会心の一撃！！     ＜＜");
            int skill = slotArray[0];
            Slot_pictures.all_pic(slotArray[0], slotArray[1]);
            return skill;
        } else {
            System.out.println("     残念！！     ");
            int skill = 3;
            Slot_pictures.all_pic(slotArray[0], slotArray[1]);
            return skill;
        }

       

    }

    public void System(int num, int a, int b, int c) {
        if (num == a) {
            if (count[b] == 0) {
                slotArray[c] = (int) (Math.random() * 3);
                System.out.println(slotArray[c]);
                count[b] = 1;

            } else {
                System.out.println(a + "番はすでに止めています");
            }
        }
    }
}
