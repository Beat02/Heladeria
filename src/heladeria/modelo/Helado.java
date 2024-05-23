package heladeria.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helado extends Postre{

	private static final int MAX_BOLAS = 3;

	private boolean tieneToppings;
	private List<BolaHelado> bolas = new ArrayList<>(MAX_BOLAS);
	
	public void anyadeBola(BolaHelado bola) {
		if(getNumeroBolas() < MAX_BOLAS) {
			bolas.add(bola);
		}else {
			System.out.println("Ya no se admiten m�s bolas");
		}
	}
	/**
	 * @return the tieneToppings
	 */
	public boolean isTieneToppings() {
		return tieneToppings;
	}
	/**
	 * @param tieneToppings the tieneToppings to set
	 */
	public void setTieneToppings(boolean tieneToppings) {
		this.tieneToppings = tieneToppings;
	}
	
	public int getNumeroBolas() {
		return this.bolas.size();
	}
	/**
	 * @return the bolas
	 */
	public List<BolaHelado> getBolas() {
		return bolas;
	}
	/**
	 * @param bolas the bolas to set
	 */
	public void setBolas(List<BolaHelado> bolas) {
		this.bolas = bolas;
	}
	
	@Override
	public String toString() {
		return "Helado [tieneToppings=" + tieneToppings + ", bolas=" + bolas + "]";
	}
	
	
}


