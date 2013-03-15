
public class PlusOne {
	public int[] plusOne(int[] digits) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int carry = 1;
		int temp;
		boolean needMoreDigit = true;
		for (int i = digits.length - 1; i >= 0; i--) {
			temp = (digits[i] + carry) % 10;
			// System.out.println("i "+i+"temp "+temp);
			carry = (digits[i] + carry) / 10;
			digits[i] = temp;
			if (carry == 0) {
				needMoreDigit = false;
				break;
			}
		}
		// System.out.println("nn"+needMoreDigit);
		if (!needMoreDigit) {
			return digits;
		} else {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = carry;
			for (int i = 1; i <= digits.length; i++) {
				newDigits[i] = digits[i - 1];
			}
			return newDigits;
		}

	}
	public static void main(String[] args){
		PlusOne o = new PlusOne();
		int[]digits = {9,8,7,6,5,4,3,2,1,0};
		int[] result = o.plusOne(digits);
		for(int i=0;i<result.length;i++){
			System.out.print(" "+result[i]);
		}
	}

}
