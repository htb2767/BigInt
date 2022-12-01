/**
 * 
 */
package bigIntPackage;

import java.util.ArrayList;
import exceptionPackage.BigIntException;

/**
 * @author huongbui
 *
 */
public class BigInt {
	private ArrayList<Character> myArr;
	private char sign =0;
	private QuotientRemainder quotienRemainder;
	

	public BigInt(String myString) throws BigIntException {
		myArr = new ArrayList<Character>();
		int index=0;
		if(!myString.matches("^[-+][0-9]+|[0-9]+"))
		{
			throw new BigIntException();
		}
		if(myString.charAt(0)==('+'))
		{
			myString=myString.substring(1);
			sign='+';
		}
		else if(myString.charAt(0)==('-'))
		{
			myString=myString.substring(1);
			sign='-';
		}
		else
		{
			sign='+';
		}
		
		for(int kIndex=index;kIndex<myString.length();kIndex++)
		{
			myArr.add(myString.charAt(kIndex));
		}
		
		

	}

	public BigInt(char sign, ArrayList<Character> myArr) {
		this.sign=sign;
		this.myArr=myArr;
	}

	public ArrayList<Character> getArray()
	{
		return myArr;
		
	}
	public Character getSign()
	{
		return sign;
	}
	/**
	 * @Precondition: BigNumberOne and BigNumberTwo must be valid
	 * @postcondition: addition of two big int
	 * @Algorithm:
	 * Declare int lengthOne=this.getArray().size()
	 * Declare int lengthTwo=bigNumberTwo.getArray().size()
	 * Declare char sign
	 * Determine the sign of bigNumberOne and bigNumberTwo and then set them into if else condition
	 * Call the method addtion(lengthOne, lengthTwo,myArr,this,bigNumberTwo) or substraction(lengthTwo, 
	 * lengthOne,myArr,bigNumberTwo,this) depending on the sign and the length
	 * @param bigNumberTwo
	 * @return: BigInt
	 */
	

