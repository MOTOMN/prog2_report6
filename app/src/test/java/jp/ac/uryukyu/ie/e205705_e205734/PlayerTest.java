package jp.ac.uryukyu.ie.e205705_e205734;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * PlayerTestクラス。　
 * Playerクラスのattackメソッドのテストを行うメソッドを用意。
 */
public class PlayerTest {
    /**
     * attackメソッドのtestを行うメソッド
     * 検証手順
     *  (1)hero,enemyを準備。heroの攻撃力を10、enemyのHPを100に設定。
     *  (2)heroがenemyに一度だけattackを行う。
     *  (3)attackの結果、enemyのHPが10減り、90の値になることを期待。
     */
    @Test
    void attackTest(){
        Player hero = new Player("hero", 10,100);
        Enemy enemy = new Enemy("魔王", 10, 100,10);

        hero.attack(hero, enemy, 3);
        assertEquals(90, enemy.gethp());
    }
    
}
