package logic.level;
import logic.VisitableBrick;
import logic.VisitorLevel;
import logic.brick.*;
import java.util.List;
import java.util.Observer;
/**
 * Interface that represents the basics of a level to be played on.
 *
 * @author Juan-Pablo Silva
 */
public interface Level extends Observer,VisitorLevel {

    /**
     * Gets the level's name. Each level must have a name.
     *
     * @return the table's name
     */
    String getName();

    /**
     * Gets the number of {@link Brick} in the level.
     *
     * @return the number of Bricks in the level
     */
    int getNumberOfBricks();

    /**
     * Gets the {@link List} of {@link Brick}s in the level.
     *
     * @return the bricks in the level
     */
    List<Brick> getBricks();

    /**
     * Gets the next level of a level object. Each level have a reference to the next level to play.
     *
     * @return the next level
     */
    Level getNextLevel();

    /**
     * Gets whether the level is playable or not.
     *
     * @return true if the level is playable, false otherwise
     */
    boolean isPlayableLevel();

    /**
     * Whether the level's next level is playable or not.
     *
     * @return true if the level's next level is playable, false otherwise
     */
    boolean hasNextLevel();

    /**
     * Gets the total number of points obtainable in level.
     *
     * @return the number of points in the current level
     */
    int getPoints();

    /**
     * Adds a level to the list of levels. This adds the level in the last position of the list.
     *
     * @param level the level to be added
     */
    Level addPlayingLevel(Level level);

    /**
     * Sets the reference for the next level of a level object.
     *
     * @param level the next level of a level object
     */
    void setNextLevel(Level level);
    /**
     * Método que visita un GlassBrick,el que es un tipo Visitable
     * @param b es el objeto que visitará
     */
     void visitGlassBrick(VisitableBrick b);
    /**
     * Método que visita un WoodenBrick, el que es un tipo Visitable
     * @param b es el objeto que visitará
     */
    void visitWoodenBrick(VisitableBrick b);
    /**
     *Método que visita un MetalBrick,el que es un tipo Visitable
     * @param b  es el objeto que visitará
     */
    void visitMetalBrick(VisitableBrick b);
    /**
     * Método que permite setear el ultimo Brick que se destruyo como s
     * @param s que es el numero string
     */
    void setUltimo(String s);

    /**
     * Método que permite obtener los ActualPoints del level
     * @return actualPoints
     */
    int getActualPoints();
    /**
     * Método que permite obtener el ultimo Brick que se destruyo
     * @return ultimo
     */
    String getUltimo();
}
