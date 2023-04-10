import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TiendaDeCamisasTest {
    private TiendaDeCamisas tiendaDeCamisas;

    @BeforeEach
    public void setUp() {
        Map<Integer, Camisa> camisasDisponibles = new HashMap<>();
        camisasDisponibles.put(1, new Camisa(1, "Camisa de manga corta", 190));
        camisasDisponibles.put(2, new Camisa(2, "Camisa casual de manga larga", 230));
        camisasDisponibles.put(3, new Camisa(3, "Camisa formal de manga larga", 310));

        tiendaDeCamisas = new TiendaDeCamisas(camisasDisponibles);
    }

    @Test
    public void testAplicarDescuento() {
        assertEquals(0, tiendaDeCamisas.aplicarDescuento(1, 190), 0.01);
        assertEquals(0, tiendaDeCamisas.aplicarDescuento(2, 420), 0.01);
        assertEquals(36.5, tiendaDeCamisas.aplicarDescuento(4, 730), 0.01);
        assertEquals(62.4, tiendaDeCamisas.aplicarDescuento(7, 780), 0.01);
    }
    @Test
    public void testCalcularTotal() {
        int[] caso1 = {1, 2};
        assertEquals(420, tiendaDeCamisas.calcularTotal(caso1), 0.01);
    
        int[] caso2 = {1, 1, 2, 3};
        assertEquals(693.5, tiendaDeCamisas.calcularTotal(caso2), 0.01);
    
        int[] caso3 = {1, 1, 1, 2, 2, 3, 3};
        assertEquals(1177.6, tiendaDeCamisas.calcularTotal(caso3), 0.01);
    }
}