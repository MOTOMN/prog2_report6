package jp.ac.uryukyu.ie.e205734;

public class Slot_pictures {
    public static void all_pic(int n_1, int n_2, int n_3){
        System.out.println(pictures(n_1)+pictures(n_2)+pictures(n_3));
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
