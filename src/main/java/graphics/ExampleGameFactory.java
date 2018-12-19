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

/**
 * Clase ExampleGameFactory que permite crear entidades tipo PLAYER,WALL,BALL y BRICK.
 * @author vale
 */
public final class ExampleGameFactory {
    /**
     * Función que permite crear una nueva entity de tipo player en una cierta posicion (x,y)
     * @param x double que es la posicion x en donde se pondrá la entidad
     * @param y double que es la posicion y en donde se pondrá la entidad
     * @return Entity que es en este caso de tipo PLAYER
     */
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

    /**
     * Función que permite crear una nueva entity que representa el fondo del juego
     * @return Entity
     */
    public static Entity newBackground() {
        return Entities.builder()
                .viewFromTexture("fd.png")
                .renderLayer(RenderLayer.BACKGROUND)
                .build();
    }

    /**
     * Función que permite crear una nueva entity que es de tipo BALL que representará la pelota que
     * estará en la GUI en donde se colocara en una posicion (x,y)
     * @param x double que representa la posición x en donde se encontrará la entity en la pantalla
     * @param y double que representa la posición y en donde se encontrará la entity en la pantalla
     * @return Entity de tipo BALL
     */
    public static Entity newBall(double x, double y) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        physics.setFixtureDef(new FixtureDef().restitution(1f).friction(0f));

        return Entities.builder()
                .at(x, y)
                .type(BasicApp.ExampleType.BALL)
                .bbox(new HitBox("Ball", BoundingShape.circle(13)))
                .viewFromTexture("ball.png")
                .with(physics, new CollidableComponent(true))
                .build();
    }

    /**
     * Función que permite crear la entity newWalls que es de tipo WALL que representa las murallas del juego
     * para que las otras entidades se encuentren delimitadas en un cierto espacio
     * @return Entity de tipo WALL
     */
    public static Entity newWalls() {
        Entity walls = Entities.makeScreenBounds(100);
        walls.setType(BasicApp.ExampleType.WALL);
        walls.addComponent(new CollidableComponent(true));
        return walls;
    }

    /**
     * Función que permite crear una Entity tipo brick que recibe los siguientes parametros
     * @param x double que representa la posición x en donde se encontrará la entity en la pantalla
     * @param y double que representa la posición y en donde se encontrará la entity en la pantalla
     * @param s String que representa la imagen que se le colocará para la GUI
     * @param b Brick que es el que se asociará a esta entidad para poder relacionar la GUI con FACADE
     *
     * @return
     */
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