	public BigInt add(BigInt bigNumberTwo) {
		
		int lengthOne=this.getArray().size();
		int lengthTwo=bigNumberTwo.getArray().size();
		//BigInt ans = null ;
		char sign=0;
		ArrayList<Character> myArr= new ArrayList<Character>();
		if(this.getSign()=='+'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)>=0)
		{
			
			for(int i=0;i<lengthOne+1;i++)
			{
				myArr.add('0');
			}
			sign='+';
			addtion(lengthOne, lengthTwo,myArr,this,bigNumberTwo);			
			
			
			
		}
		else if(this.getSign()=='+'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)<0)
		{
			for(int i=0;i<lengthTwo+1;i++)
			{
				myArr.add('0');
			}
			sign='+';
			addtion(lengthTwo, lengthOne,myArr,bigNumberTwo,this);
		}
		else if(this.getSign()=='-'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)==0)
		{
			sign='+';
			myArr.add('0');
		}
		else if(this.getSign()=='-'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)<0)
		{
			for(int i=0;i<lengthTwo;i++)
			{
				myArr.add('0');
			}			
			sign='+';
			substraction(lengthTwo, lengthOne,myArr,bigNumberTwo,this);
		}
		else if(this.getSign()=='-'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)>0)
		{
			for(int i=0;i<lengthOne;i++)
			{
				myArr.add('0');
			}
			sign='-';
			substraction(lengthOne, lengthTwo,myArr,this,bigNumberTwo);
		}
		else if(this.getSign()=='+'&&bigNumberTwo.getSign()=='-'&&this.compareTo(bigNumberTwo)<0)
		{
			for(int i=0;i<lengthTwo;i++)
			{
				myArr.add('0');
			}
			sign='-';
			substraction(lengthTwo, lengthOne,myArr,bigNumberTwo,this);
		}
		else if(this.getSign()=='+'&&bigNumberTwo.getSign()=='-'&&this.compareTo(bigNumberTwo)>0)
		{
			for(int i=0;i<lengthOne;i++)
			{
				myArr.add('0');
			}
			sign='+';
			substraction(lengthOne, lengthTwo,myArr,this,bigNumberTwo);
		}
		else if(this.getSign()=='-'&&bigNumberTwo.getSign()=='-'&&this.compareTo(bigNumberTwo)>=0)
		{
			for(int i=0;i<lengthOne+1;i++)
			{
				myArr.add('0');
			}
			sign='-';
			addtion(lengthOne, lengthTwo,myArr,this,bigNumberTwo);
		}
		else if(this.getSign()=='-'&&bigNumberTwo.getSign()=='-'&&this.compareTo(bigNumberTwo)<0)
		{
			for(int i=0;i<lengthTwo+1;i++)
			{
				myArr.add('0');
			}
			sign='-';
			addtion(lengthTwo, lengthOne,myArr,bigNumberTwo,this);
		}
		return new BigInt(sign,myArr);
	}
	/**
	 * Precondition: None
	 * PostCondition: ArrayList<Character> myArr will be the result of subtracyion
	 * @Algorithm:
	 * Declare int carry,sibtract,indexB
	 * Declare char result,charOne,charTwo
	 * for(int indexA=lengthOne-1;indexA>=0;indexA--)
	 * charOne = bigInt.getArray().get(indexA)
	 * if(indexB>=0)
	 * charTwo= bigNumberTwo.getArray().get(indexB)
	 * subtract=(int)(charOne-'0')-(int)(charTwo-'0')-carry
	 * if(subtract<0)
	 * subtract=10+(int)(charOne-'0')-(int)(charTwo-'0')-carry
	 * result = (char)(subtract+'0')
	 * else
	 * result = (char)(subtract+'0')
	 * carry=0
	 * myArr.set(indexA, result)
	 * ndexB--
	 * else
	 * subtract=(int)(charOne-'0')-carry
	 * result = (char)(subtract+'0')
	 * carry=0
	 * myArr.set(indexA, result)
	 * @param lengthOne
	 * @param lengthTwo
	 * @param myArr
	 * @param bigInt
	 * @param bigNumberTwo
	 */

	

	private void substraction(int lengthOne, int lengthTwo, ArrayList<Character> myArr, BigInt bigInt, BigInt bigNumberTwo) {
		int carry=0;
		int subtract;
		char result=0;
		char charOne=0;
		char charTwo=0;
		int indexB=lengthTwo-1;
		for(int indexA=lengthOne-1;indexA>=0;indexA--)
		{
			
			charOne = bigInt.getArray().get(indexA);
			if(indexB>=0)
			{
				charTwo= bigNumberTwo.getArray().get(indexB);
				
				subtract=(int)(charOne-'0')-(int)(charTwo-'0')-carry;
				//System.out.println("subtract"+subtract);
				if(subtract<0)
				{
					subtract=10+(int)(charOne-'0')-(int)(charTwo-'0')-carry;
					 result = (char)(subtract+'0');
					// System.out.println(subtract);
					carry=1;
				}
				else
				{
					 result = (char)(subtract+'0');
					carry=0;
				}
				myArr.set(indexA, result);
				indexB--;
				
				
			
			}
			else
			{
				subtract=(int)(charOne-'0')-carry;
				
					 result = (char)(subtract+'0');
					carry=0;
				
				myArr.set(indexA, result);
				
			}
		}
		
	}
	/**
	 * @precondition: None
	 * @postcondition: ArrayList<Character> myArr will be the result of addition
	 * @algorithm:
	 * Declareint carry=0
	 * Declare int sum
	 * Declare char result=0
	 * Declare char charOne=0
	 * Declare char charTwo=0
	 * Declare int indexB=lengthTwo-1
	 * for(int indexA=lengthOne-1;indexA>=0;indexA--)
	 * charOne= bigInt.getArray().get(indexA)
	 * if(indexB>=0)
	 * charTwo = bigNumberTwo.getArray().get(indexB)
	 * sum=(int)(charOne-'0')+(int)(charTwo-'0')+carry
	 * if(sum>9) result = (char)(sum%10+'0') and carry=sum/10
	 * else result = (char)(sum+'0') carry=0
	 * myArr.set(indexA+1, result)
	 * indexB--
	 * else if(indexB<0)
	 * sum=(int)(charOne-'0')+carry
	 * if(sum>9) result = (char)(sum%10+'0') carry=sum/10
	 * else result = (char)(sum+'0') carry=0
	 * myArr.set(indexA+1, result)
	 * myArr.set(0, (char) (carry+'0'));
	 * @param lengthOne
	 * @param lengthTwo
	 * @param myArr
	 * @param bigInt
	 * @param bigNumberTwo
	 */

	private void addtion(int lengthOne, int lengthTwo, ArrayList<Character> myArr, BigInt bigInt, BigInt bigNumberTwo) {
		int carry=0;
		int sum;
		char result=0;
		char charOne=0;
		char charTwo=0;
		int indexB=lengthTwo-1;
		for(int indexA=lengthOne-1;indexA>=0;indexA--)
		{
			charOne= bigInt.getArray().get(indexA);
			if(indexB>=0)
			{
				
				
				charTwo = bigNumberTwo.getArray().get(indexB);
				sum=(int)(charOne-'0')+(int)(charTwo-'0')+carry;
				
				if(sum>9)
				{
					 result = (char)(sum%10+'0');
					carry=sum/10;;
				}
				else
				{
					 result = (char)(sum+'0');
					carry=0;
				}
				myArr.set(indexA+1, result);
				indexB--;
				
				
			
			}
			else
			{
				sum=(int)(charOne-'0')+carry;
				if(sum>9)
				{
					 result = (char)(sum%10+'0');
					carry=sum/10;;
				}
				else
				{
					 result = (char)(sum+'0');
					carry=0;
				}
				myArr.set(indexA+1, result);
				
			}
		}
		myArr.set(0, (char) (carry+'0'));
		
	}
	/**
	 * @Precondition: bigNumberOne and bigNumberTwo are valid
	 * @Postcondition: we can compare bigNumberOne and bignumbertwo by their values
	 * @Algorithm:
	 * int ans =0
	 * int count=0
	 * String numberOne=this.toString()
	 * String numberTwo=bigNumberTwo.toString()
	 * if(this.sign=='+'&&bigNumberTwo.sign=='-') numberTwo=numberTwo.substring(1)
	 * else if(this.sign=='-'&&bigNumberTwo.sign=='+') numberOne=numberOne.substring(1)
	 * int lengthOne=numberOne.length()
	 * int lengthTwo = numberTwo.length()
	 * if(lengthOne>lengthTwo) ans=1
	 * else if(lengthOne<lengthTwo) ans=-1
	 * else
	 * for(int index=0;index<lengthOne;index++)
	 * if((int)(numberOne.charAt(index)-'0')>(int)(numberTwo.charAt(index)-'0')) ans=1 and exit
	 * else if((int)(numberOne.charAt(index)-'0')<(int)(numberTwo.charAt(index)-'0')) ans=-1 and exit
	 * else count++
	 * if(count==lengthOne)
	 * ans=0;	
	 * @param bigNumberTwo
	 * @return: 0 if value of bignumberOne and bignumberTwo are equal
	 * 1 if bignumberone>bignumbertwo 
	 * 2 if bignumberone<bignumbertwo 
	 */

	public int compareTo(BigInt bigNumberTwo) {
		int ans =0;
		int count=0;
		String numberOne=this.toString();
		String numberTwo=bigNumberTwo.toString();
		
		if(this.sign=='+'&&bigNumberTwo.sign=='-')
		{
			numberTwo=numberTwo.substring(1);
		}
		else if(this.sign=='-'&&bigNumberTwo.sign=='+')
		{
			numberOne=numberOne.substring(1);
		}
		int lengthOne=numberOne.length();
		int lengthTwo = numberTwo.length();
			if(lengthOne>lengthTwo)
			{
				ans=1;
			}
			else if(lengthOne<lengthTwo)
			{
				ans=-1;
			}
			else
			{
				for(int index=0;index<lengthOne;index++)
				{
					if((int)(numberOne.charAt(index)-'0')>(int)(numberTwo.charAt(index)-'0'))
					{
						ans=1;
						break;
					}
					else if((int)(numberOne.charAt(index)-'0')<(int)(numberTwo.charAt(index)-'0'))
					{
						ans=-1;
						break;
					}
					else
					{
						count++;
					}
				}
			}
				if(count==lengthOne)
				{
					ans=0;
				}
		
			
		
		return ans;
	}
	/**
	 * @Precondition: BigInt bigNumberTwo and this are valid.
	 * @Postcondition: the result of bigNumberTwo subtracted by this
	 * @Algorithm
	 * Declare int lengthOne equals this.getArray().size()
	 * Declare int lengthOne equals bigNumberTwo.getArray().size()
	 * Declare char sign
	 * Declare ArrayList<Character> myArr
	 * if bigNumberTwo and this are positive and equal =>> myArr.add('0')
	 * if bigNumberTwo and this are positive and this>bigNumberTwo =>> size of myArr equals legnthOne
	 and the sign of subtraction will be positive. Call the method substraction(lengthOne, lengthTwo,
	 myArr,this,bigNumberTwo)
	 *if bigNumberTwo and this are positive and this<bigNumberTwo =>> size of myArr equals legnthTwo
	 and the sign of subtraction will be negative. Call the method substraction(lengthTwo, lengthOne,
	 myArr,bigNumberTwo,this)
	 *if bigNumberTwo  are positive while this is negative and this>=bigNumberTwo =>> size of myArr equals legnthOne+1
	 and the sign of subtraction will be positive. Call the method addition(lengthOne, lengthTwo,
	 myArr,this,bigNumberTwo)
	 *if bigNumberTwo  are positive while this is negative and this<bigNumberTwo =>> size of myArr equals legnthTwo+1
	 and the sign of subtraction will be positive. Call the method addition(lengthTwo, lengthOne,
	 myArr,bigNumberTwo,this)
	 *if bigNumberTwo  are negative while this is positive and this>bigNumberTwo =>> size of myArr equals legnthTwo+1
	 and the sign of subtraction will be positive. Call the method addition(lengthTwo, lengthOne,
	 myArr,bigNumberTwo,this)
	 *if bigNumberTwo  are positive while this is negative and this<bigNumberTwo =>> size of myArr equals legnthOne+1
	 and the sign of subtraction will be positive. Call the method addition(lengthOne, lengthTwo,
	 myArr,this,bigNumberTwo)
	 * @param bigNumberTwo
	 * @return: BigInt
	 */

	public BigInt subtract(BigInt bigNumberTwo) {
		
		int lengthOne=this.getArray().size();
		int lengthTwo=bigNumberTwo.getArray().size();
		//BigInt ans = null ;
		char sign =0;
		ArrayList<Character> myArr =new ArrayList<Character>();
		if(this.getSign()=='+'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)==0)
		{
			
			myArr.add('0');
			
			
			
		}
		else if(this.getSign()=='+'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)>0)
		{
			for(int i=0;i<lengthOne;i++)
			{
				myArr.add('0');
			}
			sign='+';
			substraction(lengthOne, lengthTwo,myArr,this,bigNumberTwo);
		}
		else if(this.getSign()=='+'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)<0)
		{
			for(int i=0;i<lengthTwo;i++)
			{
				myArr.add('0');
			}
			sign='-';
			substraction(lengthTwo, lengthOne,myArr,bigNumberTwo,this);
		}
		else if(this.getSign()=='-'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)>=0)
		{
			for(int i=0;i<lengthOne+1;i++)
			{
				myArr.add('0');
			}
			sign ='-';
			addtion(lengthOne, lengthTwo,myArr,this,bigNumberTwo);
		}
		else if(this.getSign()=='-'&&bigNumberTwo.getSign()=='+'&&this.compareTo(bigNumberTwo)<0)
		{
			for(int i=0;i<lengthTwo+1;i++)
			{
				myArr.add('0');
			}
			sign='-';
			addtion(lengthTwo, lengthOne,myArr,bigNumberTwo,this);
		}
		
		else if(this.getSign()=='+'&&bigNumberTwo.getSign()=='-'&&this.compareTo(bigNumberTwo)<0)
		{
			for(int i=0;i<lengthTwo+1;i++)
			{
				myArr.add('0');
			}
			sign='+';
			addtion(lengthTwo, lengthOne,myArr,bigNumberTwo,this);
		}
		else if(this.getSign()=='+'&&bigNumberTwo.getSign()=='-'&&this.compareTo(bigNumberTwo)>=0)
		{
			for(int i=0;i<lengthOne+1;i++)
			{
				myArr.add('0');
			}
			sign ='+';
			addtion(lengthOne, lengthTwo,myArr,this,bigNumberTwo);
		}
		return new BigInt(sign,myArr);
	}
	/**
	 * @Preconditon: bigNumberOne and bigNumberTwo must be valid
	 * @Postcondition: multiplication of two numbers
	 * @Algorithm:
	 * Declare char sign='+'
	 * Declare int lengthA=this.getArray().size()
	 * Declare int lengthB=bigNumberOne.getArray().size()
	 * Declare ArrayList<Character> arrayR=new ArrayList<Character>()
	 * Set the size of the result to lengthA + lenghtB
	 * Depending on the sign of the object, we will decide the sign of the result on if else condition
	 * Call the method bigR=multiplication(bigR,lengthA,lengthB,this,bigNumberOne)
	 * @param bigNumberOne
	 * @return: BigInt
	 */

	public BigInt multiply(BigInt bigNumberOne) {
		char sign='+';
		int lengthA=this.getArray().size();
		int lengthB=bigNumberOne.getArray().size();
		ArrayList<Character> arrayR=new ArrayList<Character>();
		for(int i=0;i<lengthA+lengthB;i++)
		{
			arrayR.add('0');
		}
		BigInt bigR = null;
		
		if(this.sign=='+'&&bigNumberOne.sign=='+'|| this.sign=='-'&&bigNumberOne.sign=='-')
		{
			
			bigR = new BigInt(sign,arrayR);
			bigR=multiplication(bigR,lengthA,lengthB,this,bigNumberOne);
			bigR.sign='+';
			
		}
		else if(this.sign=='-'&&bigNumberOne.sign=='+'|| this.sign=='+'&&bigNumberOne.sign=='-')
		{
			bigR = new BigInt(sign,arrayR);
			bigR=multiplication(bigR,lengthA,lengthB,this,bigNumberOne);
			bigR.sign='-';
			
		}
		

		
		
		return bigR;
	}
	/**
	 * @Precondition:None
	 * @PostCondition: multiplication of two numbers
	 * @Algorithm:
	 * int carry=0
	 * char sign='+'
	 * int value=0
	 * int indexA=0
	 * ArrayList<ArrayList<Character>> myArr =new ArrayList<ArrayList<Character>>()
	 * for(int indexB=lengthB-1;indexB>=0;indexB--)
	 * ArrayList<Character> arrayA=new ArrayList<Character>()
	 * for(indexA=lengthA-1;indexA>=0;indexA--)
	 * value=(int)(this.getArray().get(indexA)-'0')*(int)(bigNumberOne.getArray().get(indexB)-'0')+carry
	 * if(value>=10) arrayA.set(indexA+indexB+1, (char)(value%10+'0')) carry=value/10
	 * else arrayA.set(indexA+indexB+1, (char)(value+'0')) carry=0
	 * if(carry>0) arrayA.set(indexA+indexB+1, (char)(carry+'0')) carry=0
	 * myArr.add(arrayA)
	 * for(int index=0; index<myArr.size();index++)
	 * BigInt bigA = new BigInt(sign,myArr.get(index))
	 * bigR=bigR.add(bigA)
	 * @param bigR
	 * @param lengthA
	 * @param lengthB
	 * @param bigInt
	 * @param bigNumberOne
	 * @return: BigInt
	 */
	private BigInt multiplication(BigInt bigR, int lengthA, int lengthB, BigInt bigInt, BigInt bigNumberOne) {
        int carry=0;
		char sign='+';
		int value=0;
		
		
		int indexA=0;
		ArrayList<ArrayList<Character>> myArr =new ArrayList<ArrayList<Character>>();
		
		for(int indexB=lengthB-1;indexB>=0;indexB--)
		{
			ArrayList<Character> arrayA=new ArrayList<Character>();
			for(int i=0;i<lengthA+lengthB;i++)
			{
				arrayA.add('0');
			}
			for(indexA=lengthA-1;indexA>=0;indexA--)
			{
				value=(int)(this.getArray().get(indexA)-'0')*(int)(bigNumberOne.getArray().get(indexB)-'0')+carry;
				if(value>=10)
				{
					arrayA.set(indexA+indexB+1, (char)(value%10+'0'));
					carry=value/10;
				}
				else
				{
					arrayA.set(indexA+indexB+1, (char)(value+'0'));
					carry=0;
				}
			}
			if(carry>0)
			{
				arrayA.set(indexA+indexB+1, (char)(carry+'0'));
				carry=0;
			}
			myArr.add(arrayA);
			
		}
		for(int index=0; index<myArr.size();index++)
		{
			BigInt bigA = new BigInt(sign,myArr.get(index));
			bigR=bigR.add(bigA);
		}
		return bigR;
		
	}
	/**
	 * @Preconditon: bignumbertwo and bignumberone must be valid
	 * @postcondition: division of two input integer
	 * @Algorithm
	 * int lengthA=this.getArray().size()
	 * int lengthB=bigNumberTwo.getArray().size()
	 * char sign=0
	 * QuotientRemainder quotient=null
	 * BigInt bigR = null
	 * ArrayList<Character> arrayR = new ArrayList<Character>();
	 * Depending on the sign of two BigInts, we'll decide the sign of return BigInt in if-else condition
	 * call the method quotient=division(lengthA,lengthB,this,bigNumberTwo)
	 * @param bigNumberTwo
	 * @return: bigR
	 */


	public BigInt divide(BigInt bigNumberTwo) {
		int lengthA=this.getArray().size();
		int lengthB=bigNumberTwo.getArray().size();
		char sign=0;
		QuotientRemainder quotient=null;
		BigInt bigR = null;
		ArrayList<Character> arrayR = new ArrayList<Character>();
		if(this.sign=='+'&&bigNumberTwo.sign=='+'|| this.sign=='-'&&bigNumberTwo.sign=='-')
		{
			
			quotient=division(lengthA,lengthB,this,bigNumberTwo);
			arrayR=quotient.getQuotient();
			
			sign='+';
			bigR= new BigInt(sign,arrayR);
			
		}
		else if(this.sign=='-'&&bigNumberTwo.sign=='+'|| this.sign=='+'&&bigNumberTwo.sign=='-')
		{
			quotient=division(lengthA,lengthB,this,bigNumberTwo);
			arrayR=quotient.getQuotient();
			
			sign='-';
			bigR= new BigInt(sign,arrayR);
			
		}
		
		return bigR;
		
		
		
		
		
	}
	/**
	 * @Precondition: None
	 * @PostConditon: QuotientRemainder
	 * @Algorithm:
	 * ArrayList<Character> arrayR = new 	ArrayList<Character>()
	 * BigInt bigA = null
	 * BigInt bigB=null
	 * BigInt bigR = null
	 * BigInt bigCount=null
	 * int kIndex=0
	 * bigNumberOne.sign='+'
	 * bigNumberTwo.sign='+'
	 * ArrayList<Character> dividend = new 	ArrayList<Character>()
	 * if(lengthA<lengthB) arrayR.add('0') bigB=new BigInt('+',bigNumberOne.getArray())
	 * else 
	 * do
	 * ArrayList<Character> arrayCount = new 	ArrayList<Character>()
	 * int count =0
	 * dividend.add(bigNumberOne.getArray().get(kIndex))
	 * bigA=new BigInt('+',dividend)
	 * kIndex++
	 * if(bigA.compareTo(bigNumberTwo)>=0)
	 * bigR=bigA.clone()
	 * while(bigR.compareTo(bigNumberTwo)>=0)
	 * bigR=bigR.subtract(bigNumberTwo)
	 * count++
	 * 
	 * else count=0
	 * arrayCount.add((char)(count+'0'))
	 * bigCount = new BigInt('+',arrayCount)
	 * bigB= bigA.subtract(bigCount.multiply(bigNumberTwo))
	 * if(bigB.compareTo(bigA)!=0)
	 * dividend.clear()
	 * for(int i=0;i<bigB.getArray().size();i++)
	 * dividend.add(bigB.getArray().get(i))
	 * arrayR.add((char)(count+'0'))
	 * while(kIndex<lengthA)
	 * quotienRemainder = new QuotientRemainder(arrayR,bigB.getArray());
	 * @param lengthA
	 * @param lengthB
	 * @param bigNumberOne
	 * @param bigNumberTwo
	 * @return: quotientRemainder
	 */

	private QuotientRemainder division(int lengthA, int lengthB, BigInt bigNumberOne, BigInt bigNumberTwo) {
		ArrayList<Character> arrayR = new 	ArrayList<Character>();
		BigInt bigA = null;
		BigInt bigB=null;
		BigInt bigR = null;
		BigInt bigCount=null;
		int kIndex=0;
		//char sign ='+';
		bigNumberOne.sign='+';
		bigNumberTwo.sign='+';
		
		ArrayList<Character> dividend = new 	ArrayList<Character>();
		if(lengthA<lengthB)
		{
			arrayR.add('0');
			bigB=new BigInt('+',bigNumberOne.getArray());
		}
		else {
		do {
		ArrayList<Character> arrayCount = new 	ArrayList<Character>();
		int count =0;
		dividend.add(bigNumberOne.getArray().get(kIndex));
		bigA=new BigInt('+',dividend);
		kIndex++;
			
		
		{
		if(bigA.compareTo(bigNumberTwo)>=0)
		{
			bigR=bigA.clone();
			while(bigR.compareTo(bigNumberTwo)>=0)
			{
			bigR=bigR.subtract(bigNumberTwo);
			count++;
			}
		}
		else
		{
			count=0;
		}
		arrayCount.add((char)(count+'0'));
		
		bigCount = new BigInt('+',arrayCount);
		bigB= bigA.subtract(bigCount.multiply(bigNumberTwo));
		if(bigB.compareTo(bigA)!=0)
		{
		dividend.clear();
		for(int i=0;i<bigB.getArray().size();i++)
		{
			dividend.add(bigB.getArray().get(i));
		}
		
		
		}
		arrayR.add((char)(count+'0'));
		}
		}while(kIndex<lengthA);
		}
		quotienRemainder = new QuotientRemainder(arrayR,bigB.getArray());
		

		return quotienRemainder;
		
	}
	/**
	 * @Precondition: bigNumberone and bigNumberTwo must be valid
	 * @PostCondition: modulus of two big int
	 * @Algorithm:
	 * int lengthA=this.getArray().size()
	 * int lengthB=bigNumberTwo.getArray().size()
	 * char sign=0
	 * QuotientRemainder remainder=null
	 * BigInt bigR = null
	 * ArrayList<Character> arrayR = new ArrayList<Character>();
	 * Depending on the sign, we'll decide the sign of bigR on if-else condition
	 * Call the method remainder=division(lengthA,lengthB,this,bigNumberTwo)
	 * arrayR=remainder.getRemainder()		
	 * @param bigNumberTwo
	 * @return: BigR
	 */

	public BigInt modulus(BigInt bigNumberTwo) {
		int lengthA=this.getArray().size();
		int lengthB=bigNumberTwo.getArray().size();
		char sign=0;
		QuotientRemainder remainder=null;
		BigInt bigR = null;
		ArrayList<Character> arrayR = new ArrayList<Character>();
		
		
		if(this.sign=='+'&&bigNumberTwo.sign=='+'|| this.sign=='+'&&bigNumberTwo.sign=='-')
		{
		
			remainder=division(lengthA,lengthB,this,bigNumberTwo);
			arrayR=remainder.getRemainder();
			sign='+';
			bigR= new BigInt(sign,arrayR);
		}
		else if(this.sign=='-'&&bigNumberTwo.sign=='-'|| this.sign=='-'&&bigNumberTwo.sign=='+')
		{
			remainder=division(lengthA,lengthB,this,bigNumberTwo);
			arrayR=remainder.getRemainder();
			sign='-';
			bigR= new BigInt(sign,arrayR);
		}
			
		
		
		return bigR;
		
	}
	/**
	 * ArrayList<Character> myArr = new ArrayList<Character>()
	 * char sign=this.sign
	 * for(int index=0;index<this.getArray().size();index++)
	 * myArr.add(this.getArray().get(index))
	 * @return new BigInt(sign,myArr);
		 
	 */
	public BigInt clone()
	{
		ArrayList<Character> myArr = new ArrayList<Character>();
		char sign=this.sign;
		for(int index=0;index<this.getArray().size();index++)
		{
			myArr.add(this.getArray().get(index));
		}
		
		
		return new BigInt(sign,myArr);
		 
		
	}
	/**
	 * String myString=""
	 * int index=0
	 * int kIndex=0
	 * int count=0
	 * for(kIndex =0;kIndex<this.getArray().size();kIndex++)
	 * myString=myString.concat(String.valueOf(this.getArray().get(kIndex)))
	 * for(index=0;index<myString.length();index++)
	 * if(myString.charAt(index)=='0')
	 * count++
	 * else if(myString.charAt(index)!='0') break
	 * if(count==myString.length()) myString="0"
	 * else if(this.sign=='-') myString=String.valueOf(this.sign)+myString.substring(index)
	 * else myString=myString.substring(index)
	 * @return myString;
	 */
	public String toString()
	{
		String myString="";
		int index=0;
		int kIndex=0;
		int count=0;
	
		
		for(kIndex =0;kIndex<this.getArray().size();kIndex++)
		{
			myString=myString.concat(String.valueOf(this.getArray().get(kIndex)));
		}
		for(index=0;index<myString.length();index++)
		{
			if(myString.charAt(index)=='0')
			{
				count++;
			}
			else if(myString.charAt(index)!='0') break;
		}
		if(count==myString.length())
		{
			myString="0";
		}
		else
		{
		if(this.sign=='-')
		{
		myString=String.valueOf(this.sign)+myString.substring(index);
		}
		else
		{
			myString=myString.substring(index);
		}
		}
		
		return myString;
		
	}
	/**
	 * boolean valid =true
	 * if(this.compareTo(otherBigInt)==0&& this.sign=='+'&&otherBigInt.sign=='+'||this.sign=='-'&&otherBigInt.sign=='-')
	 * valid=true
	 * else valid=false
	 * @param otherBigInt
	 * @return
	 */
	public boolean equals(BigInt otherBigInt)
	{
		boolean valid =true;
		if(this.compareTo(otherBigInt)==0&& this.sign=='+'&&otherBigInt.sign=='+'||this.sign=='-'&&otherBigInt.sign=='-')
		{
			valid=true;
		}
		else
		{
			valid=false;
		}
		return valid;
		
	}

	

}
