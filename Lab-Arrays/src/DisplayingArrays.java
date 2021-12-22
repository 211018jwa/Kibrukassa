
public class DisplayingArrays {

	public static void main(String[] args) {
		 int[] intArray = new int[3];
		    intArray[0] = -5123;
		    intArray[2] = 32;
		    System.out.println(intArray[0]);
		    System.out.println(intArray[2]);
		    System.out.println(intArray[1]);//it is not assigned so it print 0
		    System.out.println(intArray[3]);// Index 3 out of bounds for length 3
			                                 //at DisplayingArrays.main(DisplayingArrays.java:11)

	}

}
