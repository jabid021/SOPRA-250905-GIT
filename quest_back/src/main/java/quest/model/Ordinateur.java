package quest.model;

public class Ordinateur {

	private Integer id;
	private String marque;
	private int ram;
	
	public Ordinateur(Integer id, String marque, int ram) {
		this.id = id;
		this.marque = marque;
		this.ram = ram;
	}
	public Ordinateur(String marque, int ram) {
		this.marque = marque;
		this.ram = ram;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	@Override
	public String toString() {
		return "Ordinateur [id=" + id + ", marque=" + marque + ", ram=" + ram + "]";
	}
	
	
	
}
