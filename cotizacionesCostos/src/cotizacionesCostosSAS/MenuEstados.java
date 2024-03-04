package cotizacionesCostosSAS;

import java.util.Scanner;

public class MenuEstados {

	@SuppressWarnings("resource")
	public void showMenuEstados() {
		Scanner teclado = new Scanner(System.in);
		
		int option = 0;
		String selection = "no";
		
		do {
			System.out.println("::BIENVENIDO AL MENU DE ESTADO DE SOLICITUD::");
			System.out.println("Elija una opción del menu");
			System.out.println("\n");
			System.out.println("1. Solicitudes de compra");
			System.out.println("2. Solicitudes de entrada");
			System.out.println("3. Solicitudes de salida");
			System.out.println("4. Ordenes contractual");
			System.out.println("5. Salir");
			option = teclado.nextInt();

			switch (option) {
			case 1: {
				System.out.println("¿Desea regresar al menu de estados? si/no");
				selection = teclado.next();
				break;
			}case 2: {
				System.out.println("¿Desea regresar al menu de estados? si/no");
				selection = teclado.next();
				break;
			}case 3: {
				System.out.println("¿Desea regresar al menu de estados? si/no");
				selection = teclado.next();
				break;
			}case 4: {
				System.out.println("¿Desea regresar al menu de estados? si/no");
				selection = teclado.next();
				break;
			}
			case 5: {
				if (option == 5) {
					selection = "no";
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Opción invalida: " + option);
			}
			
		} while (selection.equals("si"));


	}
}
