package cohen.polynomials;

import java.util.*;

public class Polynomial {
	LinkedList<Monomial> terms;

	public Polynomial() {
		terms = new LinkedList<Monomial>();
	}

	/**
	 * The addTerm method is to add a single monomial to the list terms. If there
	 * are any like terms, they are added together.
	 * 
	 * @param term
	 *            the other monomial to be added
	 */
	public void addTerm(int deg, int co) {
		Monomial monomial = new Monomial(deg, co);
		if (this.terms.size() == 0) {
			terms.add(monomial);
		} else if (monomial.getDegree() > terms.get(0).getDegree()) {
			terms.addFirst(monomial);
		} else {
			for (Monomial mon : terms) {
				if (mon.getDegree() == monomial.getDegree()) {
					mon.addMonomials(monomial);
				} else {
					terms.add(monomial);
				}
			}
		}
	}

	/**
	 * The multiplyMonomial method is to multiply the given polynomial by a
	 * monomial.
	 * 
	 * @param deg
	 * @param co
	 */
	public void multiplyMonomial(int deg, int co) {
		Monomial monomial = new Monomial(deg, co);
		if (terms.size() > 0) {
			for (Monomial mon : terms) {
				mon.multiplyMonomials(monomial);
			}
		}
	}

	/**
	 * The timesConst method is to multiply the given polynomial by a constant
	 * 
	 * @param const
	 *            - The constant number to multiply the linked list of monomials,
	 *            terms, by
	 */
	public void timesConst(int constant) {
		if (terms.size() > 0) {
			for (Monomial mon : terms) {
				mon.multiplyConstant(constant);
			}
		}
	}

	/**
	 * The method printPolynomial is used to create and return a string of a
	 * completed polynomial.
	 * 
	 * @return String with all of the monomials in the terms linked list
	 */
	public String toString() {
		StringBuilder string = new StringBuilder();
		if (terms.size() != 0) {
			for (Monomial mon : terms) {
				if (mon.getCoeff() > 0) {
					string.append( mon.getCoeff() + "x^" + mon.getDegree() + " + ");
				}
				else {
					string.append(mon.getDegree());
				}

			}
		} else {
			string.append("empty polynomial");
		}
		return string.toString();
	}

	public void makeEmpty() {
		terms.clear();
	}

}
