package main.java.logic;

import main.java.logic.brick.AbstracBrick;

public interface Visitor {
    public void visitGlassBrick(AbstracBrick b);
    public void visitWoodenBrick(AbstracBrick b);
    public void visitMetalBrick(AbstracBrick b);
}
