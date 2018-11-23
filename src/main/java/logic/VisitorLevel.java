package logic;
import controller.Game;

public interface VisitorLevel {
    public void visitGlassBrick(VisitableBrick b);
    public void visitWoodenBrick(VisitableBrick b);
    public void visitMetalBrick(VisitableBrick b);
}
