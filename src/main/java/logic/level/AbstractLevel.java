package main.java.logic.level;

import main.java.logic.brick.AbstracBrick;
import main.java.logic.brick.Brick;

import java.util.List;
import java.util.Observable;

public abstract class AbstractLevel extends Observable implements Level{
    protected String name;
    protected int bricksNumber;
    protected int points;
    protected int actualPoints;
    protected List<Brick> brickList;
    public Level nextLevel;

    public AbstractLevel(String n, List<Brick> list){
        brickList=list;
        bricksNumber=this.brickList.size();
        name=n;
        nextLevel=null;
        actualPoints=0;
        points=this.getPoints();
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

    public boolean hasNextLevel() {
        return nextLevel!=null;
    }

    public int getPoints() {
        for(Brick brick: brickList){
            points+=brick.getScore();
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


    public void update(Observable observable, Object o) {

    }

    public void visitGlassBrick(AbstracBrick b) {

    }

    public void visitWoodenBrick(AbstracBrick b) {

    }

    public void visitMetalBrick(AbstracBrick b) {

    }
}
