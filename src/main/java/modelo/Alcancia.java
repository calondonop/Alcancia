package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Alcancia {

    private static Alcancia alcancia;
    private Map<Integer,Integer> acumulado;

    private Alcancia(){
        acumulado = new HashMap<>();
    }

    public static Alcancia getInstance(){
        if(alcancia == null){
            synchronized (Alcancia.class){
                if(alcancia == null){
                    alcancia = new Alcancia();
                }
            }
        }
        return alcancia;
    }
    public void insertarMoneda(int denominacionMoneda){
        int cantidadMonedas;
        if(tieneDenominacion(denominacionMoneda)){
            cantidadMonedas = acumulado.get(denominacionMoneda)+1;
            acumulado.put(denominacionMoneda, cantidadMonedas);
        }else{
            acumulado.put(denominacionMoneda, 1);
        }
    }

    public double cantidadTotalMonedas(){
        return acumulado.entrySet()
                .stream()
                .map(entry->entry.getValue())
                .reduce(0,Integer::sum);
    }

    public int cantidadMonedasPorDenominacion(int denominacionMoneda){
        if(tieneDenominacion(denominacionMoneda)){
            return alcancia.acumulado.get(denominacionMoneda);
        }else{
            return 0;
        }
    }

    public double acumuladoPorDenominacion(int denominacionMoneda){
        if (tieneDenominacion(denominacionMoneda)){
            return alcancia.acumulado.get(denominacionMoneda)*denominacionMoneda;
        }else{
            return 0;
        }
    }

    public double acumuladoTotal(){
        return acumulado.entrySet()
                .stream()
                .map(key -> key.getValue()*key.getKey())
                .reduce(0,Integer::sum);
    }

    public boolean tieneDenominacion(int denominacionMoneda){
        if(acumulado.containsKey(denominacionMoneda)){
            return true;
        }else{
            return false;
        }
    }
}
