package clasesProyecto;

import java.util.UUID;

public class Producto {
	
    protected String id;
    protected String name;
    protected int quantity;
    protected String identificador;
    
    
	public Producto(String name, int quantity, String id) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public static String getGenerarId() {
		UUID id = UUID.randomUUID();
	    return id.toString();	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
    @Override
    public String toString() {
    	return "ID: " + id + "\n" + "Nombre: " + name + "\n" + "Cantidad: " + quantity;
    }


}
