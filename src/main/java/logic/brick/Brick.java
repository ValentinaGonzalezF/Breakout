package logic.brick;
import logic.VisitableBrick;
import logic.level.Level;

/**
 * Interface that represents a brick object.
 * <p>
 * All bricks should implement this interface.
 *
 * @author Juan-Pablo Silva
 */
public interface Brick extends VisitableBrick {
    /**
     * Defines that a brick has been hit.
     * Implementations should consider the events that a hit to a brick can trigger.
     */
    void hit();

    /**
     * Gets whether the brick object is destroyed or not.
     *
     * @return true if the brick is destroyed, false otherwise
     */
    boolean isDestroyed();

    /**
     * Gets the points corresponding to the destroying of a brick object.
     *
     * @return the associated points of a brick object
     */
    int getScore();

    /**
     * Gets the remaining hits the brick has to receive before being destroyed.
     *
     * @return the remaining hits to destroy de brick
     */
    int remainingHits();
    /**
     * Método que permite agrega un level a la lista de observadores que tiene un brick
     * @param level es el level que se añadirá a la lista.
     */
    void subscribe(Level level);

    /**
     * Método que permite saber si el brick es de tipo Wooden
     * @ return true si es Wooden y false en cualquier otro caso.
     */
    boolean isWooden();

    /**
     * Método que permite saber si el brick es de tipo Metal
     * @ return true si es Metal y false en cualquier otro caso.
     */
    boolean isMetal();

    /**
     * Método que permite saber si el brick es de tipo Glass
     * @ return true si es Glass y false en cualquier otro caso.
     */
    boolean isGlass();

    /**
     * Método que permite saber si el brick es de tipo Golden
     * @ return true si es golden y false en cualquier otro caso.
     */
    boolean isGolden();

}
