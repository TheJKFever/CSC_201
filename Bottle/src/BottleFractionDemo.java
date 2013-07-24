//********************************************************************
//  BottleFractionDemo.java
//  Driver to exercise the use of multiple Rational objects.
//********************************************************************
public class BottleFractionDemo
{
//-----------------------------------------------------------------
//  Creates some BottleFraction objects and performs various operations on them.
//----------------------------------------------------------------
	
public static void main (String[] args)
{

// you must create an array with 
// fractions in it.
	BottleFraction[] fractionArray = new BottleFraction[(int)((Math.random()*5)+1)];
	BottleFraction[] fractionArray2 = new BottleFraction[(int)((Math.random()*5)+1)];
	BottleFraction[] fractionArray3 = new BottleFraction[(int)((Math.random()*5)+1)];
	
	readBottleFractionArray(fractionArray);
	System.out.println("fractionArray = "+printArray(fractionArray));
	System.out.println();
	      
	readBottleFractionArray(fractionArray2);
	System.out.println("fractionArray2 = "+printArray(fractionArray2));
	System.out.println();
	      
	readBottleFractionArray(fractionArray3);
	System.out.println("fractionArray3 = "+printArray(fractionArray3));
	System.out.println();  
    
	//Find largest array
	System.out.println("Out of the three arrays that you just created, the one with the longest amount of indexes \n" +
			"is the following: "+printArray(helper(fractionArray, fractionArray2, fractionArray3))+" with a total of "+helper(fractionArray, fractionArray2, fractionArray3).length+" indexes.");
	//Create puesdo array
	System.out.println();
	System.out.println("An array with the largest of the three fractions in each index is:\n" +
			""+printArray(largestBottleFractions(fractionArray, fractionArray2, fractionArray3)));	
   }
      
//The next two methods must be written by you.  They are static methods of the
//BottleFractionTester class.	
	public static void readBottleFractionArray(BottleFraction[] array)
      {	System.out.println();
		System.out.println("I have created an array with a random number of indexes");
		System.out.println("this array happens to have "+array.length+" indexes");
      	for (int i=0;i<array.length;i++)
      		{	System.out.println("Enter the Bottle and Fraction information for index "+(i+1));
      			array[i] = new BottleFraction();
    			array[i].read();
    		}
       }
      
//      public static BottleFraction getAverage(BottleFraction[] array)
//      {  // this is a static method written by you.
//    	  BottleFraction sum = new BottleFraction();
//    	  BottleFraction ave = new BottleFraction();
//    	  for (int i=0;i<array.length;i++)
//    	  {	sum=sum.add(array[i]);
//    	  }
//    	  ave = sum.divide(array.length);
//    	  return ave;
//      }
      
      public static String printArray(BottleFraction[] array){
    	  String output;
    	  output = "(";
    	  if (array.length!=1){
	    	  for (int i=0; i<(array.length-1);i++)
	    		  output=output+""+array[i]+", ";
    	  }
    	  output=output+array[array.length-1]+")";
    	  return output;
      }
      
      public static BottleFraction[] largestBottleFractions(BottleFraction[] a, BottleFraction[] b, BottleFraction[] c){
    	  BottleFraction[][] abc = {a,b,c};
    	  BottleFraction[] largest = new BottleFraction[helper(a, b, c).length];
    	  BottleFraction temp = new BottleFraction();
    	  //insert largest BottleFraction in each index of largest
    	  for (int i=0;i<largest.length;i++){
			  //insert each element in index of temp
    		  for (BottleFraction[] t: abc){
				  if (t.length>=i+1)
					  if(t[i].greaterThan(temp))
						  temp=t[i];
    		  }
    		  largest[i]=temp;
    		  temp = new BottleFraction();
    	  }
    	  return largest;
      }
      
      public static BottleFraction[] helper(BottleFraction[] a, BottleFraction[] b, BottleFraction[] c){
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