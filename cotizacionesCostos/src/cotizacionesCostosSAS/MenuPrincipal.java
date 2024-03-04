package cotizacionesCostosSAS;


import java.util.Scanner;


public class MenuPrincipal {
	
	private MenuSolicitudes menuSolicitudes;
	private MenuInventario menuInventario;
	private MenuEstados menuEstados;
		
	
	public MenuPrincipal() {
		this.menuSolicitudes = new MenuSolicitudes();
		this.menuInventario = new MenuInventario();
		this.menuEstados = new MenuEstados();
	}
	
	
	public static void main(String[] args) {
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.showMenuPrincipal();
	}

	@SuppressWarnings("resource")
	public void showMenuPrincipal() {
		Scanner teclado = new Scanner(System.in);
		int option;
		String selection = "si";
	
		do {
			System.out.println(":: MENU PRINCIPAL::");
			System.out.println("1. Generar solicitudes");
			System.out.println("2. Iventario de solicitudes");
			System.out.println("3. Estado de solicitud");
			System.out.println("4. Salir");
			option = teclado.nextInt();
			
			switch (option) {
			case 1: {
				menuSolicitudes.showMenuSolicitudes();
				break;
			}
			case 2: {
				menuInventario.showMenuInventario();
				break;
			}
			case 3: {
				menuEstados.showMenuEstados();
				break;
			}
			case 4: {
				selection = "no";
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: ");
			}
		} while (selection.equalsIgnoreCase("si"));
			
	}

}






