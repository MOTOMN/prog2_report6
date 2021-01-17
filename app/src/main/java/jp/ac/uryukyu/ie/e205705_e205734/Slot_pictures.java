package jp.ac.uryukyu.ie.e205705_e205734;

/**
 * スロットの絵柄を決めるクラス。 Created by e205734 on 2021/1/16.
 */
public class Slot_pictures {
    /**
     * スロット全ての絵柄を表示するメソッド。全てスロットの結果を表示する。
     * 
     * @param n_1 1番スロットの結果
     * @param n_2 2番スロットの結果
     */
    public void all_pic(int n_1, int n_2) {
        System.out.println("                                ");
        System.out.println(pictures(n_1) + pictures(n_2));
        System.out.println("                                ");
    }

    /**
     * 顔文字の文字列を返すメソッド。入力した値に対応する文字列を返す。
     * 
     * @param n スロットの結果の値
     * @return " [ ε=(怒ﾟДﾟ)ﾉﾉ ｺﾞﾙｱｧｱｧ!!!!! ] "," [ ﾎﾟｲｽﾞﾝ!(꒪ꇴ꒪|||） ] "," [（( ˘ω˘
     *         )ｽﾔｧ… ] " 文字列
     */
    public String pictures(int n) {
        if (n == 0) {
            return (" [　ε=(怒ﾟДﾟ)ﾉﾉ ｺﾞﾙｱｧｱｧ!!!!! ] ");
        }
        if (n == 1) {
            return (" [  ﾎﾟｲｽﾞﾝ!(꒪ꇴ꒪|||） ] ");
        } else {
            return (" [（( ˘ω˘ )ｽﾔｧ… ] ");
        }
    }
}
