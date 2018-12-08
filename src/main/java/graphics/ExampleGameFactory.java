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
                .viewFromTexture("f4.png")
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

    public static Entity newBall(double x, double y) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.setFixtureDef(
                new FixtureDef().restitution(1f).density(0.1f).friction(0f));

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

    public static Entity newBrickGlass(double x,double y) {
        return Entities.builder()
                .at(x,y)
                .type(BasicApp.ExampleType.BRICK)
                .viewFromTexture("glass.png")
                .bbox(new HitBox("BrickGlass", BoundingShape.box(100, 30)))
                .with(new PhysicsComponent(), new CollidableComponent(true))
                .build();
    }

    public static Entity newBrickWooden(double x,double y) {
        return Entities.builder()
                .at(x,y)
                .type(BasicApp.ExampleType.BRICK)
                .viewFromTexture("wood.png")
                .bbox(new HitBox("BrickWooden", BoundingShape.box(100, 30)))
                .with(new PhysicsComponent(), new CollidableComponent(true))
                .build();
    }

    public static Entity newBrickMetal(double x,double y) {
        return Entities.builder()
                .at(x,y)
                .type(BasicApp.ExampleType.BRICKMETAL)
                .viewFromTexture("metal.png")
                .bbox(new HitBox("BrickMetal", BoundingShape.box(100, 30)))
                .with(new PhysicsComponent(), new CollidableComponent(true))
                .build();
    }

    public static Entity newLevel(ArrayList<Entity> bricks){

        return Entities.builder()
                .type(BasicApp.ExampleType.LEVEL)
                .build();

    }
}
