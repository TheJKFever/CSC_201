//********************************************************************
//  FractionDemo.java
//  Driver to exercise the use of multiple Rational objects.
//********************************************************************
public class FractionDemo
{
//-----------------------------------------------------------------
//  Creates some fraction objects and performs various operations on them.
//----------------------------------------------------------------
	
public static void main (String[] args)
{
	Fraction f1 = new Fraction (1, 2);
	Fraction f2 = new Fraction (2, 3);
	Fraction f3, f4, f5, f6, f7;
	
    System.out.println ("First rational number: " + f1);
    System.out.println ("Second rational number: " + f2);
    if (f1.equals(f2))
    	System.out.println ("f1 and f2 are equal.");
    else
    	System.out.println ("f1 and f2 are NOT equal.");
    f3 = f2.reciprocal();
	f4 = f1.add(f2);
	f5 = f1.subtract(f2);
	f6 = f1.multiply(f2);
	f7 = f1.divide(f2);
	System.out.println ("The reciprocal of f2 is: " + f3);
	System.out.println ("f1 + f2: " + f4);
    System.out.println ("f1 - f2: " + f5);
    System.out.println ("f1 * f2: " + f6);
    System.out.println ("f1 / f2: " + f7);

// you must create an array with 
// fractions in it.
	Fraction[] fractionArray = new Fraction[(int)((Math.random()*5)+1)];
	Fraction[] fractionArray2 = new Fraction[(int)((Math.random()*5)+1)];
	Fraction[] fractionArray3 = new Fraction[(int)((Math.random()*5)+1)];
	
	readFractionArray(fractionArray);
	f7 = getAverage(fractionArray);
	System.out.println("the average of the fractionArray of Fractions is  "+f7);
	System.out.println("fractionArray = "+printArray(fractionArray));
	System.out.println();
	      
	readFractionArray(fractionArray2);
	f7 = getAverage(fractionArray2);
	System.out.println("the average of the fractionArray of fractionArray2 is  " + f7 );
	System.out.println("fractionArray2 = "+printArray(fractionArray2));
	System.out.println();
	      
	readFractionArray(fractionArray3);
	f7 = getAverage(fractionArray3);
	System.out.println("the average of the fractionArray of fractionArray3 is  " + f7 );
	System.out.println("fractionArray3 = "+printArray(fractionArray3));
	System.out.println();  
    
	//Find largest array
	System.out.println("Out of the three arrays that you just created, the one with the longest amount of indexes \n" +
			"is the following: "+printArray(helper(fractionArray, fractionArray2, fractionArray3))+" with a total of "+helper(fractionArray, fractionArray2, fractionArray3).length+" indexes.");
	//Create puesdo array
	System.out.println();
	System.out.println("If you were to create a Fraction array with the same number of indexes and place the largest \n" +
			"of the "+helper(fractionArray, fractionArray2, fractionArray3).length+"fractions in each index, it would look like this: "+printArray(largestFractions(fractionArray, fractionArray2, fractionArray3)));
	
	
   }
      
//The next two methods must be written by you.  They are static methods of the
//FractionTester class.	
	public static void readFractionArray(Fraction[] array)
      {	System.out.println();
		System.out.println("I have created an array with a random number of indexes");
		System.out.println("this array happens to have "+array.length+" indexes");
      	for (int i=0;i<array.length;i++)
      		{	System.out.println("Enter the fraction for index "+(i+1));
    			array[i] = new Fraction();
    			array[i].read();
    		}
       }
      
      public static Fraction getAverage(Fraction[] array)
      {  // this is a static method written by you.
    	  Fraction sum = new Fraction();
    	  Fraction ave = new Fraction();
    	  for (int i=0;i<array.length;i++)
    	  {	sum=sum.add(array[i]);
    	  }
    	  ave = sum.divide(array.length);
    	  return ave;
      }
      
      public static String printArray(Fraction[] array){
    	  String output;
    	  output = "(";
    	  if (array.length!=1){
	    	  for (int i=0; i<(array.length-1);i++)
	    		  output=output+""+array[i]+", ";
    	  }
    	  output=output+array[array.length-1]+")";
    	  return output;
      }
      
      public static Fraction[] largestFractions(Fraction[] a, Fraction[] b, Fraction[] c){
    	  Fraction[] largest = helper(a, b, c);
    	  Fraction temp = new Fraction();
    	  if (a.length==largest.length){
        	  for (int i=0;i<a.length;i++){
        		  if (a[i].greaterThan(temp))
        			  temp=a[i];
        	  }
    	  }
    	  else if (b.length==largest.length){
        	  for (int i=0;i<b.length;i++){
        		  if (b[i].greaterThan(temp))
        			  temp=b[i];
        	  }
    	  }
    	  else {
        	  for (int i=0;i<c.length;i++){
        		  if (c[i].greaterThan(temp))
        			  temp=c[i];
        	  }
    	  }
    	  for (int i=0;i<largest.length;i++)
    		  largest[i]=temp;
    	  return largest;
      }
      
      public static Fraction[] helper(Fraction[] a, Fraction[] b, Fraction[] c){
    	  if (a.length>b.length){
    		  if (a.length>c.length)
    			  return a;
    		  else
    			  return c;}
    	  else if (b.length>c.length)
    		  return b;
    	  else
    		  return c;
      }
      
}