package jp.ac.uryukyu.ie.e205705_e205734;

public class Player extends Character {
    private int level;
    private int exp;
    private int maxExp;

    public Player(String name, int attack,int hp){
        super(name, attack, hp);
        this.level = 1;
        this.exp = 0;
        this.maxExp = 10;
    }

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

    public void statusup(){
        this.level += 1;
        super.setattack(super.getattack()+20);
        super.setmaxHp(super.getmaxHp()+20);
        System.out.println(super.getname()+"はLv."+this.level+"に上がった！");
        System.out.println(super.getname()+"はレベルアップにより最大HP+20,攻撃力+20ステータスUPした！");
    }

    @Override
    public void attack(Character player, Character target,int value){
        switch(value){
            case 0:
                System.out.println(player.getname()+"の攻撃！");
                System.out.println("特殊攻撃！一撃必殺！！");
                int attackvalue = target.gethp();
                int lackhp = target.gethp()-attackvalue;
                target.sethp(lackhp);
                System.out.println(target.getname()+"は"+attackvalue+"ダメージ受けた！");
                break;
            case 1:
                System.out.println(player.getname()+"の攻撃！");
                System.out.println("特殊攻撃！ポイズンアタック！！");
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
    public void shstatus(Player e){
        System.out.println(e.getname()+":Lv."+e.level+":HP "+e.gethp()+":攻撃力　"+e.getattack());
    }
}
