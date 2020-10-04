package controlador;

import modelo.Alcancia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlcanciaControlador {

    Alcancia alcancia = Alcancia.getInstance();

    public void insertarMoneda(int denominacionMoneda) {
        alcancia.insertarMoneda(denominacionMoneda);
    }

    public double cantidadTotalMonedas() {
        return alcancia.cantidadTotalMonedas();
    }

    public double cantidadMonedasPorDenominacion(int denominacionMoneda) {
        return alcancia.cantidadMonedasPorDenominacion(denominacionMoneda);
    }

    public double cantidadDineroPorDenominacion(int denominacionMoneda) {
        return alcancia.acumuladoPorDenominacion(denominacionMoneda);
    }

    public double cantidadTotalDineroAlcancia(){
        return alcancia.acumuladoTotal();
    }
}
