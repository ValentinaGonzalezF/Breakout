package logic.level;
import logic.brick.Brick;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase ClassLevel que es una especializacion de la clase Abstracta AbstractLevel.
 * @author vale
 */
public class ClassLevel extends AbstractLevel{
    /**
     * Constructor de ClassLevel
     * @param n
     * @param list
     * Este constructor hace un llamado al constructor de la clase padre, el cual tiene los mismos atributos
     * y los inicializa según los parametros que recibe, los cuales son n que será el nombre del level
     * y la lista de brick del level. Luego se setea el nextLevel como un NullLevel con nombre "" y una lista
     * vacia de bricks
     */
    public ClassLevel(String n, List<Brick> list){
        super(n,list);
        setNextLevel(new NullLevel(name, new ArrayList<>()));
    }
    /**
     * Whether the level's next level is playable or not.
     *
     * @return true if the level's next level is playable, false otherwise
     */
    @Override
    public boolean hasNextLevel() {
        return this.nextLevel.isPlayableLevel();
    }

}
