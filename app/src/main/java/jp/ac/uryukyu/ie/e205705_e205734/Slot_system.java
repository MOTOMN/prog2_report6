package jp.ac.uryukyu.ie.e205705_e205734;

public class Slot_system extends Exception {
    int slotArray[] = new int[3];
    int count[] = new int[3];
    Slot_pictures design = new Slot_pictures();
    int skill;

    public int Slot() {

        for (int i = 0; i < 3; i++) {
            slotArray[i] = 0;
            count[i] = 0;
            skill = 0;
        }
        System.out.println("                                     ");
        System.out.println("    　　　　 技スロットを回します 　　　    ");
        System.out.println("     　『1』か『2』を入力してください。     ");
        while (count[0] == 0 || count[1] == 0 ) {

            int num = new Exception().TryInt();

            System(num, 1, 0, 0);
            System(num, 2, 1, 1);
            if (num == 1 && count[1] == 0 || num == 2 && count[0] == 0) {
                System.out.println("     残りの数字を押してください     ");
            }else if(count[0] == 1 && count[1] == 1){
                System.out.println("                                ");
            }else {
                System.out.println("     1~3の範囲で入力してください     ");
            }
        }
        if (slotArray[0] == slotArray[1] ) {
            design.all_pic(slotArray[0], slotArray[1]);
            System.out.println("　　　　　＞＞＞   特殊攻撃発動！！  ＜＜＜　　　");
            System.out.println("                                      　  ");
            int skill = slotArray[0];
            return skill;
        } else {
            design.all_pic(slotArray[0], slotArray[1]);
            System.out.println("         残念、通常攻撃だ！！    　  ");
            System.out.println("                              　  ");
            int skill = 3;
            return skill;
        }
    }

    public void System(int num, int a, int b, int c) {
        if (num == a) {
            if (count[b] == 0) {
                slotArray[c] = (int) (Math.random() * 3);
                System.out.println(design.pictures(slotArray[c]));
                count[b] = 1;

            } else {
                System.out.println(a + "番はすでに止めています");
            }
        }
    }
}