package base;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class ControlCompuertas {
	private static final Logger LOGGER = Logger.getLogger(ControlCompuertas.class.getName());

	private static Scanner teclado = new Scanner(System.in);
	
	private static boolean permiso = false;
	
	private static boolean compuertasVerificadas = false;

	public static void main(String[] args) {

		  try {
		            FileHandler fileHandler = new FileHandler("opcionesMenu.log", true);
		            SimpleFormatter simpleFormatter = new SimpleFormatter();
		            fileHandler.setFormatter(simpleFormatter);
		            LOGGER.addHandler(fileHandler);
		        } catch (Exception e) {
		            LOGGER.log(Level.SEVERE, "Error al configurar el archivo de log", e);
		        }
		  
		  System.out.println(
				"Este programa lee el nivel de agua de una presa y permite abrir compuertas si tenemos permiso (el nivel es superior a 50) y las compuertas estan verificadas.");

		int nivel = leerNivelAgua();

		mostrarMenu(nivel);
		  
		      
		
		

	}
/**
 * 
 * Muestra un menu u otro dependiendo del nivel del agua
 * @author 1AW3-11
 * @param nivel, devuelve el valor del nivel del agua actual.
 * 
 */
	public static void mostrarMenu(int nivel) {
	
		int opcion = 0;
		do {
			System.out.println();
			System.out.println("Nivel del agua: " + nivel);
			System.out.println();
			System.out.println("ACCIONES: ");
			System.out.println();
			System.out.println("1. Nueva lectura del nivel de agua.");
			System.out.println("2. Abrir compuertas. Requiere:");
			System.out.println("	3. Solicitar permiso, estado: " + (permiso ? "CONCEDIDO" : "NO CONCEDIDO"));
			System.out.println("	4. Verificar compuertas, estado: " + (compuertasVerificadas ? "VERIFICADAS" : "NO VERIFICADAS"));
			System.out.println("5. Salir");
			System.out.println();
			System.out.print("Introduce opcion: ");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				
				LOGGER.log(Level.FINE, "Opción 1 seleccionada");
                nivel = leerNivelAgua();
                permiso = false;
                compuertasVerificadas = false;
                break;
			case 2:
				
				 LOGGER.log(Level.FINE, "Opción 2 seleccionada");
                 if (abrirCompuertas()) {
                     System.out.println("¡Compuertas abiertas!");
                 } else {
                     System.out.println("No se cumplen las condiciones para abrir compuertas.");
                 }
                 break;
			case 3:
				
				LOGGER.log(Level.FINE, "Opción 3 seleccionada");
                permiso = solicitarPermiso(nivel);
                if (!permiso) {
                    System.out.println("El permiso solamente se concede si el nivel del agua es superior a 60.");
                }
                break;
			case 4:
				
				 LOGGER.log(Level.FINE, "Opción 4 seleccionada");
                 compuertasVerificadas = verificarCompuertas();
                 if (compuertasVerificadas) {
                     System.out.println("¡Compuertas verificadas!");
                 }
                 break;
             default:
                 break;
			}
		} while (opcion != 5);
	}

	static int leerNivelAgua() {
		permiso = false;
		int nivel = (int) Math.round(Math.random() * 100);
		return  nivel;
	}

	static boolean abrirCompuertas() {
		if (permiso && compuertasVerificadas) {
			return true;
		}else {
			return false;
		}
	}
	
	static boolean solicitarPermiso(int nivel) {
		if (nivel > 60) {
			return true;
		}else {
			return false;
		}
	}
	static boolean verificarCompuertas() {		
		return true;
	}

}
