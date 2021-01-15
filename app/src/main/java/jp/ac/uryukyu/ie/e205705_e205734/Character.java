package jp.ac.uryukyu.ie.e205705_e205734;

public class Character {
    private String name;
    private  int attack;
    private int maxAttack;
    private int hp;
    private int maxHp;
    private int sleepturn;
    private boolean dead;
    private boolean poison;
    private boolean sleep;

    public Character(String name, int attack, int hp){
        this.name = name;
        this.attack = attack;
        this.maxAttack = attack;
        this.hp = hp;
        this.maxHp = hp;
        this.dead = false;
        this.poison = false;
        this.sleep = false;
        this.sleepturn = 0;
    }

    public void attack(Character player, Character target,int value){
        System.out.println(player.name+"の通常攻撃！");
        target.hp -= player.attack;
        System.out.println(target.name+"は"+player.attack+"ダメージ受けた！");
    }

    public void chdead(Character e){
        if(e.hp<=0){
            e.dead = true;
        }
    }
    public String getname(){return this.name;}

    public int gethp(){return this.hp;}

    public int getmaxHp(){return this.maxHp;}

    public boolean getdead(){return this.dead;}

    public int getattack(){return this.attack;}

    public int getmaxAttack(){return this.maxAttack;}

    public boolean getpoison(){return this.poison;}

    public boolean getsleep(){return this.sleep;}

    public void setattack(int value){this.attack = value;}

    public void setmaxHp(int value){this.maxHp = value;}

    public void setdead(boolean set){this.dead = set;}

    public void sethp(int value){this.hp = value;}

    public void setpoison(boolean set){this.poison = set;}

    public void setsleep(boolean set){this.sleep = set;}

    public void setsleepturn(int set){this.sleepturn = set;}

    public void heal(int value){
        this.hp += value;
    }

    public void status(Character player1,Character player2){
        System.out.println(player1.name+" VS "+player2.name);
        System.out.println(player1.name+"のHP:"+player1.hp+"　攻撃力:"+player1.attack);
        System.out.println(player2.name+"のHP:"+player2.hp+"　攻撃力:"+player2.attack);
    }

    public void sleepturn(Character e,int turn){
        if(sleepturn == turn){
            e.sleep = false;
            sleepturn = 0;
            System.out.println(e.name+"は目覚めた！");
        }else{
            sleepturn += 1;
        }
    }

    
    
}
