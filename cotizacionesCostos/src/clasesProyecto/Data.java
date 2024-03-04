package clasesProyecto;

import java.time.LocalDate;
import java.util.UUID;

public class Data {
	
	protected String id;
	protected LocalDate date;
    protected String responsible;

	public Data(String responsible) {
		this.responsible = responsible;
		this.id = getId();
		this.date = LocalDate.now();
	}

	
	public String getId() {
		UUID id = UUID.randomUUID();
	    return id.toString();
	}
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

}
