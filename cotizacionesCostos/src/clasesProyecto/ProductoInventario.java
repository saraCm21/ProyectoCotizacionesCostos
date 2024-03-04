package clasesProyecto;


public class ProductoInventario extends Producto{
	
    private String deadline;
    private String responsible;
    private String location;
    
	public ProductoInventario(String name, int quantity,  String id, String deadline, String responsible, String location) {
		super(name, quantity, id);
		this.deadline = deadline;
		this.responsible = responsible;
		this.location = location;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
    
    @Override
    public String toString() {
    	return "Id: " + id + "\n" + "Nombre del producto: " + name + "\n" + "Responsable: " + responsible + "\n" + "Cantidad: " + quantity + "\n" + "Fecha de entreda: " + deadline + "\n" + "Locacion: " + location ;
    }
}
