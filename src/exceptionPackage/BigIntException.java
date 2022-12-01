/**
 * 
 */
package exceptionPackage;

/**
 * @author huongbui
 *
 */
public class BigIntException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BigIntException()
	{
		super("Please enter a number");
	}
	public BigIntException(String message)
	{
		super(message);
	}
	

}
