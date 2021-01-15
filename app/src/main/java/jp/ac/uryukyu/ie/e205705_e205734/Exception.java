package jp.ac.uryukyu.ie.e205705_e205734;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Exception {
    public Scanner test = new Scanner(System.in);
    public int TryInt() {
        try {
            int ans_i = test.nextInt();
            return ans_i;
        } catch (InputMismatchException e) {
            System.out.println("数字を入力してください");
        }
        return 0;
    }

    public String TryString() {
        try {
            String ans_s = test.nextLine();
            return ans_s;
        } catch (InputMismatchException e) {
            System.out.println("もう一度遊ぶときは『y』を入力してね！！");
        }
        return "e";
    }
}
