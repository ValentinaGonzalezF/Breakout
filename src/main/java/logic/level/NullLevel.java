package logic.level;
import logic.brick.Brick;
import java.util.*;
/**
 * Clase NullLevel que es una especializacion de la clase Abstracta AbstractLevel que permite trabajar
 * con niveles null.
 * @author vale
 */
public class NullLevel extends AbstractLevel{
    /**
     * Constructor de NullLevel
     * @param n
     * @param list
     * Este constructor hace un llamado al constructor de la clase padre, el cual tiene los mismos atributos
     * y los inicializa según los parametros que recibe, los cuales son n que será el nombre del level
     * y la lista de brick del level. Luego inicializa el nextLevel como el mismo.
     */
    public NullLevel(String n, List<Brick> list) {
        super(n,list);
        this.nextLevel=this;
    }

    /**
     * Metodo que retorna si el level es Playable o no. En este caso siempre retornará false,
     * ya que es un nullLevel.
     * @return false
     */
    @Override
    public boolean isPlayableLevel() {
        return false;
    }
    /**
     * Metodo que retorna si el level tiene siguiente nivel o no. En este caso siempre retornará false,
     * ya que es un nullLevel, por lo que no tiene un siguiente nivel
     * @return false
     */
    @Override
    public boolean hasNextLevel() {
        return false;
    }
    /**
     * Añade el nivel level a la lista enlazada que tiene level.
     * @param level el level que será añadido
     * @return level, que es el siguiente nivel.
     * Esto agrega el nivel level en la referencia que tiene nullLevel de nextLevel.
     */
    @Override
    public Level addPlayingLevel(Level level) {
        nextLevel=level;
        return level;
    }
}
