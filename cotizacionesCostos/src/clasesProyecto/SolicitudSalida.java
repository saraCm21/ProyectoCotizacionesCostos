package clasesProyecto;

import java.util.ArrayList;

public class SolicitudSalida extends Data {

	private String deadline;
	private ArrayList<Producto>productos;
	private int total;
	
	public SolicitudSalida(String responsible, String deadline, int total, ArrayList<Producto>productos) {
		super(responsible);
		this.deadline = deadline;
		this.productos = productos;
		this.total = total;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public ArrayList<Producto> getProduct() {
		return productos;
	}

	public void setProduct(ArrayList<Producto> product) {
		this.productos = product;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
 

	@Override
	public String toString() {
		return "NUEVA SOLICITUD DE SALIDA" + "\n" + "Id: " + id + "\n" + "Fecha: " + date + "\n" + "Responsable: " + responsible + "\n" + "Fecha de entrega: " + deadline + "\n" + "\n" + "LISTA DE PRODUCTOS" + "\n" + productos + "\n" + "TOTAL ENTREGA " + total;
	}

}
