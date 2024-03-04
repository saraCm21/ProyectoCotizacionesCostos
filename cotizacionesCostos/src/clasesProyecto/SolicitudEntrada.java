package clasesProyecto;

import java.util.ArrayList;

public class SolicitudEntrada extends Data{
	
    private int totalBienes;
    private float totalValue;
    private ArrayList<Producto> producto;

	public SolicitudEntrada(String responsible, int totalBienes, float totalValue2, ArrayList<Producto>producto) {
		super(responsible);
		this.totalBienes = totalBienes;
		this.totalValue = totalValue2;
		this.setProducto(producto);
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public int getTotalBienes() {
		return totalBienes;
	}

	public void setTotalBienes(int totalBienes) {
		this.totalBienes = totalBienes;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}


	public ArrayList<Producto> getProducto() {
		return producto;
	}

	public void setProducto(ArrayList<Producto> producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Nª de solicitud: " + id + "\n" + "Responsable: " + responsible + "\n" + "Total de bienes: " + totalBienes + "\n" + "Total de la orden: " + totalValue + "\n" + "\n" + "PRODUCTOS" + "\n" + producto;
	}

}
