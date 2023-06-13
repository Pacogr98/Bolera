package bolera;

import java.util.Scanner; //Hay que importar el Scanner, el cual nos ayudará a recoger la información que el usuario introduce

public class Bolera {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in); //Creamos la variable de tipo Scanner 
        boolean salir = false; //Nos indicará cuando salir del bucle y cuando permanece dentro de el
        int opcion; //Creamos la variable opción de tipo entero la cuál claramente solo podrá contener numeros enteros
        int edad; //Va a almacenar la edad para poder aplicar una oferta u otra
        double precio = 9; //Almacenará el precio del ticket generado lo dejamos en 9 ya que es el precio normal, si os fijais lo ponemos de tipo double para que pueda contener decimales
        int ticketVendidos = 0; //contador que se incrementará +1 cada vez que se genere un ticket
        double caja = 0; //Almacena la suma de todos los precios que se generen
        
        while(!salir){  //Recuerda que !salir dentro del parámetro como tal significa false, en caso de haber querido indicar true solo pondriamos salir (Acostrumbemonos a buenas prácticas)
            
            //Con system.out.print(sout) mostramos por pantalla un mensaje y \n significa salto de linea, si añadimos a system.out.print un ln pegado detrás de la t final nos dará un salto de linea
            System.out.print("Bolera Los Maquinas \n-------------------\n");
            //Ahora haremos otro sout con el cual le daremos las diferentes opciones al usuario
            System.out.println("1. Vender Ticket \n2. Resumen de ventas \n3. Salir\n");
            opcion = scanner.nextInt(); //Guardamos mediante la variable de tipo scanner la opción dentro de opcion, si te fijas .nextInt le está indicando que lo que va recibir debe ser un int(entero)
            
            //Switch nos permite identificar si opcion contiene 1,2 o 3 y nos dejará realizar una función u otra.
            switch(opcion){
                case 1:
                    System.out.print("Generando ticket... \nEdad ?");
                    edad = scanner.nextInt(); //Misma lógica que cuando almacenamos la opción
                    //Usemos ahora condicionales
                    if(edad <= 5 || edad > 70){ //indicamos que si la edad es menor o igual a 5 cueste 1€ el precio y si tienen más de 70 también
                        precio = 1;
                    }else if(edad > 5 && edad <= 14 || edad >= 50 && edad <= 70){ 
                        //con else if lo que estamos diciendo es "si no hazme tal" es decir si no cumple la condicion arriba mira a ver si aqui puede / && significa y / || significa OR
                        //Lo he metido todo dentro de la misma para ahorrar codigo ya que si analizas el enunciado tiene sentido ;)
                        precio = precio*0.75;
                    }
                    
                    System.out.println("-----------------------\nTICKET DE ENTRADA \nEdad: "+edad+"\nTotal a pagar: "+precio+"€"); //con + concatenamos el valor de la variable con el texto
                    
                    //Antes de terminar aumentamos en 1 los ticket vendidos y sumamos en caja el dinero que hemos ingresado
                    ticketVendidos++; //el ++ incrementa en 1
                    caja += precio; //+= acumula el precio con lo que ya hay en caja
                    break;
                case 2:
                    System.out.println("\nRESUMEN DE VENTAS\n-----------------------");
                    System.out.println(ticketVendidos+" Tickets vendidos.");
                    System.out.println(caja+"€ recaudados en caja\n\n");
                    break;
                default:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
            }
        }
    }

}
