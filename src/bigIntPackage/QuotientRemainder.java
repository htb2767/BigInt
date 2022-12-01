/**
 * 
 */
package bigIntPackage;

import java.util.ArrayList;

/**
 * @author huongbui
 *
 */
public class QuotientRemainder {
	private ArrayList<Character> quotient =null;
	private ArrayList<Character> remainder =null;
	public QuotientRemainder(ArrayList<Character> pQuotient,ArrayList<Character> pRemainder)
	{
		quotient=pQuotient;
		remainder=pRemainder;
	}
	public ArrayList<Character> getQuotient() {
		return quotient;
	}
	public void setQuotient(ArrayList<Character> quotient) {
		this.quotient = quotient;
	}
	public ArrayList<Character> getRemainder() {
		return remainder;
	}
	public void setRemainder(ArrayList<Character> remainder) {
		this.remainder = remainder;
	}
	

}
