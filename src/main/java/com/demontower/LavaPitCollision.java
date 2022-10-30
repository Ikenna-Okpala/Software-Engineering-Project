package com.demontower;

//How Trap respond to Collision
public class LavaPitCollision implements Collision{
    public <C1 extends Entity, C2 extends Entity> void collide(C1 entity1, C2 entity2) {
        if(entity1 instanceof LavaPit)
        {
            collideTrap((Player)entity1, (LavaPit)entity2);
        }
    }

    private void collideTrap(Player player, LavaPit trap)
    {
        collidePlayerWithTrap(player, trap);
    }

    private void collidePlayerWithTrap(Player player, LavaPit trap)
    {
        player.removeHealth(1);

        if(player.getHealth() <= 0) {
            player.setAlive(false);
        }
    }
}
