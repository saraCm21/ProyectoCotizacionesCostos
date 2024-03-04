package clasesProyecto;

import java.util.ArrayList;

public class SolicitudCompra extends Data {

	
	 private int identificationCard;
	 private String costCenter;
	 private int budget;
	 private ArrayList<Items>items;
	 private float total;
	 
	
	public SolicitudCompra(String responsible, int identificationCard, String costCenter, int budget,
			ArrayList<Items> items, float total) {
		super(responsible);
		this.identificationCard = identificationCard;
		this.costCenter = costCenter;
		this.budget = budget;
		this.items = items;
		this.setTotal(total);
	}

	public int getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(int identificationCard) {
		this.identificationCard = identificationCard;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}
	
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	public void setId(String id) {
		this.id = id;
		
	}

	@Override
	public String toString() {
		return "Solitud de compra Nª: " + id + "\n" + "Fecha: " + date + "\n" + "Responsable: " + responsible + "\n"+ "Cedula de ciudadania: " + identificationCard + "\n" + "Centro de costos: " + costCenter + "\n" + "Presupuesto: "
+ budget + "\n" + "\n"+ "Items de la compra::" + "\n" + "\n" + items + "\n" + "TOTAL SOLICITUD: " + total + "\n"; 	}

}
