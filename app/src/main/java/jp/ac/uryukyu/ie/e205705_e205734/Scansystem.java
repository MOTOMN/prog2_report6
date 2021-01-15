package jp.ac.uryukyu.ie.e205705_e205734;
import java.util.Scanner;

public class Scansystem {
    public Scanner scanner = new Scanner(System.in);
    

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
