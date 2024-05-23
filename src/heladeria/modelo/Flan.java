package heladeria.modelo;

public class Flan extends Postre{

	private boolean deHuevo;
	private boolean conCaramelo;
	/**
	 * @return the deHuevo
	 */
	public boolean isDeHuevo() {
		return deHuevo;
	}
	/**
	 * @param deHuevo the deHuevo to set
	 */
	public void setDeHuevo(boolean deHuevo) {
		this.deHuevo = deHuevo;
	}
	/**
	 * @return the conCaramelo
	 */
	public boolean isConCaramelo() {
		return conCaramelo;
	}
	/**
	 * @param conCaramelo the conCaramelo to set
	 */
	public void setConCaramelo(boolean conCaramelo) {
		this.conCaramelo = conCaramelo;
	}
	@Override
	public String toString() {
		return "Flan [deHuevo=" + deHuevo + ", conCaramelo=" + conCaramelo + "]";
	}
	
	
}
