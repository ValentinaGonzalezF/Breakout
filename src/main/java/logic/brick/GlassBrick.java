package logic.brick;
import controller.Game;
import logic.VisitorLevel;

public class GlassBrick extends AbstracBrick{
    public GlassBrick(){
        super();
        hitPoints=1;
        score=50;
    }
    public void accept(VisitorLevel v){
        v.visitGlassBrick(this);
    }
}
