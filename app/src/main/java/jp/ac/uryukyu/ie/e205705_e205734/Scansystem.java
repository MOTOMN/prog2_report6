package jp.ac.uryukyu.ie.e205705_e205734;
import java.util.Scanner;

/**
 * Scansystemクラス。
 * scannerを扱うメソッドを用意。
 */
public class Scansystem {
    /**
     * Scannerクラスのインスタンス
     */
    public Scanner scanner = new Scanner(System.in);
    
    /**
     * 番号をユーザーに入力してもらうメソッド
     * @return 入力結果
     */
    public boolean inputy_n(){
        while(true){
            System.out.println("「1」か「2」を入力してください");
            switch(scanner.nextLine()){
                case "1":
                    return true;
                case "2":
                    return false;
                default:
                    continue;
                }
            }
    }

    /**
     * 番号をユーザーに入力してもらうメソッド
     * @return　入力結果
     */
    public boolean input_y(){
        while(true){
            System.out.println("「1」を入力してください");
            switch(scanner.nextLine()){
                case "1":
                    return true;
                default:
                    continue;
                }
            }
    }
}
