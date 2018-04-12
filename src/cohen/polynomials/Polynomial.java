package cohen.polynomials;

import java.util.*;

public class Polynomial {
	LinkedList<Monomial> terms;
	
	public Polynomial() {
		terms = new LinkedList();
	}
	
	 /**
	  * The addTerm method is to add a single monomial to the list terms. 
	  * If there are any like terms, they are added together. 
	  * @param term the other monomial to be added
	  */
	 public void addTerm(int deg, int co)
	 {
		 Monomial monomial = new Monomial(deg, co);
		 if(this.terms.size() == 0) {
			 terms.add(monomial);
		 }
	     else {
	    	 	ListIterator<Monomial> listIterator = terms.listIterator();
	    	 	while(listIterator.hasNext())
            if(monomial.getDegree() == listIterator.next().getDegree()) {
                listIterator.next().addMonomials(monomial);
            }
            else {
            		terms.add(monomial);
            }
         }
	 }
	 
	 /**
	  * The subtractTerm method is to take away a single monomial from the list terms.
	  */
	 
	 
	 /**
	  * The multiplyMonomial method is to multiply the given polynomial by a monomial.
	  * @param deg
	  * @param co
	  */
	 public void multiplyMonomial(int deg, int co) {
		Monomial monomial = new Monomial(deg, co);
		if(terms.size() > 0) {
			ListIterator<Monomial> listIterator = terms.listIterator();
			while(listIterator.hasNext()) {
				listIterator.next().multiplyMonomials(monomial);
			}
		}
	 }

	  
	  /**
	   * The timesConst method is to multiply the given polynomial by a constant
	   * @param const
	   */
	 public void timesConst(int constant) 
	 {
			if(terms.size() > 0) {
				ListIterator<Monomial> listIterator = terms.listIterator();
				while(listIterator.hasNext()) {
					listIterator.next().multiplyConstant(constant);
				}
			}
	  }  
	 
	 /**
	  * The method printPolynomial is used to create and return a string of a completed polynomial.
	  * The method first dumps all of the linked list data into an array list, sorts it, and loops 
	  * through it adding to a string that it will return. 
	  * @return
	  */
	 public String printPolynomial() {
		 List<Monomial> arrayListMonomial = new ArrayList<>();
		 arrayListMonomial.addAll(0, terms);
		 
		 Collections.sort(arrayListMonomial, Collections.reverseOrder());
		 String string = null;
		 ListIterator<Monomial> listIterator = arrayListMonomial.listIterator();
			while(listIterator.hasNext()){
				if      (listIterator.next().getCoeff() > 0) {
				string = string + " + " +   listIterator.next().getCoeff()  + "x^" + listIterator.next().getDegree() + " /n";
				}
              
			}     		
       return string;

	 }
	 
	 public void makeEmpty() {
		 terms = null;
	 }




}
