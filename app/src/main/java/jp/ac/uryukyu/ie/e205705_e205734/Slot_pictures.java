package jp.ac.uryukyu.ie.e205705_e205734;

public class Slot_pictures {
    public static void all_pic(int n_1, int n_2){
        System.out.println(pictures(n_1)+pictures(n_2));
    }
    public static String pictures(int n){
        if(n==0){
            return(" [ ｷｬ━━(ﾟ∀ﾟ)━━!! ] ");
        }
        if(n==1){
            return(" [    ( ⊙ꇴ⊙ )    ] ");
        }
        else{
            return(" [   （๑✧∀✧๑）☀   ] ");
        }
    }
}
