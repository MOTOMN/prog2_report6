package jp.ac.uryukyu.ie.e205705_e205734;

public class Enemy extends Character{

    private int giveExp;

    public int getgiveExp(){return this.giveExp;}

    public Enemy(String name,int attack,int hp,int giveExp){
        super(name, attack, hp);
        this.giveExp = giveExp;
    }

    @Override
    public void attack(Character player, Character target,int value){
        if(super.getsleep() == true){
            System.out.println(player.getname()+"は眠っている！");
            super.sleepturn(player,2);
        }else{
            if(super.getpoison() == true){
                System.out.println(player.getname()+"は毒状態だ！");
                int poisonDmg = player.gethp()/5;
                int lackhp = player.gethp()-poisonDmg;
                player.sethp(lackhp);
                System.out.println(player.getname()+"は毒により、"+poisonDmg+"ダメージ受けた！");
            }
            switch(value){
                case 0:
                    System.out.println(player.getname()+"の連続攻撃！");
                    int attackvalue = player.getattack()*2;
                    int lackhp1 = target.gethp()-attackvalue;
                    target.sethp(lackhp1);
                    System.out.println(target.getname()+"は"+attackvalue+"ダメージ受けた！");
                    break;
                case 1:
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
                    System.out.println(player.getname()+"の怒り！");
                    player.setattack(player.getattack()+5);
                    System.out.println(player.getname()+"は攻撃力が上がった！攻撃力："+player.getattack());
                    break;
                default:
                    super.attack(player, target, value);
            }
        }
    }
}
