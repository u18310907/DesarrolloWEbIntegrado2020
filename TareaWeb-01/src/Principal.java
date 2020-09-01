import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Numeor Mayor Condicional");
		Scanner consola= new  Scanner(System.in);
		System.out.println("Ingrese un numero ");
		int x = consola.nextInt();
		System.out.println("Ingrese un numero ");
		int y = consola.nextInt();
		Condicional obj1=new Condicional();
		obj1.Nmayor(x, y);
		System.out.println("\n");
		
		System.out.println("Fibonaci Bucles");
		Bucles obj2=new Bucles();
		obj2.P10fibonacci();
		System.out.println("\n");
		
		System.out.println("Herencia");
		HerenciaPerro obj3=new HerenciaPerro("Mamifero",4,2,true,true,"Schnauzer",5,true,"Perro");
		obj3.mostrar_info();

		
	}

}
