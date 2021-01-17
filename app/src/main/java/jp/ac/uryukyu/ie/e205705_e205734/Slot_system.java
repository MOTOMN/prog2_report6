package jp.ac.uryukyu.ie.e205705_e205734;

/**
 * スロットの全ての動作を行うクラス。 
 * int slotArray[]; //全てのスロットの結果を記録するリスト。 
 * int count[]; //全てのスロットの回転の有無を記録するリスト。 
 * Slot_pictures design; //Slot_picturesのインスタンス 
 * int skill; //Trunクラスのactメソッドで使用される。スキルの判定に必要。 
 * Created by e205734 on 2021/1/16.
 */
public class Slot_system extends Exception {
    int slotArray[] = new int[3];
    int count[] = new int[3];
    Slot_pictures design = new Slot_pictures();
    int skill;

    /**
     * スロット全ての動作を行うメソッド。全てのスロットの結果を表示する。
     * 
     * @return skill 技の判定に必要な値
     */
    public int Slot() {

        for (int i = 0; i < 3; i++) {
            slotArray[i] = 0;
            count[i] = 0;
            skill = 0;
        }
        System.out.println("                                     ");
        System.out.println("    　　　　 技スロットを回します 　　　    ");
        System.out.println("     　『1』か『2』を入力してください。     ");
        while (count[0] == 0 || count[1] == 0) {

            int num = new Exception().TryInt();

            System(num, 1, 0, 0);
            System(num, 2, 1, 1);
            if (num == 1 && count[1] == 0 || num == 2 && count[0] == 0) {
                System.out.println("     残りの数字を押してください     ");
            } else if (count[0] == 1 && count[1] == 1) {
                System.out.println("                                ");
            } else {
                System.out.println("     1~3の範囲で入力してください     ");
            }
        }
        if (slotArray[0] == slotArray[1]) {
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

    /**
     * スロットの動作を行うメソッド。指定した番号のスロット結果を表示する。
     * 
     * @param num   入力した値
     * @param num_s スロットの番号
     * @param num_c スロットの回転の有無のリストの番号
     * @param num_r スロットの結果のリストの番号
     */
    public void System(int num, int num_s, int num_c, int num_r) {
        if (num == num_s) {
            if (count[num_c] == 0) {
                slotArray[num_r] = (int) (Math.random() * 3);
                System.out.println(design.pictures(slotArray[num_r]));
                count[num_c] = 1;

            } else {
                System.out.println(num_s + "番はすでに止めています");
            }
        }
    }
}