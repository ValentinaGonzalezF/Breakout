package main.java.logic.brick;
import main.java.logic.Visitor;

public class GlassBrick extends AbstracBrick{
    public GlassBrick(){
        super();
        hitPoints=1;
        score=50;
    }
    public void accept(Visitor v){
        v.visitGlassBrick(this);
    }
}
