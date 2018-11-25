package logic;
/*
Interface que se realiza para que todos las clases que son Visitables tengan los mismos métodos
 * @author vale
 */
public interface VisitableBrick{
    /**
     * Metodo que permite aceptar la visita de un level.
     * @param v es el visitor, el cual es tipo VisitorLevel.
     * Lo que hace el método es que el VisitorLevel v al querer visitar un VisitableBrick,debe ser aceptado.
     */
    public void accept(VisitorLevel v);
}
