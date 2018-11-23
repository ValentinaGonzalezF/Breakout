package logic.level;

import logic.VisitableBrick;
import logic.VisitorLevel;
import logic.brick.AbstracBrick;
import logic.brick.Brick;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import controller.Game;

public abstract class AbstractLevel extends Observable implements Level{
    protected String name;
    protected int bricksNumber;
    protected int points;
    protected int actualPoints;
    protected List<Brick> brickList;
    public Level nextLevel;
    protected String ultimo;

    public AbstractLevel(String n, List<Brick> list){
        brickList=list;
        bricksNumber=this.brickList.size();
        name=n;
        actualPoints=0;
        points=this.getPoints();
        ultimo="";
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBricks() {
        return bricksNumber;
    }

    public List<Brick> getBricks() {
        return brickList;
    }

    public Level getNextLevel() {
        return nextLevel;
    }

    //duda
    public boolean isPlayableLevel() {
        return true;
    }

    public abstract boolean hasNextLevel();

    public int getPoints() {
        if (points==0){
            for(Brick brick: brickList) {
                points += brick.getScore();
            }
        }
        return points;
    }

    public Level addPlayingLevel(Level level) {
        nextLevel=nextLevel.addPlayingLevel(level);
        return this;
    }

    public void setNextLevel(Level level) {
        nextLevel=level;
    }

    public int getActualPoints() {
        return actualPoints;
    }

    public void update(Observable observable, Object o) {
        if(observable instanceof Brick){
            ((AbstracBrick) observable).accept(this);
        }
    }
    public void suscribe(Game game){
        this.addObserver(game);
    }

    public void setUltimo(String s){
        ultimo=s;
    }
    public String getUltimo(){
        return ultimo;
    }
    public void visitGlassBrick(VisitableBrick b){
        actualPoints+= ((Brick)b).getScore();
        this.setUltimo("glass");
        setChanged();
        this.notifyObservers();
    }
    public void visitWoodenBrick(VisitableBrick b){
        actualPoints+= ((Brick)b).getScore();
        this.setUltimo("wooden");
        setChanged();
        this.notifyObservers();
    }
    public void visitMetalBrick(VisitableBrick b){
        actualPoints+= ((Brick)b).getScore();
        this.setUltimo("metal");
        setChanged();
        this.notifyObservers();
    }
}
