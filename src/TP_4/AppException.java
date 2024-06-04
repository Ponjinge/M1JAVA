package TP_4;

public class AppException {
	//Let's turn the computation of a mean into a function
	public static double computeMean(String[] tab){
		double somme = 0;
		int validElements = 0;
		//double mean = 999.999;
		for (String s : tab) {
			try{
				somme += Integer.parseInt(s);
				validElements++;
			}catch (NumberFormatException ignored){
			}
		}
		//try {
			return  somme / validElements;
		//} finally {
		//	if (mean = 999.999){
		//		System.out.println("Pas calculable ");
		//	}
		//}


	}

	public static void main(String[] args) {

		String[] tab = { "9", "6", "1", "4" };
		String[] tab2 = { "9", "e", "r", "4" };
		String[] tab3 = { "z", "e", "r", "o" };

		System.out.println(computeMean(tab));
		System.out.println(computeMean(tab2));

		// I can't throw the exception for division by 0 using this function,
		// It returns NaN instead
		System.out.println(computeMean(tab3));


		// BONUS :

		// Here's code snippets directly in main.
		try {
			int testThrow =  2/0;
		}catch (ArithmeticException e ){
			System.out.println("Custom Error: "+ e + " , none of the elements of this list are computable");
			int testThrow = 0;
		}

		// V2 where we predefine testThrow
		double testThrow = 0;
		try {
			testThrow =  2/0;
		}catch (ArithmeticException e ){
			System.out.println("Custom Error: "+ e + " , none of the elements of this list are computable");
			testThrow = 0;
		}


	}

}
