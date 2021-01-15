package jp.ac.uryukyu.ie.e205705_e205734;

import java.util.Random;

public class Turn {
    private int turn;
    private Random random = new Random();

    public Turn(){
        this.turn = 1;
    }
    
    public void playbattle(Player player1, Enemy player2){
        System.out.println("----------------------------");
        player1.status(player1,player2);
        System.out.println("----------------------------");
        while(true){
            System.out.println("----------------------------");
            System.out.println(this.turn+"ターン目戦闘開始！");
            System.out.println("----------------------------");
            act(player1, player2);
            if(player1.getdead()==true && player2.getdead()==true){
                System.out.println("引き分け！");
                break;
            }else if(player1.getdead()==true){
                System.out.println(player2.getname()+"の勝利！");
                this.turn =1;
                break;
            }else if(player2.getdead()==true){
                System.out.println(player1.getname()+"の勝利！");
                player1.chLevelUp(player2.getgiveExp());
                this.turn =1;
                System.out.println("もう一度戦いますか？(次のバトルへ行く場合は『いいえ』）)");
                System.out.println("「1」：はい　　「2」：いいえ");
                if(new Scansystem().inputy_n()){
                    reset(player2);
                    player1.status(player1,player2);
                    continue;
                }else{
                    break;
                }
            }else{
                this.turn += 1;
                System.out.println("次のターンへ進みます");
                if(new Scansystem().input_y()){
                    continue;
                }
            }
        }
    }
    public void act(Player player1, Enemy player2){
        Slot_system exam = new Slot_system();
        
        player1.attack(player1,player2,exam.Slot());
        player2.chdead(player2);
        if(player2.getdead()){
            System.out.println(player2.getname()+"は倒れた！");
        }else{
            player2.attack(player2,player1,random.nextInt(4));
        }
        player1.chdead(player1);
        System.out.println(player1.getname()+"のHP："+player1.gethp());
        System.out.println(player2.getname()+"のHP："+player2.gethp());
    }

    public void reset(Enemy e){
        e.sethp(e.getmaxHp());
        e.setdead(false);
        e.setattack(e.getmaxAttack());
        e.setpoison(false);
        e.setsleep(false);
        e.setsleepturn(0);
    }

    
}
