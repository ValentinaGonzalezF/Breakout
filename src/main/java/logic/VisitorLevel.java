package logic;
 /*
 *Interface que se realiza para que todos las clases que son Visitor tengan los mismos métodos.
 * @author vale
 */
public interface VisitorLevel {
    /**
     *Método que visita un GlassBrick,el que es un tipo Visitable
     * @param b  es el objeto que visitará
     */
    public void visitGlassBrick(VisitableBrick b);
    /**
     *Método que visita un WoodenBrick,el que es un tipo Visitable
     * @param b  es el objeto que visitará
     */
    public void visitWoodenBrick(VisitableBrick b);
    /**
     *Método que visita un MetalBrick,el que es un tipo Visitable
     * @param b  es el objeto que visitará
     */
    public void visitMetalBrick(VisitableBrick b);
}
