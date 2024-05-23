package heladeria.modelo;

public class BolaHelado {

	private String sabor;
	

	public BolaHelado(String sabor) {
		super();
		this.sabor = sabor;
	}

	/**
	 * @return the sabor
	 */
	public String getSabor() {
		return sabor;
	}

	/**
	 * @param sabor the sabor to set
	 */
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	@Override
	public String toString() {
		return "BolaHelado [sabor=" + sabor + "]";
	}
	
	
}
