package jp.ac.uryukyu.ie.e205705_e205734;

/**
 * Characterクラス。Playerクラス、Enemyクラスのスーパークラス。
 * キャラクターの情報（名前、HP、攻撃力、レベル、経験値、生死判定、状態異常判定）を管理する。
 * キャラクターの情報、行動に関するメソッドを用意。
 */ 
public class Character {

    /**
     * キャラクターの名前
     */
    private String name;

    /**
     * キャラクターの攻撃力
     */
    private  int attack;

    /**
     * 攻撃力の基準値
     */
    private int defaAttack;

    /**
     * キャラクターのHP
     */
    private int hp;

    /**
     * HPの最大値
     */
    private int maxHp;

    /**
     * 眠っているターン数を記録
     */
    private int sleepturn;

    /**
     * キャラクターの生死判定
     * 生　= false, 死　=  true
     */
    private boolean dead;

    /**
     * キャラクターの毒状態判定
     * 毒　= true  毒以外 = false
     */
    private boolean poison;

    /**
     * キャラクターの眠り状態判定
     * 眠り　= true,　眠り以外 = false
     */
    private boolean sleep;

    /**
     * コンストラクタ。初期値を設定
     * @param name　キャラクターの名前
     * @param attack　キャラクターの攻撃力
     * @param hp　キャラクターのHP
     */
    public Character(String name, int attack, int hp){
        this.name = name;
        this.attack = attack;
        this.defaAttack = attack;
        this.hp = hp;
        this.maxHp = hp;
        this.dead = false;
        this.poison = false;
        this.sleep = false;
        this.sleepturn = 0;
    }

    /** 
     * キャラクター（プレイヤー、敵）の攻撃メソッド。
     * @param player attackを使用するキャラクター
     * @param target attackを受けるキャラクター
     * @param value 技を呼び出す引数(継承先で使う)
    */
    public void attack(Character player, Character target,int value){
        waitMoment(1500);
        System.out.println(player.name+"の通常攻撃！");
        target.hp -= player.attack;
        System.out.println(target.name+"は"+player.attack+"ダメージ受けた！");
    }

    /**
     * キャラクターの生死を判定するメソッド
     * HPが０以下だと死判定
     * @param e　判定するキャラクター
     */
    public void chdead(Character e){
        if(e.hp<=0){
            e.dead = true;
        }
    }

    /**
     * nameのgetterメソッド
     * @return キャラクターの名前
     */
    public String getname(){return this.name;}

    /**
     * hpのgetterメソッド
     * @return キャラクターのHP
     */
    public int gethp(){return this.hp;}

    /**
     * maxHpのgetterメソッド
     * @return キャラクターの最大HP
     */
    public int getmaxHp(){return this.maxHp;}

    /**
     * deadのgetterメソッド
     * @return キャラクターの生死判定
     */
    public boolean getdead(){return this.dead;}

    /**
     * attackのgetterメソッド
     * @return キャラクターの攻撃力
     */
    public int getattack(){return this.attack;}

    /**
     * poisonのgetterメソッド
     * @return キャラクターの毒判定
     */
    public boolean getpoison(){return this.poison;}

    /**
     * sleepのgetterメソッド
     * @return キャラクターの眠り判定
     */
    public boolean getsleep(){return this.sleep;}

    /**
     * attackのsetterメソッド
     * @param value　設定したい値
     */
    public void setattack(int value){this.attack = value;}

    /**
     * maxHpのsetterメソッド
     * @param value　設定したい値
     */
    public void setmaxHp(int value){this.maxHp = value;}

    /**
     * hpのsetterメソッド
     * @param value　設定したい値
     */
    public void sethp(int value){this.hp = value;}

    /**
     * poisonのsetterメソッド
     * @param set　設定したい値
     */
    public void setpoison(boolean set){this.poison = set;}

    /**
     * sleepのsetterメソッド
     * @param set　設定したい値
     */
    public void setsleep(boolean set){this.sleep = set;}

    /**
     * キャラクターのHPを回復させるメソッド
     * @param value　回復量
     */
    public void heal(int value){
        this.hp += value;
    }

    /**
     * キャラクターのステータスを表示するメソッド
     * @param player1　表示したいキャラクター１
     * @param player2　表示したいキャラクター２
     */
    public void status(Character player1,Character player2){
        System.out.println(player1.name+" VS "+player2.name);
        System.out.println(player1.name+"のHP:"+player1.hp+"　攻撃力:"+player1.attack);
        System.out.println(player2.name+"のHP:"+player2.hp+"　攻撃力:"+player2.attack);
    }

    /**
     * 眠り状態に関するメソッド
     * キャラクターの眠っているターンをカウントし、指定されたターン数に達すると目覚める
     * @param e　眠り状態のキャラクター
     * @param turn　眠り状態が続くターン数
     */
    public void sleepturn(Character e,int turn){
        if(sleepturn == turn){
            e.sleep = false;
            sleepturn = 0;
            System.out.println(e.name+"は目覚めた！");
        }else{
            sleepturn += 1;
        }
    }

    /**
     * キャラクターのステータスをリセットするメソッド
     * @param e　リセットしたいキャラクター
     */
    public void reset(Character e){
        e.hp = e.maxHp;
        e.dead = false;
        e.attack = e.defaAttack;
        e.poison = false;
        e.sleep = false;
        e.sleepturn = 0;
    }
    
    /**
     * 時間間隔を開けるメソッド
     * 実行結果を表示する時間間隔を作る。
     * @param time　止めたい時間
     */
    public void waitMoment(int time) {
        try {
            Thread.sleep(time);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
