package cohen.polynomials;

import cohen.polynomials.SDLLC.Node;



	public class SDLLCtest  <Node> {
		//the head node's reference variable 
		    private Node head;
		    private Node iterator;
		    
		    int length;
		    /**
		     * Constructor instantiates the list as empty and not set the head or iterator.
		     * @param <T> 
		     */
		    public SDLLCtest()
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
		     * insert a node with info value val into the list
		     * @param value - insert a node holding value T
		     */
		    public void insert(int value) 
		    {
		        Node newNode = new Node(value);
		        
		        if(length == 0)
		        {
		            head = newNode;
		            iterator = head;
		            length++;
		        }
		        else
		        {
		            if(newNode.getInfo() > head.getInfo())
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
		                    if(newNode.getInfo() >= iterator.getInfo())
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
		    
	
		public SDLLCtest.Node getHead() {
	    		return head;
	    }
	
	class Node<Integer>
	{
	    private int info;
	    private Node<Integer> prior = null;
	    private Node<Integer> next = null;
	    
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
	    public Node(int info)
	    {
	        this.info = info;
	    }
	    
	    /**
	     * Constructor that sets all of the members. 
	     * @param info
	     * @param prior
	     * @param next
	     */
	    public Node(int info, Node prior, Node next)
	    {
	        this.info = info;
	        this.prior = prior;
	        this.next = next;
	    }
	    
	    /**
	     * The setInfo method sets this nodes info value.
	     * @param info The information to be assigned to this node. 
	     */
	    public void setInfo(int info)
	    {
	        this.info = info;
	    }
	    
	    /**
	     * The setPrior method sets the node's link to the node before it. 
	     * @param prior The node that comes before this node. 
	     * @return true if successful 
	     */
	    public void setPrior(Node<Integer> prior)
	    {
	        this.prior = prior;
	    }
	    
	    /**
	     * The setNext method sets the node's link to the one after it. 
	     * @param next The node that comes after this node. 
	     * @return true if successful
	     */
	    public void setNext(Node<Integer> next)
	    {
	        this.next = next;
	    }
	    
	    /**
	     * The getInfo returns the information assigned to this node. 
	     * @return info The information assigned to this node's info variable. 
	     */
	    public int getInfo()
	    {
	        return info;
	    }
	    
	    /**
	     * The getPrior method returns the reference to the node before this one. 
	     * @return prior The node right before this one. 
	     */
	    public Node<Integer> getPrior()
	    {
	        return prior;
	    }

	    /**
	     * The getNext method returns the reference to the node after this one.
	     * @return The node right after this one. 
	     */
	    public Node<Integer> getNext()
	    {
	        return next;
	    }
	}

}




