package main.java.logic.brick;
import main.java.logic.Visitor;
import main.java.controller.Game.*;


public class MetalBrick extends AbstracBrick {
    protected MetalBrick(){
        super();
        hitPoints=10;
    }

    public void accept(Visitor v){
        v.visitMetalBrick(this);
    }

    public int getScore(){
        return score;
    }
}
