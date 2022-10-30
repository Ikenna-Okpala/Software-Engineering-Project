package com.demontower;


public class EnemyPairAI implements Comparable<EnemyPairAI>{
    private int index;
    private int value;
    public EnemyPairAI(int index, int value)
    {
        this.index = index;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public int getIndex() {
        return index;
    }
    @Override
    public int compareTo(EnemyPairAI pair) {
        return this.getValue() - pair.getValue() ;

    }

    @Override
    public String toString() {
        return "" + value;
    }
}