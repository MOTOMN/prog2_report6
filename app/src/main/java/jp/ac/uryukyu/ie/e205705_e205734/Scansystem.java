package jp.ac.uryukyu.ie.e205705_e205734;
import java.util.Scanner;

public class Scansystem {
    public Scanner scanner = new Scanner(System.in);
    

    public boolean inputy_n(){
        while(true){
            System.out.println("「y」か「n」を入力してください");
            switch(scanner.nextLine()){
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    continue;
                }
            }
    }

    public boolean input_y(){
        while(true){
            System.out.println("「y」を入力してください");
            switch(scanner.nextLine()){
                case "y":
                    return true;
                default:
                    continue;
                }
            }
    }
}
