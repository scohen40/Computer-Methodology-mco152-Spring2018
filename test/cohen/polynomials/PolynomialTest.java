package cohen.polynomials;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PolynomialTest {

	@Test
	public void testInsert() {
		//given
		Polynomial p = new Polynomial();
		//when
		p.addTerm(5, 5);
		p.addTerm(4, 6);
		p.toString();
		//then
		Assert.assertEquals(new Integer(5), new Integer(p.terms.getFirst().getCoeff()));
	}
	
	@Test
	public void testMultiplyConst() {
		//given
		Polynomial p = new Polynomial();
		//when
		p.addTerm(5, 5);
		p.timesConst(5);
		//then
		Assert.assertEquals(new Integer(25), new Integer(p.terms.getFirst().getCoeff()));
	}

	@Test
	public void testMultiplyMon() {
		//given
		Polynomial p = new Polynomial();
		//when
		p.addTerm(5, 5);
		p.multiplyMonomial(5, 5); 
		//then
		Assert.assertEquals(new Integer(25), new Integer(p.terms.getFirst().getCoeff()));
		Assert.assertEquals(new Integer(10), new Integer(p.terms.getFirst().getDegree()));	
	}
	
}
