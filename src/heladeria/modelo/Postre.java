package heladeria.modelo;

public class Postre {

	private int calorias;
	private String nombre;
	/**
	 * @return the calorias
	 */
	public int getCalorias() {
		return calorias;
	}
	/**
	 * @param calorias the calorias to set
	 */
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Postre [calorias=" + calorias + ", nombre=" + nombre + "]";
	}
	
	
}
