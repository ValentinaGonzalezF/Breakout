package graphics;
import com.almasb.fxgl.entity.Entities;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.RenderLayer;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;
import logic.brick.Brick;

import java.util.ArrayList;

public final class ExampleGameFactory {

    public static Entity newPlayer(double x, double y) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.KINEMATIC);

        return Entities.builder()
                .at(x, y)
                .type(BasicApp.ExampleType.PLAYER)
                .viewFromTexture("paddle.png")
                .bbox(new HitBox("Player", BoundingShape.box(130, 30)))
                .with(physics, new CollidableComponent(true))
                .with(new PlayerControl())
                .build();
    }

    public static Entity newBackground() {
        return Entities.builder()
                .viewFromTexture("fd.png")
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

    public static Entity newBall(double x, double y) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.setFixtureDef(new FixtureDef().restitution(1f).density(0.3f).friction(0f));

        return Entities.builder()
                .at(x, y)
                .type(BasicApp.ExampleType.BALL)
                .bbox(new HitBox("Ball", BoundingShape.circle(13)))
                .viewFromTexture("ball.png")
                .with(physics, new CollidableComponent(true))
                .build();
    }

    public static Entity newWalls() {
        Entity walls = Entities.makeScreenBounds(100);
        walls.setType(BasicApp.ExampleType.WALL);
        walls.addComponent(new CollidableComponent(true));
        return walls;
    }

    public static Entity newBrick(double x, double y, String s, Brick b) {
        return Entities.builder()
                .at(x,y)
                .type(BasicApp.ExampleType.BRICK)
                .viewFromTexture(s)
                .bbox(new HitBox("BrickGlass", BoundingShape.box(100, 30)))
                .with(new PhysicsComponent(), new CollidableComponent(true))
                .with(new BrickComponent(b))
                .build();
    }

}
