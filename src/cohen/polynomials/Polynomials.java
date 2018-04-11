package cohen.polynomials;

public class Polynomials {
	public static void main(String[] args) {
		SDLLCtest<Integer> c = new SDLLCtest();
		c.insert(2);
		System.out.println(c.getHead().getInfo());
		//c.insert(5);
		//System.out.println(c.getHead().getNext().getInfo());
		
	}
}



// class Polynomial {
//    SDLLC<Monomial> terms;
//    
//    public Polynomial()
//    {
//        terms = new SDLLC<Monomial>();
//    }
//    
//    /**
//     * to add a single Monomial to the list terms.
//     * @param term the other monomial to be added
//     */
//    public void addTerm(Monomial term)
//    {
//        terms.insert(term);//i have insert in two places- in sdllc insert and monomial insert...so which one should be used?
//    }
//    
//    /**
//     * to add another polynomial to the given instance.
//     * @param other polynomial
//     */
//    public void add(Polynomial other)
//    {
//        if(other.terms.length != 0)
//        {
//            terms.setFirst();
//            while(other.terms.hasNext())
//            {
//                addTerm(other.terms.next());
//            }
//        }
//    }
//    
//    /**
//     * Same action as add, except that the given instance is not altered.
//     * Instead, the sum of the given instance and other is returned.
//     * @param other
//     * @return 
//     */
//    public Polynomial sum(Polynomial other)
//    {
//        Polynomial seperate = new Polynomial();
//        seperate.add(this);
//        seperate.add(other);
//        return seperate;
//    }
//    
//    /**
//     * to multiply the given instance by a constant
//     * @param const
//     */
//    public void timesConst(double constant) 
//    {
//        if(!terms.isEmpty())
//        {
//            terms.setFirst();
//            while(terms.hasNext())
//            {
//                Monomial t = terms.next();
//                t.setCoeff((int) (t.getCoeff()*constant));
//            }
//        }
//    }   
//    
//    /**
//     * same action as timesConst, except that the given instance is not altered.  
//     * Instead, the product of the given instance and the constant 'constant' is returned.
//     * @param constant to multiply the polynomial by
//     * @return seperate the product of the multiplication
//     */
//    public Polynomial constProduct(double constant)
//    {
//        Polynomial seperate = new Polynomial();
//        seperate.add(this);
//        seperate.timesConst(constant);
//        return seperate;
//    }
//
//
//    
//        /**
//     * to multiply the given instance by another polynomial.
//     * @param other 
//     */
//    public void times(Polynomial other) 
//    {
//        if(!terms.isEmpty() && !other.terms.isEmpty())
//        {
//            terms.setFirst();
//            other.terms.setFirst();
//            while(terms.hasNext())
//            {
//                Monomial T = terms.next();
//                while(other.terms.hasNext())
//                {
//                    Monomial t = other.terms.next();
//                    T.setCoeff(T.getCoeff()*t.getCoeff());
//                    T.setDegree(T.getDegree()*t.getDegree());
//                }                              
//            }
//        }
//    }
//    
//    /**
//     * same action as times, except that the given instance is not altered.  
//     * Instead, the product of the given instance and the other polynomial is returned.
//     * @param other
//     * @return 
//     */
//    public Polynomial product(Polynomial other) 
//    {
//        Polynomial seperate = new Polynomial();
//        seperate.add(this);
//        seperate.times(other);
//        return seperate;
//    }
//
//    /**
//     * perhaps should actually return strings like 
//     * 2.0 + 3.1x + 4.2x^2 – 5.0x^4
//     * Some method to “roll up” terms with the same degrees, i.e.,
//     * 2.0 + 5.3 + 3.1x + 2.0x + 4.2x^2   
//     * should be rolled up to 
//     * 7.3 + 5.1x + 4.2x^2  
//     * @return 
//     */
//    public String toString()
//    {
//        rollUp();
//        String s = "";
//        terms.setFirst();
//        Monomial current = null;
//        while(terms.hasNext())
//        {
//            current = terms.next();
//            if      (current.getCoeff() > 0) 
//                s = s + " + " +   current.getCoeff()  + "x^" + current.getDegree();
//            else if (current.getCoeff() <= 0) 
//                s = s + " - " + (-current.getCoeff()) + "x^" + current.getDegree();
//        }
//        return s;
//
//    }
//
//    private void rollUp()
//    {
//        if(!terms.isEmpty())
//        {
//            SDLLC<Monomial> newPolynomial = new SDLLC<Monomial>();
//            terms.setFirst();
//            Monomial current = null;
//            ArrayList<Monomial> similars = new ArrayList<Monomial>();
//            similars.add(terms.next());
//            while(terms.hasNext())
//            {
//                current = terms.next();
//                if(current.getDegree() != similars.get(0).getDegree())
//                {    
//                    newPolynomial.insert(addStack(similars));
//                }
//                similars.add(current);
//            }
//            newPolynomial.insert(addStack(similars));
//            
//        }         
//    }
//    
//    private Monomial addStack(ArrayList<Monomial> list)
//    {
//        Monomial added = null;
//        int refDegree = list.get(0).getDegree();
//        int refCoeff = list.get(0).getCoeff();
//        for(Monomial m : list)
//        {
//            refCoeff += m.getCoeff();
//        }
//        
//        return added;
//    }
//
//}
