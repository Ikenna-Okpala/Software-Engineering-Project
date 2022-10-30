package com.demontower;

// Resopond to two entity's collision on board
public interface Collision {

    <C1 extends Entity, C2 extends Entity> void collide(C1 entity1, C2 entity2);
}
