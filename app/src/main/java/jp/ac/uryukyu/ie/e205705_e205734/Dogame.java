package jp.ac.uryukyu.ie.e205705_e205734;

public class Dogame {
    public void playgame(){
        var hero = new Player("勇者", 1000, 150);
        var enemy = new Enemy("ゴブリン", 20, 100,15);
        var enemy2 = new Enemy("ボスゴブリン", 50, 500,30);
        var enemy3 = new Enemy("魔王",100,1000,1000);
        var master = new Turn();

        master.playbattle(hero, enemy);
        if(judgePlay(hero)){
            nextbattle();
            master.playbattle(hero, enemy2);
            if(judgePlay(hero)){
                nextbattle();
                master.playbattle(hero, enemy3);
                if(judgePlay(hero)){
                    System.out.println("                                  ");
                    System.out.println("    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ");
                    System.out.println("    『おめでとう！ゲームクリアだ！!』    ");
                    System.out.println("    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ");
                    System.out.println("                                  ");
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
        new Scansystem().input_y();
    }
}

