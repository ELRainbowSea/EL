package util;

/**
 * 我自己写的工具类
 * @author balck_cats
 *
 */
public class Util {

	/**
	 * 将给定由整数和空格组成的字符串转换为整数数组
	 * 
	 * @param str
	 *            要转换的字符串
	 * @return 转换成的数组
	 */
	public static int[] toInts(String str) {
		int[] ints;
		int index = 0;
		int len = 0;
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				len++;
		}
		len++;
		ints = new int[len];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				ints[index] = temp;
				index++;
				temp = 0;
				continue;
			} else
				temp = temp * 10 + str.charAt(i) - '0';
			if (i == str.length() - 1)
				ints[index] = temp;
		}
		return ints;
	}

	/**
	 * 将整数数组转换成字符串，两个整数之间用空格隔开
	 * 
	 * @param ints
	 *            要转换的数组
	 * @return 转换成的字符串
	 */
	public static String toStr(int[] ints) {
		String str;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ints.length; i++) {
			sb.append(ints[i]);
			if (i < ints.length - 1)
				sb.append(' ');
		}
		str = new String(sb);
		return str;
	}

	/**
	 * 从给定的整数开始，将整数数组转换成字符串（开头为给定的整数后面的那个数），两个整数之间用空格隔开
	 * 
	 * @param ints
	 *            要转换的数组
	 * @param begin
	 *            开始的整数
	 * @return 转换成的字符串
	 */
	public static String toStr(int[] ints, int begin) {
		String str;
		StringBuffer sb = new StringBuffer();
		int flag = 0;
		for (int i = 0; i < ints.length; i++) {
			if (flag > 0) {
				sb.append(ints[i]);
				if (i < ints.length - 1)
					sb.append(' ');
			}
			if (ints[i] == begin)
				flag++;
		}

		str = new String(sb);
		return str;
	}

//	public static void main(String[] args) {
//		Util u = new Util();
//		int[] n = u.toInts("10 2 3 4 5 0 1 2 3 4 5 6 7 8 9 0 10 2");
//		for (int i = 0; i < n.length; i++) {
//			System.out.print(n[i] + " ");
//		}
//		System.out.println();
//		System.out.println(u.toStr(n));
//		System.out.println(u.toStr(n, 0));
//	}
	
}
