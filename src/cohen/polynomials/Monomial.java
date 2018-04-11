package cohen.polynomials;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sarah
 */
public class Monomial implements Comparable<Monomial>
 {
    private int degree;
    private int coeff;
    
    /**
     * Constructor sets the classes two members to the user's input.
     */
    public <T>Monomial(int deg, int co)
    {
        this.degree = deg;
        this.coeff = co;
    }
    
    public void setDegree(int deg)
    {
        this.degree = deg;
    }
    
    public void setCoeff(int co)
    {
        this.coeff = co;
    }
    
    public int getDegree()
    {
        return degree;
    }
    
    public int getCoeff()
    {
        return coeff;
    }
   
    
    public boolean isEquals(Monomial mon)
    {
        if(this.compareTo(mon)==0)
        {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int compareTo(Monomial mon)
    {
       int result;
       if(mon.degree < this.degree)
       {
           result = -1;
       }
       else if(mon.degree > this.degree)
       {
          result = 1; 
       }
       else
       {
           result = 0;
       }
       return result;
    }
}
