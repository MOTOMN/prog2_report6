package jp.ac.uryukyu.ie.e205705_e205734;

/**
 * Playerクラス。Characterクラスの子クラス。
 * プレイヤー（ユーザー側のキャラクター）の情報を管理する。追加情報としてレベル、経験値を追加。
 * プレイヤーの情報、行動に関するメソッドを用意。
 */
public class Player extends Character {
    /**
     * プレイヤーのレベル
     */
    private int level;

    /**
     * プレイヤーの経験値
     */
    private int exp;

    /**
     * プレイヤーのレベルupに必要な経験値
     */
    private int maxExp;

    /**
     * コンストラクタ。初期値を設定。
     * @param name　プレイヤーの名前
     * @param attack　プレイヤーの攻撃力
     * @param hp　プレイヤーのHP
     */
    public Player(String name, int attack,int hp){
        super(name, attack, hp);
        this.level = 1;
        this.exp = 0;
        this.maxExp = 10;
    }

    /**
     * プレイヤーのレベルupに関するメソッド
     * 経験値をもらい、レベルupに必要な経験値に達しているとステータスup、HP全回復を行う
     * @param exp　与えられた経験値
     */
    public void chLevelUp(int exp){
        System.out.println(super.getname()+"は"+exp+"経験値もらった！");
        this.exp += exp;
        if(this.exp>=this.maxExp){
            statusup();
            this.maxExp += 10;
            this.exp = 0;
            int healvalue = getmaxHp()-gethp();
            super.heal(healvalue);
            System.out.println(super.getname()+"はレベルアップによりHPが全回復した！");
        }else{
            int lackExp = this.maxExp-this.exp;
            System.out.println(super.getname()+"は現在Lv."+this.level+":"+this.exp+"経験値溜まっている！"+"あと"+lackExp+"経験値でレベルアップ！");
        }
        
    }

    /**
     * プレイヤーのステータスをupさせるメソッド
     * レベル、HP、攻撃力が上がる
     */
    public void statusup(){
        this.level += 1;
        int attackup = 10;
        int hpup = 30;
        super.setattack(super.getattack()+attackup);
        super.setmaxHp(super.getmaxHp()+hpup);
        System.out.println(super.getname()+"はLv."+this.level+"に上がった！");
        System.out.println(super.getname()+"はレベルアップにより最大HP+"+hpup+",攻撃力+"+attackup+"ステータスUPした！");
    }

    /**
     * プレイヤーの攻撃メソッド
     * valueの値に応じた技を出す
     * @param player　attackを使用するプレイヤー
     * @param target　attackを受けるキャラクター
     * @param value　技を呼び出す引数
     */
    @Override
    public void attack(Character player, Character target,int value){
        waitMoment(1000);
        switch(value){
            case 0:
                System.out.println(player.getname()+"の攻撃！");
                System.out.println("特殊攻撃！一撃必殺！！");
                waitMoment(1500);
                int attackvalue = target.gethp();
                int lackhp = target.gethp()-attackvalue;
                target.sethp(lackhp);
                System.out.println(target.getname()+"は"+attackvalue+"ダメージ受けた！");
                break;
            case 1:
                System.out.println(player.getname()+"の攻撃！");
                System.out.println("特殊攻撃！ポイズンアタック！！");
                waitMoment(1500);
                int lackhp2 = target.gethp()-player.getattack();
                target.sethp(lackhp2);
                if(target.getpoison()){
                    System.out.println(target.getname()+"はすでに毒状態だ！"+player.getattack()+"ダメージ受けた！");
                }else{
                    target.setpoison(true);
                    System.out.println(target.getname()+"は"+player.getattack()+"ダメージ受け、毒状態になった！");
                }
                break;
            case 2:
                System.out.println(player.getname()+"の攻撃！");
                System.out.println("特殊攻撃！さいみんじゅつ！！");
                waitMoment(1500);
                int lackhp3 = target.gethp()-player.getattack();
                target.sethp(lackhp3);
                if(target.getsleep()){
                    System.out.println(target.getname()+"はすでに眠っている！"+player.getattack()+"ダメージ受けた！");
                }else{
                    target.setsleep(true);
                    System.out.println(target.getname()+"は"+player.getattack()+"ダメージ受け、眠ってしまった！");
                }
                break;
            default:
                super.attack(player, target, value);
        }
    }

    /**
     * プレイヤーのステータスを表示するメソッド
     * @param e　表示させたいプレイヤー
     */
    public void shstatus(Player e){
        System.out.println(e.getname()+":Lv."+e.level+":HP "+e.gethp()+":攻撃力　"+e.getattack());
    }
}
