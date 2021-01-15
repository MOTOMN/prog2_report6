package jp.ac.uryukyu.ie.e205705_e205734;

public class Slot_pictures {
    public  void all_pic(int n_1, int n_2){
        System.out.println("                                ");
        System.out.println(pictures(n_1)+pictures(n_2));
        System.out.println("                                ");
    }
    public  String pictures(int n){
        if(n==0){
            return(" [　ε=(怒ﾟДﾟ)ﾉﾉ ｺﾞﾙｱｧｱｧ!!!!! ] ");
        }
        if(n==1){
            return(" [  ﾎﾟｲｽﾞﾝ!(꒪ꇴ꒪|||） ] ");
        }
        else{
            return(" [（( ˘ω˘ )ｽﾔｧ… ] ");
        }
    }
}
