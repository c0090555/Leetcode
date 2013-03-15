public class AddBinary {
	public String addBinary(String a, String b) {
		String l = a.length() > b.length() ? a : b;// long string
		String s = l == a ? b : a;// short string
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = l.length() - 1, j = s.length() - 1; j >= 0; i--, j--) {
			Character cl = l.charAt(i);
			Character cs = s.charAt(j);
			if (cl == cs && cl == '0') {
				sb.append(0 + carry);
				carry = 0;
			} else if (cl == cs && cl == '1') {
				sb.append(0 + carry);
				carry = 1;
			} else if (cl != cs && carry == 0) {
				sb.append(1);
			} else if (cl != cs && carry == 1) {
				sb.append(0);
				carry = 1;
			}
		}

		for (int i = l.length() - s.length() - 1; i >= 0; i--) {
			Character cl = l.charAt(i);
			if (cl == '0' && carry == 1) {
				sb.append(1);
				carry = 0;
			} else if (cl == '1' && carry == 1) {
				sb.append(0);
				carry = 1;
			} else {
				sb.append(cl);
			}
		}
		if(carry==1){
			sb.append(1);
		}
		return sb.reverse().toString();
	}

	
	public static void main(String[] args){
		String c = "111";
		String d = "10";
		AddBinary o = new AddBinary();
		String result = o.addBinary(c, d);
		System.out.println("result "+result);
		
				
	}
}
