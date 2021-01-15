package jp.ac.uryukyu.ie.e205705_e205734;

public class Dogame {
    public void playgame(){
        var hero = new Player("勇者", 10, 100);
        var enemy = new Enemy("ゴブリン", 0, 100,10);
        var enemy2 = new Enemy("ボスゴブリン", 0, 150,15);
        var enemy3 = new Enemy("魔王",0,200,20);
        var master = new Turn();

        master.playbattle(hero, enemy);
        if(judgePlay(hero)){
            nextbattle();
            master.playbattle(hero, enemy2);
            if(judgePlay(hero)){
                nextbattle();
                master.playbattle(hero, enemy3);
                if(judgePlay(hero)){
                    System.out.println("おめでとう！ゲームクリアだ！");
                    hero.shstatus(hero);
                }
            }else{
                System.out.println("ゲームを終了します。");
            }
        }else{
            System.out.println("ゲームを終了します。");
        }
        
    }
    public boolean judgePlay(Player e){
        if(e.getdead()){
            System.out.println(e.getname()+"は戦闘不能だ！");
            System.out.println("ゲームオーバー！");
            return false;
        }else{
            return true;
        }
    }
    public void nextbattle(){
        System.out.println("次のバトルへ進みます");
        System.out.println("「y」：はい");
        new Scansystem().input_y();
    }
}

