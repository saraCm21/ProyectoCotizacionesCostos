package cotizacionesCostosSAS;

import java.util.ArrayList;
import java.util.Scanner;

import clasesProyecto.ProductoInventario;

public class MenuInventario {
	
	@SuppressWarnings("resource")
	public void showMenuInventario() {
		Scanner teclado = new Scanner(System.in);
		
		int option = 0;
		String selection = "no";
		
		do {
			System.out.println("::BIENVENIDO AL MENU DE INVENTARIO::");
			System.out.println("Elija una opción del menu");
			System.out.println("\n");
			System.out.println("1. Inventario de Solicitudes"); // menu funcional despues de la creacion de la base de datos
			System.out.println("2. Agregar un producto al inventario");
			System.out.println("3. salir");
			option = teclado.nextInt();

			switch (option) {
			case 1: {
				showInventarioSolicitudes();
				System.out.println("¿Desea regersar al menu de invetario? si/no");
				selection = teclado.next();
				break;
			}case 2: {
				inventario();
				System.out.println("¿Desea regersar al menu de invetario? si/no");
				selection = teclado.next();
				break;
			}case 3: {
				if (option == 3) {
					selection = "no";
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Opción invalida: " + option);
			}
			
		} while (selection.equals("si"));

	}
	
	@SuppressWarnings("resource")
	public static void inventario() {
		
		Scanner teclado = new Scanner(System.in);
		ArrayList<ProductoInventario> listaInventario = new ArrayList<>();
		String name;
		int quantity;
		String responsible;
		String location;
		String selection = "si";
		String option = "si";
		String deadline;
		
		
			do {
				System.out.println("\n" );
				System.out.println(":: Nuevo producto ::");
				System.out.println("\n" );
				System.out.println("Ingrese el nombre del producto");
				name = teclado.next();
				System.out.println("Ingrese la cantidad");
				quantity = teclado.nextInt();
				System.out.println("Ingrese el nombre del responsable");
				responsible = teclado.next();
				System.out.println("Ingrese la locacion");
				location = teclado.next();
				System.out.println("Ingrese la fecha de entrega en formato DD-MM-AAAA");
				deadline = teclado.next();
				String id = ProductoInventario.getGenerarId();
				
				ProductoInventario newInventario = new ProductoInventario(name, quantity, id, deadline, responsible, location);
				listaInventario.add(newInventario);
				
				System.out.println("¿Desea agregar un nuevo producto? si/no");
				selection = teclado.next();
				
			} while (selection.equalsIgnoreCase("si"));
			
			System.out.println("¿Desea ver el inventario? si/no ");
			option = teclado.next();
			
			if (option.equalsIgnoreCase("si")) {
				System.out.println("INVENTARIO");
				System.out.println("\n");
				System.out.println(listaInventario);
			}
	}
	
	@SuppressWarnings("resource")
	public static void showInventarioSolicitudes() {
	Scanner teclado = new Scanner(System.in);
		
		int option = 0;
		String selection = "no";
		
		do {
			System.out.println("::BIENVENIDO AL MENU DE INVENTEARIO DE SOLICITUDES:");
			System.out.println("Elija una opción del menu");
			System.out.println("\n");
			System.out.println("1. Solicitudes de compra");
			System.out.println("2. Solicitudes de entrada");
			System.out.println("3. Sollicitudes de salida");
			System.out.println("4. Ordenes contractual");
			System.out.println("5. salir");
			option = teclado.nextInt();

			switch (option) {
			case 1: {
				System.out.println("¿Desea regersar al menu? si/no");
				selection = teclado.next();
				break;
			}case 2: {
				System.out.println("¿Desea regersar al menu? si/no");
				selection = teclado.next();
				break;
			}case 3: {
				System.out.println("¿Desea regersar al menu? si/no");
				selection = teclado.next();
				break;
			}
			case 4: {
				System.out.println("¿Desea regersar al menu? si/no");
				selection = teclado.next();
				break;
			}case 5: {
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
