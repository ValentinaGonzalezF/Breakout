package logic.brick;
import logic.VisitorLevel;
/**
 * Clase GlassBrick que es una especializacion de la clase Abstracta AbstractBrick.
 * @author vale
 */
public class GlassBrick extends AbstractBrick{
    /**
     * Constructor de GlassBrick
     * Este constructor hace un llamado al constructor de la clase padre, el cual tiene los mismos atributos
     * y los inicializa según las especificaciones que debe tener un GlassBrick, las cuales serian
     * que tiene hitPoints igual a 1 y el score es de 50.
     */
    public GlassBrick(){
        super(1,50);
    }
    /**
     * Metodo que permite aceptar la visita de un level.
     * @param v es el visitor, el cual es tipo VisitorLevel.
     * Lo que hace el método es que el VisitorLevel v al querer visitar el GlassBrick, debe ser aceptado
     * , al ser aceptado realiza doble dispatch. Este level va a llamar al método interno que tiene, el cual es visitGlassBrick,
     */
    @Override
    public void accept(VisitorLevel v){
        v.visitGlassBrick(this);
    }
}
