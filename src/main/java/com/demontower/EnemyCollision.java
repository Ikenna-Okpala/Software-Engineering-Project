package com.demontower;


//How Enemy respond to Collision
public class EnemyCollision implements Collision{
    @Override
    public <C1 extends Entity, C2 extends Entity> void collide(C1 entity1, C2 entity2) {
        if(entity1 instanceof  Enemy)
        {
            collideEnemy((Player)entity1, (Enemy)entity2);
        }
    }

    private void collideEnemy(Player player, Enemy Enemy)
    {
        collidePlayerWithEnemy(player, Enemy);
    }

    //Kill player
    private void collidePlayerWithEnemy(Player player, Enemy enemy)
    {
        player.removeHealth(1);

        if(player.getHealth() <= 0) {
            player.setAlive(false);
        }
    }

}
