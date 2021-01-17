package jp.ac.uryukyu.ie.e205705_e205734;

import java.util.Random;

/**
 * Turnクラス。
 * １ターンごとの処理や行動のメソッド、バトル自体のメソッドを用意。
 */
public class Turn {
    /**
     * ターン数
     */
    private int turn;

    /**
     * Randomクラスのインスタンス
     */
    private Random random = new Random();

    /**
     * コンストラクタ。初期値を設定。
     */
    public Turn(){
        this.turn = 1;
    }
    
    /**
     * プレイヤー、敵キャラがバトルするメソッド
     * バトル実行、ターン数や各キャラのステータスの表示、勝敗判定を行う
     * @param player1　プレイヤー
     * @param player2　敵キャラ
     */
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
                player1.shstatus(player1);
                System.out.println("もう一度戦いますか？");
                System.out.println("「1」：はい　　「2」：いいえ");
                if(new Scansystem().inputy_n()){
                    player2.reset(player2);
                    System.out.println("----------------------------");
                    player1.status(player1,player2);
                    System.out.println("----------------------------");
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

    /**
     * 最終バトル（ボス戦）のメソッド
     * バトル実行、ターン数や各キャラのステータスの表示、勝敗判定を行う
     * @param player1　プレイヤー
     * @param player2　敵キャラ（ボス）
     */
    public void lastbattle(Player player1, Enemy player2){
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
                this.turn =1;
                System.out.println("次へ進む");
                if(new Scansystem().input_y()){
                    player2.reset(player2);
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

    /**
     * プレイヤー、敵キャラの行動メソッド
     * 各キャラの攻撃、生死判定、ステータス表示を行い、技抽選に必要なスロットを回す。
     * @param player1　プレイヤー
     * @param player2　敵キャラ
     */
    public void act(Player player1, Enemy player2){
        Slot_system exam = new Slot_system();
        player1.attack(player1,player2,exam.Slot());
        player2.chdead(player2);
        if(player2.getdead()){
            System.out.println(player2.getname()+"は倒れた！");
        }else{
            player2.attack(player2,player1,random.nextInt(4));
        }
        player1.waitMoment(1500);
        player1.chdead(player1);
        System.out.println(player1.getname()+"のHP："+player1.gethp());
        System.out.println(player2.getname()+"のHP："+player2.gethp());
    }
}
