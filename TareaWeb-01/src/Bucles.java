
public class Bucles {

	public void P10fibonacci() {
		int a = 0;
		int b = 1;
		int temp = 0;
		for (int i = 0; i < 10; i++) {

			System.out.print(a + " ");
			temp = b;
			b = b + a;
			a = temp;
		}

	}
}
