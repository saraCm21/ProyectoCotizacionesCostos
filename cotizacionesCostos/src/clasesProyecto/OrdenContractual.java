package clasesProyecto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class OrdenContractual {

	private String id;
	private int nit;
	private String deadline;
	private int total;
	private String provider;
	private ArrayList<Items>items;
	private LocalDate date;
	
	public OrdenContractual(int nit, String provider, String deadline, int total, ArrayList<Items>items) {
		this.nit = nit;
		this.deadline = deadline;
		this.provider = provider;
		this.id = getId();
		this.total = total;
		this.items = items;
		this.date = LocalDate.now();
	}

	

	public String getId() {
		UUID id = UUID.randomUUID();
	    return id.toString();
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	
	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Orden Contractual Nª: " + id + "\n" + "Fecha: " + date + "\n" + "Nit: " + nit + "\n" + "Proveedor: " + provider + "\n" + "Fecha de entrega: " + deadline + "\n"  + "Total " + total + "\n" + "\n" + "ITEMS DE LA ORDEN" + "\n" + "\n" + items;
	}
	
	
  
}
