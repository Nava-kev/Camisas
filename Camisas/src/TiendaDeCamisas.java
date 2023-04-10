import java.util.Map;

public class TiendaDeCamisas {
    private Map<Integer, Camisa> camisasDisponibles;

    public TiendaDeCamisas(Map<Integer, Camisa> camisasDisponibles) {
        this.camisasDisponibles = camisasDisponibles;
    }

    public double calcularTotal(int[] idsDeCamisas) {
        int totalCamisas = idsDeCamisas.length;
        double subtotal = 0;

        for (int id : idsDeCamisas) {
            Camisa camisa = camisasDisponibles.get(id);
            if (camisa != null) {
                subtotal += camisa.getPrecio();
            }
        }

        double descuento = aplicarDescuento(totalCamisas, subtotal);
        return subtotal - descuento;
    }

    public double aplicarDescuento(int cantidadCamisas, double subtotal) {
        double descuento = 0;

        if (cantidadCamisas >= 3 && cantidadCamisas <= 5) {
            descuento = subtotal * 0.05;
        } else if (cantidadCamisas > 5) {
            descuento = subtotal * 0.08;
        }

        return descuento;
    }
}