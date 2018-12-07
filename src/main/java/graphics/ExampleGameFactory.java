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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public final class ExampleGameFactory {

    public static Entity newPlayer(double x, double y) {
        return Entities.builder()
                .at(x, y)
                .type(BasicApp.ExampleType.PLAYER)
                .viewFromNode(new Rectangle(100, 30, Color.BLUE))
                .build();
    }

    public static Entity newBackground() {
        return Entities.builder()
                .viewFromNode(new Rectangle(800, 800, Color.BLACK))
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

    public static Entity newBall(double x, double y) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.setOnPhysicsInitialized(
                () -> physics.setLinearVelocity(5 * 15, -5*15));
        physics.setFixtureDef(
                new FixtureDef().restitution(1f).density(0.1f));

        return Entities.builder()
                .at(x, y)
                .type(BasicApp.ExampleType.BALL)
                .bbox(new HitBox("Ball", BoundingShape.circle(10)))
                .viewFromNode(new Circle(10, Color.LIGHTCORAL))
                .with(physics, new CollidableComponent(true))
                .build();
    }

    public static Entity newWalls() {
        Entity walls = Entities.makeScreenBounds(100);
        walls.setType(BasicApp.ExampleType.WALL);
        walls.addComponent(new CollidableComponent(true));
        return walls;
    }

}
