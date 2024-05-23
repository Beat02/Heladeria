package heladeria.servicios;

import java.util.ArrayList;
import java.util.List;

import heladeria.excepciones.ProductoNuloException;
import heladeria.modelo.Postre;
import heladeria.modelo.BolaHelado;
import heladeria.modelo.Flan;
import heladeria.modelo.Helado;
import heladeria.utils.Constantes;

public class CajaRegistradora implements InterfazCajaRegistradora {

	private List<Postre> postres = new ArrayList<>();
	private double totalCaja = 0d;
	//TODO
	@Override
	public void anyadirPostre(Postre nuevo) throws ProductoNuloException {
		double precioPostre = 0d;

		if (!postreYaPresente(nuevo)) {

			if (nuevo instanceof Helado unHelado) {
				precioPostre = calcularPrecioHelado(unHelado);
			} else if (nuevo instanceof Flan unFlan) {
				precioPostre = calcularPrecioFlan(unFlan);
			}

			incrementaCaja(precioPostre);

			this.postres.add(nuevo);
		}

	}
	//DONE
	@Override
	public double calcularPrecioHelado(Helado unHelado) throws ProductoNuloException {
		
		if(unHelado == null) {
			throw new ProductoNuloException();
		}
		
		double precioHelado = unHelado.getNumeroBolas() * Constantes.precioBasePorBola;
		if (unHelado.isTieneToppings()) {
			precioHelado += Constantes.extraPorToppings;
		}

		if (unHelado.getNumeroBolas() > 0 && encuentraBola(Constantes.SABOR_CHOCOLATE, unHelado.getBolas())) {
			precioHelado += Constantes.extraPorChocolate;
		}

		return precioHelado;

	}
	//DONE
	@Override
	public double calcularPrecioFlan(Flan unFlan) throws ProductoNuloException {
		
		if(unFlan == null) {
			throw new ProductoNuloException();
		}
		
		
		double precioFlan = Constantes.precioBasePorFlan;
		if (unFlan.isDeHuevo()) {
			precioFlan += Constantes.extraPorFlanHuevo;
		}

		if (unFlan.isConCaramelo()) {
			precioFlan += Constantes.extraPorCaramelo;
		}
		return precioFlan;
	}
	//TODO
	@Override
	public void incrementaCaja(double precioPostre) {
		this.totalCaja += precioPostre;
	}
	//DONE
	public boolean encuentraBola(String sabor, List<BolaHelado> bolas) {

		boolean saborEncontrado = false;

		for (BolaHelado bolaHelado : bolas) {
			if (bolaHelado != null && bolaHelado.getSabor().equalsIgnoreCase(sabor)) {
				saborEncontrado = true;
			}
		}
		return saborEncontrado;
	}
	//DONE
	@Override
	public boolean postreYaPresente(Postre postre) {
		return this.postres.stream().anyMatch(p -> p.getNombre().equalsIgnoreCase(postre.getNombre()));
	}

	/**
	 * @return the postres
	 */
	public List<Postre> getPostres() {
		return postres;
	}

	/**
	 * @return the totalCaja
	 */
	public double getTotalCaja() {
		return totalCaja;
	}

}
