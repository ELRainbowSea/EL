package util;

/**
 * ���Լ�д�Ĺ�����
 * @author balck_cats
 *
 */
public class Util {

	/**
	 * �������������Ϳո���ɵ��ַ���ת��Ϊ��������
	 * 
	 * @param str
	 *            Ҫת�����ַ���
	 * @return ת���ɵ�����
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
	 * ����������ת�����ַ�������������֮���ÿո����
	 * 
	 * @param ints
	 *            Ҫת��������
	 * @return ת���ɵ��ַ���
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
	 * �Ӹ�����������ʼ������������ת�����ַ�������ͷΪ����������������Ǹ���������������֮���ÿո����
	 * 
	 * @param ints
	 *            Ҫת��������
	 * @param begin
	 *            ��ʼ������
	 * @return ת���ɵ��ַ���
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
