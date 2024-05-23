package heladeria.testJUnit;


import heladeria.excepciones.ProductoNuloException;
import heladeria.modelo.BolaHelado;
import heladeria.modelo.Flan;
import heladeria.modelo.Helado;
import heladeria.modelo.Postre;
import heladeria.servicios.CajaRegistradora;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CajaRegistradoraTest {

    static CajaRegistradora caja;
    static Postre postre;
    static Flan flan;
    static Helado helado;
    static BolaHelado bola;
    static String sabor = "";

    @BeforeEach
     void crearInstancias() {
        caja = new CajaRegistradora();
        postre = new Postre();
        flan = new Flan();
        helado = new Helado();
        bola = new BolaHelado(sabor);
    }
    @BeforeEach
    void mensaje(){
        System.out.println("---INICIO TEST---BEATRIZ RUIZ");
    }
    @AfterEach
    void mensajeFin(){
        System.out.println("---FIN TEST---BEATRIZ RUIZ");
    }

    @AfterAll
    static void mensajeFinal() {
        System.out.println("TEST FINALIZADO");
    }

    @Test
    @DisplayName("revisar si el postre esta presente true")
    void postreYaPresente() {
        List<Postre> lista = caja.getPostres();
        postre.setNombre("bizcocho");
        Postre p1 = new Postre();
        p1.setNombre("muffin");
        Postre p2 = new Postre();
        p2.setNombre("chocolate");
        Postre p3 = new Postre();
        p3.setNombre("bizcocho");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        assertTrue(caja.postreYaPresente(postre));
    }

    @Test
    @DisplayName("revisar si el postre esta presente False")
    void postreYaPresenteFalse() {
        List<Postre> lista = caja.getPostres();
        postre.setNombre("bizcocho");
        Postre p1 = new Postre();
        p1.setNombre("muffin");
        Postre p2 = new Postre();
        p2.setNombre("chocolate");
        Postre p3 = new Postre();
        p3.setNombre("tarta");

        lista.add(p1);
        lista.add(p2);
        lista.add(p3);

        assertFalse(caja.postreYaPresente(postre));
    }

    @Test
    @DisplayName("assert throw excepcion en flan")
    void calcularPrecioFlanExcepcion() {
        assertThrows(ProductoNuloException.class, () -> {
            caja.calcularPrecioFlan(null);
        });
    }

    @Test
    @DisplayName("revisar si añade el extra de huevo")
    void calcularPrecioFlanExtraHuevo() throws ProductoNuloException {
        flan.setDeHuevo(true);
        assertEquals(2, caja.calcularPrecioFlan(flan));
    }

    @Test
    @DisplayName("revisar si añade el extra de caramelo")
    void calcularPrecioFlanExtraCaramelo() throws ProductoNuloException {
        flan.setConCaramelo(true);
        assertEquals(1.25, caja.calcularPrecioFlan(flan));
    }

    @Test
    @DisplayName("revisar precio sin extras")
    void calcularPrecioFlanBasico() throws ProductoNuloException {
        assertEquals(1, caja.calcularPrecioFlan(flan));
    }

    @Test
    @DisplayName("assert throw excepcion en helado")
    void calcularPrecioHeladoExcepcion() {
        assertThrows(ProductoNuloException.class, () -> {
            caja.calcularPrecioHelado(null);
        });
    }

    @Test
    @DisplayName("revisar precio sin extras")
    void calcularPrecioHeladoBasico() throws ProductoNuloException {
        List<BolaHelado> bolas = helado.getBolas();
        bolas.add(new BolaHelado("Vainilla"));
        bolas.add(new BolaHelado("fresa"));
        helado.setBolas(bolas);
        assertEquals(1.50, caja.calcularPrecioHelado(helado));
    }

    @Test
    @DisplayName("revisar precio con toppings")
    void calcularPrecioHeladoToppings() throws ProductoNuloException {
        List<BolaHelado> bolas = helado.getBolas();
        bolas.add(new BolaHelado("Vainilla"));
        bolas.add(new BolaHelado("fresa"));
        helado.setTieneToppings(true);
        helado.setBolas(bolas);
        assertEquals(2, caja.calcularPrecioHelado(helado));
    }

    @Test
    @DisplayName("revisar precio con toppings")
    void calcularPrecioHeladoDeChocolate() throws ProductoNuloException {
        List<BolaHelado> bolas = helado.getBolas();
        bolas.add(new BolaHelado("Vainilla"));
        bolas.add(new BolaHelado("chocolate"));
        helado.setBolas(bolas);
        assertEquals(3, caja.calcularPrecioHelado(helado));
    }

    @Test
    @DisplayName("encuentra bola True")
    void encontrarBola() {
        List<BolaHelado> bolas = helado.getBolas();
        bolas.add(new BolaHelado("Vainilla"));
        bolas.add(new BolaHelado("chocolate"));
        helado.setBolas(bolas);
        assertTrue(caja.encuentraBola("vainilla", bolas));
    }
    @Test
    @DisplayName("encuentra bola False")
    void encontrarBolaFalse() {
        List<BolaHelado> bolas = helado.getBolas();
        bolas.add(new BolaHelado("Vainilla"));
        bolas.add(new BolaHelado("chocolate"));
        helado.setBolas(bolas);
        assertFalse(caja.encuentraBola("fresa", bolas));
    }

}
