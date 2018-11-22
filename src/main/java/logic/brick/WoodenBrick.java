package main.java.logic.brick;
import main.java.logic.Visitor;

public class WoodenBrick extends AbstracBrick {
    public WoodenBrick(){
        super();
        hitPoints=3;
        score=200;
    }

    public void accept(Visitor v){
        v.visitWoodenBrick(this);
    }
}