package cohen.polynomials;

/**
 * @author Sarah Cohen
 */
public interface SDLLI<T>
{
    /**
     * insert a node with info value val into the list
     * @param val - insert a node holding value T
     */
    public void insert(T val);
    
    /**
     * remove the node holding value T
     * @param val - T value to be removed
     * @return boolean true if removed, false, if no such value in the list
     */
    public boolean remove(T val);
    
    /**
     * initialize the list for a subsequent call to next
     */
    public void setFirst();
    
    /**
     * indicate whether a call to next will succeed
     * @return boolean true if the current node is not null, false otherwise
     */
    public boolean hasNext();
    
    /**
     * return the value of the current node of type T
     * and advance the current node to current.getNext()
     * @return - value held by the current node of type T
     */
    public T next();


}
