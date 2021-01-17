package jp.ac.uryukyu.ie.e205705_e205734;

/**
 * Enemyクラス。Characterクラスの子クラス。
 * 敵キャラの情報を管理する。追加情報として、相手に与える経験値を追加。
 * 敵キャラの行動に関するメソッドを用意。
 */
public class Enemy extends Character{

    /**
     * 自身が倒された時に、相手に与える経験値
     */
    private int giveExp;

    /**
     * giveexpのgetterメソッド
     * @return　相手に与える経験値
     */
    public int getgiveExp(){return this.giveExp;}

    /**
     * コンストラクタ。初期値を設定。
     * @param name　敵キャラの名前
     * @param attack　敵キャラの攻撃力
     * @param hp　敵キャラのHP
     * @param giveExp　相手に与える経験値
     */
    public Enemy(String name,int attack,int hp,int giveExp){
        super(name, attack, hp);
        this.giveExp = giveExp;
    }

    /**
     * 敵キャラの攻撃メソッド
     * valueの値に応じた技を出す
     * @param player attackを使用する敵キャラ
     * @param target　attackを受けるキャラクター
     * @param value　技を呼び出す引数
     */
    @Override
    public void attack(Character player, Character target,int value){
        waitMoment(1000);
        if(super.getsleep() == true){
            System.out.println(player.getname()+"は眠っている！");
            super.sleepturn(player,2);
        }else{
            if(super.getpoison() == true){
                System.out.println(player.getname()+"は毒状態だ！");
                waitMoment(1500);
                int poisonDmg = player.gethp()/5;
                int lackhp = player.gethp()-poisonDmg;
                player.sethp(lackhp);
                System.out.println(player.getname()+"は毒により、"+poisonDmg+"ダメージ受けた！");
            }
            switch(value){
                case 0:
                    waitMoment(1500);
                    System.out.println(player.getname()+"の連続攻撃！");
                    int attackvalue = player.getattack()*2;
                    int lackhp1 = target.gethp()-attackvalue;
                    target.sethp(lackhp1);
                    System.out.println(target.getname()+"は"+attackvalue+"ダメージ受けた！");
                    break;
                case 1:
                    waitMoment(1500);
                    System.out.println(player.getname()+"の治癒魔法！");
                    int heal = player.getmaxHp()-player.gethp();
                    super.heal(heal);
                    System.out.println(player.getname()+"はHPが全回復した");
                    if(super.getpoison() == true){
                        System.out.println(player.getname()+"は毒が治った！");
                        super.setpoison(false);
                    }
                    break;
                case 2:
                    waitMoment(1500);
                    System.out.println(player.getname()+"の怒り！");
                    player.setattack(player.getattack()+20);
                    System.out.println(player.getname()+"は攻撃力が上がった！攻撃力："+player.getattack());
                    break;
                default:
                    super.attack(player, target, value);
            }
        }
    }
}
