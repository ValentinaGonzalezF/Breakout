package main.java.logic.brick;
import main.java.logic.Visitable;
import java.util.Observable;
import main.java.logic.Visitor;
public abstract class AbstracBrick extends Observable implements Brick, Visitable {
    protected int hitPoints;
    protected int score;
    protected boolean destroyed;

    public AbstracBrick(){
        hitPoints=0;
        score=0;
        destroyed=false;
    }
    @Override
    public void hit(){
        if(!destroyed){
            hitPoints--;
        }
        hitPoints--;
        if (hitPoints==0){
            destroyed=true;
        }
    }
    @Override
    public boolean isDestroyed(){
        return destroyed;
    }
    @Override
    public int getScore(){
        return score;
    }
    @Override
    public int remainingHits(){
        return hitPoints;
    }

    public abstract void accept(Visitor v);
}
