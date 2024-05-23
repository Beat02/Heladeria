package heladeria.servicios;

import heladeria.excepciones.ProductoNuloException;
import heladeria.modelo.Postre;
import heladeria.modelo.Flan;
import heladeria.modelo.Helado;
import heladeria.utils.Constantes;

public interface InterfazCajaRegistradora {

	void anyadirPostre(Postre nuevo) throws ProductoNuloException;
	
	   /**
     * Calcula el precio de un helado basándose en las bolas de helado:
     * 
     * - En primer lugar, se multipla el nº de bolas por el Constantes.precioBasePorBola
     * - Si el helado tiene toppings, se le añade el extraPorToppings
     * - Si el helado tiene alguna bola que sea de sabor Constantes.SABOR_CHOCOLATE, se le añadirá el precio de Constantes.extraPorChocolate
   	 * 
	 * @param unHelado El helado del que se quiere obtener el precio
	 * @return precio total del helado según sus características
	 * @throws ProductoNuloException si el producto es igual a null
	 * @see {@link Constantes}
	 * @see Helado
	 */
	double calcularPrecioHelado(Helado unHelado) throws ProductoNuloException;
	
	/**
	 * Calcula el precio de un flan:
	 * - En primer lugar se le pone un precio base por flan (Constantes.precioBasePorFlan)
	 * - Luego, si es de nuevo, se le añade el extra de Constantes.extraPorFlanHuevo
	 * - Si el flan es con caramelo, se le añade el extra por caramelo Constantes.extraPorCaramelo
	 * @param unFlan El flan del que se quiere obtener el precio
	 * @return precio total del flan según sus características
	 * @throws ProductoNuloException
	 * @see {@link Constantes}
	 * @see Flan
	 */
	double calcularPrecioFlan(Flan unFlan) throws ProductoNuloException;
	
	void incrementaCaja(double precioPostre);

	/**
	 * Comprueba si el postre está en la lista de postres registrados en la caja, basándose en el nombre del postre.
	 * @param postre Postre que se quiere comprobar si se encuentra o no
	 * @return true si el postre está en la lista, false en caso contrario
	 */
	boolean postreYaPresente(Postre postre);
	
}
