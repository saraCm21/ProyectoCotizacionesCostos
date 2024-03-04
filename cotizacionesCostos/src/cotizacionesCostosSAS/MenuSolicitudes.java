package cotizacionesCostosSAS;

import java.util.ArrayList;
import java.util.Scanner;
import clasesProyecto.Aprobacion;
import clasesProyecto.Items;
import clasesProyecto.OrdenContractual;
import clasesProyecto.Producto;
import clasesProyecto.ProductoInventario;
import clasesProyecto.SolicitudCompra;
import clasesProyecto.SolicitudEntrada;
import clasesProyecto.SolicitudSalida;

public class MenuSolicitudes {

	@SuppressWarnings("resource")
	public void showMenuSolicitudes() {
		Scanner teclado = new Scanner(System.in);
		
			int option = 0;
			String selection = "si";
			do {
				System.out.println("::BIENVENIDO AL MENU DE SOLICITUDES::");
				System.out.println("Elija una opción del menu");
				System.out.println("\n");
				System.out.println("1. Nueva Solicitud de Compra");
				System.out.println("2. Nueva Orden Contractual");
				System.out.println("3. Nueva Solicitud de Entrada");
				System.out.println("4. Nueva Solicitud de Salida");
				System.out.println("5. salir");
				option = teclado.nextInt();
				
				switch (option) {
				case 1: {
					showNewSC();
					System.out.println("¿Desea regersar al menu? si/no");
					selection = teclado.next();
					break;
				}
				case 2: {
					showOrder();
					System.out.println("¿Desea regersar al menu? si/no");
					selection = teclado.next();
					break;
				}
				case 3: {
					showNewSE();
					System.out.println("¿Desea regersar al menu? si/no");
					selection = teclado.next();
					break;
				}
				case 4: {
					showNewSS();
					System.out.println("¿Desea regersar al menu? si/no");
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

	@SuppressWarnings("resource")
	public static void showNewSC() {
		
		Scanner sc = new Scanner(System.in);
		String selection = "si";
		
		do {
			String responsible;
			int identificationCard;
			String costCenter;
			int budget;
			ArrayList<Items> items;
			float total = 0;
			
			System.out.println("\n" );
			System.out.println(":: Nueva solicitud de compra ::");
			System.out.println("\n" );
			System.out.println("Ingrese el nombre del responsable de la solicitud");
			responsible = sc.nextLine();
			System.out.println("Ingrese el Nº de la cedula de ciudadania");
			identificationCard = sc.nextInt();
			System.out.println("Ingrese el centro de costos");
			costCenter = sc.next();
			System.out.println("Ingrese el rubro presupuestal");
			budget = sc.nextInt();

			items = newItem();
			
			for(Items nuevoItem : items) {
				total = nuevoItem.getTotalValue() + total;
			}
			
			SolicitudCompra solicitud1 = new SolicitudCompra(responsible, identificationCard, costCenter, budget, items, total);
			Aprobacion aprobacionCompra = new Aprobacion(solicitud1.getId());
			System.out.println(aprobacionCompra);
			System.out.println(solicitud1);;
			System.out.println("\n");
			System.out.println("¿Desea generar una nueva solicidud de compra? si/no");
			selection = sc.next();
			
		} while (selection.equals("si"));
		
				
	}

	@SuppressWarnings("resource")
	public static ArrayList<Items> newItem() {
		
		Scanner teclado = new Scanner(System.in);
		String selection;
		int contador = 0;
		ArrayList<Items> ListaProductos = new ArrayList<>();
		
		do {
			
			String name;
			int quantity;
			String unitM;
			float value;
			
			System.out.println("\n" );
			System.out.println("::Generar nuevo item::");
			System.out.println("\n" );
			System.out.println("Ingrese el nombre del producto");
			name = teclado.nextLine();
			System.out.println("Ingrese la cantida de producto");
			quantity = teclado.nextInt();
			System.out.println("Ingrese la unidad de medida del producto");
			unitM = teclado.next();
			System.out.println("Ingrese el valor unitario del producto");
			value = teclado.nextInt();
			
			Items nuevoItem = new Items(name, quantity, unitM, value);
			ListaProductos.add(nuevoItem);
			
			System.out.println(ListaProductos.get(contador));
			System.out.println("\n" );
			System.out.println("Agregar nuevo item si/no");
			selection = teclado.next();
			contador++;
			
		} while (selection.equalsIgnoreCase("si"));
		
		
		return ListaProductos;
	}
	
	public static void showOrder() {
		
		ArrayList<OrdenContractual> order = new ArrayList<>();
		
		System.out.println(":: Generar nueva orden contractual ::");
		order = createOrder();
		System.out.println(order);
		
	}

	@SuppressWarnings("resource")
	public static ArrayList<OrdenContractual> createOrder() {
		
		Scanner teclado = new Scanner(System.in);
		String selection;
		int contador = 0;
		ArrayList<OrdenContractual> ListaOrders = new ArrayList<>();
		ArrayList<Items> items;
		
		do {
			
			int nit;
			String provider;
			int total;
			String deadline;
			
			System.out.println("\n" );
			System.out.println("::Generar nueva Orden::");
			System.out.println("\n" );
			System.out.println("Ingrese el nit de la empresa");
			nit = teclado.nextInt();
			System.out.println("Ingrese el nombre del proveedor");
			provider = teclado.next();
			System.out.println("Ingrese el valor total de la orden");
			total = teclado.nextInt();
			System.out.println("Ingrese la fecha de entrega en formato yyyy-mm-dd");
			deadline = teclado.next();
			
			items = newItem();
	
			
			OrdenContractual nuevaOrden = new OrdenContractual(nit, provider,deadline, total, items);
			ListaOrders.add(nuevaOrden);
			
			System.out.println(ListaOrders.get(contador));
			System.out.println("\n" );
			System.out.println("Agregar nueva orden si/no");
			selection = teclado.next();
			contador++;
			
		} while (selection.equalsIgnoreCase("si"));
		
		return ListaOrders;
	}

	@SuppressWarnings("resource")
	public static void showNewSE() {
		Scanner teclado = new Scanner(System.in);
		String responsible;
		int totalBienes;
		float totalValue;
		ArrayList<Producto>product;
		
		System.out.println("\n" );
		System.out.println(":: Nueva solicitud de entrada ::");
		System.out.println("\n" );
		System.out.println("Ingrese el responsable de la solicitud");
		responsible = teclado.next();
		System.out.println("Ingrese el total de bienes");
		totalBienes = teclado.nextInt();
		System.out.println("Ingrese el valor total de la entrega");
		totalValue = teclado.nextFloat();
		
		product = newProduct();
		
		SolicitudEntrada entrada = new SolicitudEntrada(responsible, totalBienes, totalValue, product);
		System.out.println("\n");
		System.out.println(entrada);
		System.out.println("\n");
		
	}
	
	@SuppressWarnings("resource")
	public static ArrayList<Producto> newProduct() {
		Scanner teclado = new Scanner(System.in);
		ArrayList<Producto> listaProductos = new ArrayList<>();
		ArrayList<ProductoInventario> listaInventario = new ArrayList<>();
		String name;
		int quantity;
		String responsible;
		String location;
		String deadline;
		String selection = "si";
		String option = "Si";
		
		
		System.out.println("¿Desea agregar los productos al inventario? si/no");
		option = teclado.next();
		
		if (option.equalsIgnoreCase("Si")) {
			
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
				System.out.println("Ingrese la la fecha de entrega en formato DD-MM-AAAA");
				deadline = teclado.next();
				String id = Producto.getGenerarId();
				
				Producto newProducto = new Producto(name, quantity, id);
				listaProductos.add(newProducto);
				
				ProductoInventario newInventario = new ProductoInventario(name, quantity, id, deadline, responsible, location);
				listaInventario.add(newInventario);
				
				System.out.println("¿Desea agregar un nuevo producto? si/no");
				selection = teclado.next();
				
			} while (selection.equalsIgnoreCase("si"));
			
		}else {
			
			do {
				System.out.println("\n" );
				System.out.println(":: Nuevo producto ::");
				System.out.println("\n" );
				System.out.println("Ingrese el nombre del producto");
				name = teclado.next();
				System.out.println("Ingrese la cantidad");
				quantity = teclado.nextInt();
				String id = Producto.getGenerarId();
				
				Producto newProducto = new Producto(name, quantity, id);
				listaProductos.add(newProducto);
				
				System.out.println("¿Desea agregar un nuevo producto? si/no");
				selection = teclado.next();
				
			} while (selection.equalsIgnoreCase("si"));
			
		}
		
		return listaProductos;
	}
	
	@SuppressWarnings("resource")
	public static void showNewSS() {

		
		Scanner teclado = new Scanner(System.in);
		
		String responsible;
		ArrayList<Producto> productos;
		String selection = "si";
		String deadline;
		int total;

		
		do {
			System.out.println(":: NUEVA SOLICITUD DE SALIDA ::");
			System.out.println("\n");
			System.out.println("Ingrese el nombre del respondable del producto");
			responsible = teclado.next();
			System.out.println("Ingrese la fecha de entrega en formato yyyy-mm-dd");
			deadline = teclado.next();
			System.out.println("Ingrese el total de la entrega");
			total = teclado.nextInt();
			productos = newProductSalida();
			
			SolicitudSalida salicitud3 = new SolicitudSalida(responsible, deadline, total, productos);
			
			System.out.println(salicitud3);
			System.out.println("\n");

			System.out.println("¿Desea  agregar una nueva solicitud de salida? si/no ");
			selection = teclado.next();
			
		} while (selection.equalsIgnoreCase("si"));
		
		
	}

	@SuppressWarnings("resource")
	public static ArrayList<Producto> newProductSalida() {
		Scanner teclado = new Scanner(System.in);
		
		ArrayList<Producto> listaProductos = new ArrayList<>();
		String name;
		int quantity;
		String selection = "si";
		String id = Producto.getGenerarId();
		
			do {
				System.out.println("\n" );
				System.out.println(":: Nuevo producto ::");
				System.out.println("\n" );
				System.out.println("Ingrese el nombre del producto");
				name = teclado.next();
				System.out.println("Ingrese la cantidad");
				quantity = teclado.nextInt();
				
				Producto p = new Producto(name, quantity, id);
				listaProductos.add(p);
				
				System.out.println("¿Desea agregar un nuevo producto? si/no");
				selection = teclado.next();
				
			} while (selection.equalsIgnoreCase("si"));
		return listaProductos;
	}

}
