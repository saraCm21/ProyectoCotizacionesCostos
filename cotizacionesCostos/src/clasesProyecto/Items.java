package clasesProyecto;

import java.util.UUID;

public class Items {
	
	private String id;
    private String name;
    private int quantity;
    private String unitM;
    private float value;
    private float totalValue;
    private String identificador;
    
	public Items(String name, int quantity, String unitM, float value) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.unitM = unitM;
		this.value = value;
		this.id = getId();
		this.totalValue = getTotalValue();
	}
	

	public String getId() {
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

	public String getUnitM() {
		return unitM;
	}

	public void setUnitM(String unitM) {
		this.unitM = unitM;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getTotalValue() {
		float totalValue = quantity * value;
		return totalValue;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	
	public void setId(String id) {
		this.id = id;
		
	}
    
    @Override
    public String toString() {
    	return "ID: " + id + "\n" + "Nombre: " + name + "\n" + "Cantidad: " + quantity + "\n" + "Unidad de medida: " + unitM + "\n" + "Valor unitario: " + value + "\n" + "Valor Total: " + totalValue ;
    }

}
