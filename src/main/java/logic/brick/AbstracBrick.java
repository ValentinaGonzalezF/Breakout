package logic.brick;
import controller.Game;
import logic.VisitableBrick;
import java.util.Observable;
import logic.VisitorLevel;
import logic.level.*;
public abstract class AbstracBrick extends Observable implements Brick, VisitableBrick {
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
        if (hitPoints==0) {
            destroyed=true;
            this.setChanged();
            this.notifyObservers();
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

    public abstract void accept(VisitorLevel v);

    public void suscribe(Level level){
        addObserver(level);
    }

}
