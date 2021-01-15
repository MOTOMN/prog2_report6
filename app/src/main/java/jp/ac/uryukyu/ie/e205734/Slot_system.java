package jp.ac.uryukyu.ie.e205734;

public class Slot_system extends Exception {
    int slotArray[] = new int[3];
    int count[] = new int[3];
    String r_p = "y";
    int skill;

    public void Slot() {
        while (r_p.equals("y")) {
            for (int i = 0; i < 3; i++) {
                slotArray[i] = 0;
                count[i] = 0;
                skill = 0;
            }

            System.out.println("     1か2か3を入力してください。     ");
            while (count[0] == 0 || count[1] == 0 || count[2] == 0) {

                int num = new Exception().TryInt();

                System(num, 1, 0, 0);
                System(num, 2, 1, 1);
                System(num, 3, 2, 2);
                if (num == 1 || num == 2 || num == 3) {
                    System.out.println("     残りの数字を押してください     ");
                } else {
                    System.out.println("     1~3の範囲で入力してください     ");
                }
            }
            if (slotArray[0] == slotArray[1] && slotArray[1] == slotArray[2]) {
                System.out.println("＞＞     会心の一撃！！     ＜＜");
                int skill = slotArray[0];
            } else {
                System.out.println("     残念！！     ");
                int skill = 3;
            }

            Slot_pictures.all_pic(slotArray[0], slotArray[1], slotArray[2]);
            System.out.println("     もう一度やりますか？     ");
            System.out.println("『y』か『n』を入力してください");
            String one_more = new Exception().TryString();
            if (one_more.equals("y")) {
                continue;
            } else {
                break;
            }
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
