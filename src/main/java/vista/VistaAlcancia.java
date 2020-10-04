package vista;

import controlador.AlcanciaControlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VistaAlcancia {

    public AlcanciaControlador alcanciaControlador = new AlcanciaControlador();

    BufferedReader bufferOption = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException, InterruptedException {
        String opcionSeleccionada;
        do{
            System.out.println("¿Qué deseas realizar: \n" +
                    "1. Insertar una moneda. \n" +
                    "2. Conocer la cantidad total de monedas dentro de la alcancía. \n" +
                    "3. Conocer la cantidad de monedas según una denominación. \n" +
                    "4. Cantidad de dinero por denominación de moneda. \n" +
                    "5. Salir de la aplicación. \n" +
                    "Ingresa el número de la opción que deseas realizar(1, 2, 3, 4 ó 5): ");
            opcionSeleccionada = bufferOption.readLine();

            switch (opcionSeleccionada){
                case "1":
                    System.out.println("¿La moneeda que desea ingresar a la alcancía es colombiana? " +
                            "Responda SI ó NO: ");
                    String monedaColombiana = bufferOption.readLine().toUpperCase();
                    int denominacionMoneda;
                    if(monedaColombiana.equals("SI")){
                        denominacionMoneda = Integer.parseInt(validaIngresoDenominacionMoneda());
                        alcanciaControlador.insertarMoneda(denominacionMoneda);
                        System.out.println();
                    }else if(monedaColombiana.equals("NO")){
                        System.out.println("En esta alcancía solo se pueden almacenar monedas colombianas \n");
                        Thread.sleep(1000);
                    }else{
                        System.out.println("La opcion ingresada no es válida debió ingresar SI o NO.");
                        Thread.sleep(1000);
                    }
                    break;
                case "2":
                    System.out.println("La cantidad total de monedas en la alcalcía es: " +
                            alcanciaControlador.cantidadTotalMonedas());
                    break;
                case "3":
                    denominacionMoneda = Integer.parseInt(validaIngresoDenominacionMoneda());
                    double cantidadMonedasDenominacion = alcanciaControlador
                            .cantidadMonedasPorDenominacion(denominacionMoneda);
                    System.out.println("La cantidad de dinero en monedas de "+denominacionMoneda+
                            " es: "+ cantidadMonedasDenominacion);
                    break;
                case "4":
                    denominacionMoneda = Integer.parseInt(validaIngresoDenominacionMoneda());
                    double dineroPorDenominacion = alcanciaControlador
                            .cantidadDineroPorDenominacion(denominacionMoneda);
                    System.out.println("La cantidad de dinero en monedas de "+denominacionMoneda+
                            " es: "+dineroPorDenominacion);
                    break;
                case "5":
                    System.out.println("******** La cantidad total de dinero en la alcancía es de: " +
                            alcanciaControlador.cantidadTotalDineroAlcancia() + " ******** \n\n" +
                            "**********  ¡Hasta luego!   **********");
                    Thread.sleep(1000);
                    break;
                default:
                    System.out.println("\n La opción ingresada no es valida, ingrese el número " +
                            "según las opciones listadas (1, 2, 3, 4 ó 5) ");
                    Thread.sleep(2000);
            }
        }while(!opcionSeleccionada.equals("5"));
    }

    public String validaIngresoDenominacionMoneda() throws IOException, InterruptedException {
        System.out.println("Ingrese la denominación de la moneda (50,100,200,500,1000): ");
        String denominacionMoneda = bufferOption.readLine();
        if(denominacionMoneda.equals("50") || denominacionMoneda.equals("100") ||
                denominacionMoneda.equals("200") || denominacionMoneda.equals("500") ||
                denominacionMoneda.equals("1000") ){
                return denominacionMoneda;
        }else{
            System.out.println("La denominación de moneda ingresada es incorrecta. \n" +
                    "Ingresa una de las siguientes (50,100,200,500,1000) \n");
            Thread.sleep(1000);
            return denominacionMoneda;
        }
    }
}
