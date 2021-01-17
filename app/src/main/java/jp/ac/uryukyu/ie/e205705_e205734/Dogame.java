package jp.ac.uryukyu.ie.e205705_e205734;

/**
 * Dogameクラス。
 * プレイヤー、敵キャラの実装を行い、ゲーム全体の流れを組む。
 */
public class Dogame {
    /**
     * プレイヤー、敵キャラの実装を行い、ゲーム全体を実行するメソッド
     */
    public void playgame(){
        explain();
        var hero = new Player("勇者", 30, 150);
        var enemy = new Enemy("ゴブリン", 10, 100,15);
        var enemy2 = new Enemy("ボスゴブリン", 50, 500,30);
        var enemy3 = new Enemy("魔王",100,1000,1000);
        var master = new Turn();

        master.playbattle(hero, enemy);
        if(judgePlay(hero)){
            nextbattle();
            master.playbattle(hero, enemy2);
            if(judgePlay(hero)){
                nextbattle();
                master.lastbattle(hero, enemy3);
                if(judgePlay(hero)){
                    System.out.println("                                  ");
                    System.out.println("    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   ");
                    System.out.println("    『おめでとう！ゲームクリアだ！!』    ");
                    System.out.println("    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  ");
                    System.out.println("                                  ");
                    hero.shstatus(hero);
                }else{
                    System.out.println("ゲームを終了します。");
                }
            }else{
                System.out.println("ゲームを終了します。");
            }
        }else{
            System.out.println("ゲームを終了します。");
        }
        
    }
    /**
     * プレイヤーの生死を確認し、ゲーム続行を判定するメソッド
     * @param e　判定したいプレイヤー
     * @return　ゲーム続行判定結果
     */
    public boolean judgePlay(Player e){
        if(e.getdead()){
            System.out.println(e.getname()+"は戦闘不能だ！");
            System.out.println("ゲームオーバー！");
            return false;
        }else{
            return true;
        }
    }

    /**
     * 次のバトルへ行く際の確認メソッド
     */
    public void nextbattle(){
        System.out.println("次のバトルへ進みます");
        new Scansystem().input_y();
    }
    /**
    * 　ゲームの説明を表示するメソッド
    */
    public void explain(){
        System.out.println("=========================================================================");
        System.out.println("このゲームはスロットとRPGを合わせたゲームです。");
        System.out.println("スロットの揃った絵柄によってプレイヤーは特殊攻撃をします。");
        System.out.println("このゲームはレベル上げを推奨しています。（運がよければレベル上げをしなくても勝てます）");
        System.out.println("一度でも負けると最初からになります。");
        System.out.println("ステージは全３ステージです。");
        System.out.println("第1ステージ:　ゴブリン:推奨レベル1:");
        System.out.println("第2ステージ:　ボスゴブリン:推奨レベル5:");
        System.out.println("第3ステージ:　魔王:推奨レベル10:");
        System.out.println("=========================================================================");
        System.out.println("『1』を入力するとゲームが始まります。");
        if(new Scansystem().input_y()){
            System.out.println("ゲームを開始します。");
        }
    }
}

