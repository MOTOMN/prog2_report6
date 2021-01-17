package jp.ac.uryukyu.ie.e205705_e205734;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * 例外処理クラス。 Scanner test; //入力した値 
 * Created by e205734 on 2021/1/16.
 */
public class Exception {
    /**
     * フィールド変数。 Scanner test; //入力した値
     */
    public Scanner test = new Scanner(System.in);

    /**
     * 例外処理メソッド。入力した値が指定したint型と同じか判定する。
     * 
     * @return ans_i 0
     * @exception InputMismatchException int指定されている場合にstringを入力 した時の例外
     */
    public int TryInt() {
        try {
            int ans_i = test.nextInt();
            return ans_i;
        } catch (InputMismatchException e) {
            System.out.println("     数字を入力してください     ");
        }
        return 0;
    }
}