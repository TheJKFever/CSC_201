/**@author Jon Koehmstedt
 * Jan 25, 2013
 * Class Projects/Randomtest.java
 */

public class Randomtest {

	public static void main(String[] args) {
		// 
		int a;
		do{
		a = (int)((Math.random()*5)+1);
		System.out.println(a);
		} while (a!=4);

	}

}
