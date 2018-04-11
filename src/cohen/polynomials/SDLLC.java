package cohen.polynomials;

/**
 * The SDLLC class defines the members and functions for a doubly linked list structure. 
 * It implements the SDLLI interface. 
 * @author Sarah Cohen
 */

public class SDLLC  <T extends Comparable<T>> {
//the head node's reference variable 
    private Node<T> head;
    private Node<T> iterator;
    
    int length;
    /**
     * Constructor instantiates the list as empty and not set the head or iterator.
     * @param <T> 
     */
    public <T>SDLLC()
    {
        this.length = 0;
    }
    
        /**
     * The method isEmpty checks that the list is empty and returns true if it is.
     * @return 
     */
    public boolean isEmpty()
    {
        return length == 0;
    }
    
        /**
     * The method makeEmpty sets the reference of 'head' to null, cutting off any 
     * link to the first node. With no link to any node at all, the list is effectively empty.
     * @return True if the method was a success. False if not. 
     */
    public void makeEmpty()
    {
        head = null;
        //return isEmpty();
        length=0;
    }
    
	/**
     * insert a node with info value val into the list
     * @param value - insert a node holding value T
     */
    public void insert(T value) 
    {
        Node<T> newNode = new Node(value);
        
        if(length == 0)
        {
            head = newNode;
            iterator = head;
            length++;
        }
        else
        {
            if(newNode.getInfo().compareTo(head.getInfo()) > 0)
            {
                newNode.setNext(head);
                head.setPrior(newNode);
                head = newNode;  
                length++;
            }
            
            else 
            {
                iterator = head.getNext();
                while(iterator != null)
                {
                    if(newNode.getInfo().compareTo(iterator.getInfo()) >= 0)
                    {
                       newNode.setNext(iterator);
                       newNode.setPrior(iterator.getPrior());
                       iterator.getPrior().setNext(newNode);
                       iterator.setPrior(newNode);
                       length++;
                       
                    } 
                    else if(iterator.getNext() == null)
                    {
                    	   iterator.setNext(newNode);
                        newNode.setPrior(iterator);
                        length++;
                    }
                    iterator = iterator.getNext();
                    
                }
            }
        }
    }
    
    /**
     * remove the node holding value T
     * @param value - T value to be removed
     * @return boolean true if removed, false, if no such value in the list
     */
    public boolean remove(T value)
    {
        if(length==0)
        {
            return false;
        }
        else 
        {
            Node<T> current = head;
            while(current != null)
            {
                if(current.getInfo().equals(value))
                {
                    if(length == 1){ //if node to be deleted is only one in list
                        head = null;
                        length = 0;
                    }
                    else if(current.getNext() == null)//node is tail
                    {
                        current.getPrior().setNext(null);
                        length--;
                    }
                    else if(current == head)
                    {
                        head = current.getNext();
                        current.getNext().setPrior(null);
                        length--;
                    }
                    else
                    {
                        current.getNext().setPrior(current.getPrior()); 
                        current.getPrior().setNext(current.getNext());
                        length--; 
                    }
                    
                    return true;
                }
                current = current.getNext();
            }
            return false;
        }
    }
    
    
    /**
     * initialize the list for a subsequent call to next
     *
     */
    public void setFirst()
    {
        iterator = head;
       /**Node<T> newNode = new Node(value);
       newNode.setNext(head);
       head.setPrior(newNode);
       head=newNode;**/
    }
    
    /**
     * indicate whether a call to next will succeed
     * @return boolean true if the current node is not null, false otherwise
     */
    public boolean hasNext()
    {
        return iterator.next != null;
    }
    
    /**
     * return the value of the current node of type T
     * and advance the current node to current.getNext()
     * @return - value held by the current node of type T, and if iterator has reached end or if null then return null
     */
    public T next()
    {
        if(iterator == null)
        {
            return null;
        }
        else
        {
            return iterator.getInfo();
        }
            
    }
    
    public SDLLC<T>.Node<T> getHead() {
    		return head;
    }
      
    
    class Node<T>
    {
        private T info = null;
        private Node<T> prior = null;
        private Node<T> next = null;
        
        /**
         * Empty Constructor that leaved all of the members as null. 
         */
        public Node()
        {

        }
        
        /**
         * Constructor that sets only the info member.
         * @param info
         */
        public Node(T info)
        {
            this.info = (T) info;
        }
        
        /**
         * Constructor that sets all of the members. 
         * @param info
         * @param prior
         * @param next
         */
        public Node(T info, Node prior, Node next)
        {
            this.info = info;
            this.prior = prior;
            this.next = next;
        }
        
        /**
         * The setInfo method sets this nodes info value.
         * @param info The information to be assigned to this node. 
         */
        public void setInfo(T info)
        {
            this.info = info;
        }
        
        /**
         * The setPrior method sets the node's link to the node before it. 
         * @param prior The node that comes before this node. 
         * @return true if successful 
         */
        public void setPrior(Node<T> prior)
        {
            this.prior = prior;
        }
        
        /**
         * The setNext method sets the node's link to the one after it. 
         * @param next The node that comes after this node. 
         * @return true if successful
         */
        public void setNext(Node<T> next)
        {
            this.next = next;
        }
        
        /**
         * The getInfo returns the information assigned to this node. 
         * @return info The information assigned to this node's info variable. 
         */
        public T getInfo()
        {
            return info;
        }
        
        /**
         * The getPrior method returns the reference to the node before this one. 
         * @return prior The node right before this one. 
         */
        public Node<T> getPrior()
        {
            return prior;
        }

        /**
         * The getNext method returns the reference to the node after this one.
         * @return The node right after this one. 
         */
        public Node<T> getNext()
        {
            return next;
        }
    }
}


