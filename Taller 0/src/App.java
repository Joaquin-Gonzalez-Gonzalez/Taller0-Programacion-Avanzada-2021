import java.io.IOException;
import java.util.Scanner;

import ucn.*;
public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String [][] matrizSala1Mañana = new String[10][30];
		String [][] matrizSala2Mañana = new String[10][30];
		String [][] matrizSala3Mañana = new String[10][30];
		String [][] matrizSala1Tarde = new String[10][30];
		String [][] matrizSala2Tarde = new String[10][30];
		String [][] matrizSala3Tarde = new String[10][30];
		matrizSala1Mañana = rellenarMatriz(matrizSala1Mañana);
		matrizSala2Mañana = rellenarMatriz(matrizSala2Mañana);
		matrizSala3Mañana = rellenarMatriz(matrizSala3Mañana);
		matrizSala1Tarde = rellenarMatriz(matrizSala1Tarde);
		matrizSala2Tarde = rellenarMatriz(matrizSala2Tarde);
		matrizSala3Tarde = rellenarMatriz(matrizSala3Tarde);
		String [][] matrizClientes = new String[100][6];
		String [][] matrizPeliculas = new String[100][4];
		String [][] matrizFunciones = new String[2][3];
		int [] listaContadores = LeerArchivos(matrizClientes,matrizPeliculas,matrizFunciones);
		int cantClientes = listaContadores[0];
		int cantPeliculas = listaContadores[1];
		int [][] matrizPeliculasHorarios = new int [cantPeliculas][2];
		StdOut.println("1.- Iniciar Sesion");
		StdOut.println("2.- Salir");
		String respuesta = StdIn.readString();
		while(!respuesta.equals("2")) {
			if(respuesta.equals("1")) {
				InicioSesion(matrizSala1Mañana,matrizSala2Mañana,matrizSala3Mañana,matrizSala1Tarde,matrizSala2Tarde,matrizSala3Tarde,matrizClientes,matrizPeliculas,matrizFunciones,cantClientes,cantPeliculas,matrizPeliculasHorarios);
			}
			StdOut.println("1.- Iniciar Sesion");
			StdOut.println("2.- Salir");
			respuesta = StdIn.readString();
		}
		Cierre_sistema(matrizClientes,matrizPeliculas,matrizFunciones,cantClientes,cantPeliculas);
	}
	/**
	 * this function search a movie in the 
	 * @param matrizPeliculas
	 * @param cantPeliculas
	 * @param pelicula
	 * @return
	 */
	public static int buscarPelicula(String [][] matrizPeliculas,int cantPeliculas,String pelicula) {
		int i = 0;
		for(i = 0;i<cantPeliculas;i++) {
			if(matrizPeliculas[i][0].equals(pelicula)) {
				break;
			}
		}
		return i;
	}
	/**
	 * this function fill the arrays with the 
	 * @param matriz
	 * @return
	 */
	public static String [][] rellenarMatriz(String[][] matriz) {
		String [] lista = {"A","B","C","D","E","F","G","H","I","J"};
		for(int i = 0;i<10;i++) {
			for(int j= 0;j<30;j++) {
				matriz[i][j]= lista[i]+(j+1);
			}
		}
		for(int i = 0;i<5;i++) {
			for(int j = 0;j<4;j++) {
				matriz[i][j] = "-";
			}
		}
		for(int i = 25;i<30;i++) {
			for(int j = 0;j<4;j++) {
				matriz[j][i] = "-";
			}
		}
		return matriz;
	}
	/**
	 * this is the menu of the client
	 * @param matrizSala1Mañana
	 * @param matrizSala2Mañana
	 * @param matrizSala3Mañana
	 * @param matrizSala1Tarde
	 * @param matrizSala2Tarde
	 * @param matrizSala3Tarde
	 * @param matrizClientes
	 * @param matrizPeliculas
	 * @param matrizFunciones
	 * @param cantClientes
	 * @param cantPeliculas
	 * @param pos
	 * @param matrizPeliculasHorario
	 */
	public static void MenuCliente(String [][] matrizSala1Mañana,String [][] matrizSala2Mañana,String [][] matrizSala3Mañana,String [][] matrizSala1Tarde,String [][] matrizSala2Tarde,String [][] matrizSala3Tarde,String [][] matrizClientes,String [][] matrizPeliculas,String [][] matrizFunciones,int cantClientes,int cantPeliculas,int pos,int [][] matrizPeliculasHorario) {
		String respuesta = "";
		while(!respuesta.equals("5")){
			StdOut.println("1.- Comprar Entrada");
			StdOut.println("2.- Información Usuario");
			StdOut.println("3.- Devolución Entrada");
			StdOut.println("4.- Cartelera");
			StdOut.println("5.- Salir");
			StdOut.print("Respuesta: ");
			respuesta = StdIn.readString();
			if(respuesta.equals("1")) {
				ComprarEntrada(matrizSala1Mañana,matrizSala2Mañana,matrizSala3Mañana,matrizSala1Tarde,matrizSala2Tarde,matrizSala3Tarde,matrizClientes,matrizPeliculas,matrizFunciones,cantClientes,cantPeliculas,pos,matrizPeliculasHorario);
			}	
			if(respuesta.equals("2")) {
				infoUsuario(pos,matrizClientes,matrizSala1Mañana,matrizSala2Mañana,matrizSala3Mañana,matrizSala1Tarde,matrizSala2Tarde,matrizSala3Tarde,matrizFunciones);
			}
			if(respuesta.equals("3")) {
				devolucion(matrizSala1Mañana,matrizSala2Mañana,matrizSala3Mañana,matrizSala1Tarde,matrizSala2Tarde,matrizSala3Tarde,matrizClientes,matrizPeliculas,matrizFunciones,cantClientes,cantPeliculas,pos,matrizPeliculasHorario);
			}
			if(respuesta.equals("4")) {
				Cartelera(matrizFunciones);
			}
		}
	}
	/**
	 * this is the menu of the admin
	 * @param matrizSala1Mañana
	 * @param matrizSala2Mañana
	 * @param matrizSala3Mañana
	 * @param matrizSala1Tarde
	 * @param matrizSala2Tarde
	 * @param matrizSala3Tarde
	 * @param matrizClientes
	 * @param matrizPeliculas
	 * @param matrizFunciones
	 * @param cantClientes
	 * @param cantPeliculas
	 * @param matrizPeliculasHorario
	 */
	public static void MenuAdmin(String [][] matrizSala1Mañana,String [][] matrizSala2Mañana,String [][] matrizSala3Mañana,String [][] matrizSala1Tarde,String [][] matrizSala2Tarde,String [][] matrizSala3Tarde,String [][] matrizClientes,String [][] matrizPeliculas,String [][] matrizFunciones,int cantClientes,int cantPeliculas,int [][] matrizPeliculasHorario) {
		String respuesta = "";
		do {
			StdOut.println("1.- Taquilla");
			StdOut.println("2.- Información Usuario");
			StdOut.println("3.- Salir");
			StdOut.print("Respuesta: ");
			respuesta = StdIn.readString();
			if(respuesta.equals("1")) {
				Taquilla(matrizPeliculas,matrizPeliculasHorario,cantPeliculas);
			}	
			if(respuesta.equals("2")) {
				StdOut.print("Ingrese rut a buscar: ");
				String rut = StdIn.readString();
				int pos = buscarCliente(matrizClientes,cantClientes,rut);
				infoUsuario(pos,matrizClientes,matrizSala1Mañana,matrizSala2Mañana,matrizSala3Mañana,matrizSala1Tarde,matrizSala2Tarde,matrizSala3Tarde,matrizFunciones);
			}
		}while(!respuesta.equals("3"));
	}
	/**
	 * this function allows the customer to buy tickets
	 * @param matrizSala1Mañana
	 * @param matrizSala2Mañana
	 * @param matrizSala3Mañana
	 * @param matrizSala1Tarde
	 * @param matrizSala2Tarde
	 * @param matrizSala3Tarde
	 * @param matrizClientes
	 * @param matrizPeliculas
	 * @param matrizFunciones
	 * @param cantClientes
	 * @param cantPeliculas
	 * @param pos
	 * @param matrizPeliculasHorario
	 */
	public static void ComprarEntrada(String [][] matrizSala1Mañana,String [][] matrizSala2Mañana,String [][] matrizSala3Mañana,String [][] matrizSala1Tarde,String [][] matrizSala2Tarde,String [][] matrizSala3Tarde,String [][] matrizClientes,String [][] matrizPeliculas,String [][] matrizFunciones,int cantClientes,int cantPeliculas,int pos,int [][] matrizPeliculasHorario) {
		String respuesta = "";
		String pelicula = "";
			StdOut.println("1.- Sala 1 Mañana: "+ matrizFunciones[0][0]);
			StdOut.println("2.- Sala 2 Mañana: "+ matrizFunciones[0][1]);
			StdOut.println("3.- Sala 3 Mañana: "+ matrizFunciones[0][2]);
			StdOut.println("4.- Sala 1 Tarde: "+ matrizFunciones[1][0]);
			StdOut.println("5.- Sala 2 Tarde: "+ matrizFunciones[1][1]);
			StdOut.println("6.- Sala 3 Tarde: "+ matrizFunciones[1][2]);
			StdOut.print("Cual desea ver?: ");
			respuesta = StdIn.readString();
			if(respuesta.equals("1")) {
				pelicula = matrizFunciones[0][0];
				int posPeli = buscarPelicula(matrizPeliculas,cantPeliculas,pelicula);
				for(int i = 0;i<10;i++) {
					for(int j = 0;j<30;j++) {
						System.out.print(matrizSala1Mañana[i][j]+ " ");
					}
					StdOut.println("");
				}
				StdOut.print("Numero de entradas a comprar: ");
				int cantEntradas = StdIn.readInt();
				for(int i = 0;i<cantEntradas;i++) {
					StdOut.println("Elija alguno de los asientos disponibles (que no tenga nombre)");
					StdOut.print("Letra: ");
					String letra = StdIn.readString();
					StdOut.print("Numero: ");
					int numero = StdIn.readInt();
					int posLetra = convertirLetraANumero(letra);
					while(!matrizSala1Mañana[posLetra][numero].equals(letra+String.valueOf(numero+1)) && !matrizSala1Mañana[posLetra][numero-2].equals(letra+String.valueOf(numero-1))) {
						StdOut.println("Asiento no disponible por medidas sanitarias escoja otro");
						StdOut.print("Letra: ");
						letra = StdIn.readString();
						StdOut.print("Numero: ");
						numero = StdIn.readInt();
						posLetra = convertirLetraANumero(letra);	
					}
					matrizSala1Mañana[posLetra][numero-1] = matrizClientes[pos][0];
				}
				int valorEntrada = 0;
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valorEntrada = 4000*cantEntradas; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				else{
					valorEntrada = 5500*cantEntradas;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				StdOut.println("Valor a pagar: " +valorEntrada);
				StdOut.print("Esta seguro de pagar(si/no): ");
				respuesta = StdIn.readString();
				if(respuesta.equals("si")) {
					if(Integer.parseInt(matrizClientes[pos][4]) >= valorEntrada) {
						matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) - valorEntrada);
						matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) + valorEntrada);
						matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) + valorEntrada);
						matrizPeliculasHorario[posPeli][0] += valorEntrada;
						StdOut.println("Entradas Compradas con exito");
					}
					else {
						StdOut.println("Saldo Insuficiente");
					}
				}
				
				
			}
			if(respuesta.equals("2")) {
				pelicula = matrizFunciones[0][1];
				int posPeli = buscarPelicula(matrizPeliculas,cantPeliculas,pelicula);
				for(int i = 0;i<10;i++) {
					for(int j = 0;j<30;j++) {
						StdOut.print(matrizSala2Mañana[i][j]+ " ");
					}
					StdOut.println("");
				}
				StdOut.print("Numero de entradas a comprar: ");
				int cantEntradas = StdIn.readInt();
				for(int i = 0;i<cantEntradas;i++) {
					StdOut.println("Elija alguno de los asientos disponibles (que no tenga nombre)");
					StdOut.print("Letra: ");
					String letra = StdIn.readString();
					StdOut.print("Numero: ");
					int numero = StdIn.readInt();
					int posLetra = convertirLetraANumero(letra);
					while(!matrizSala2Mañana[posLetra][numero-2].equals(letra+(numero-1)) && !matrizSala2Mañana[posLetra][numero].equals(letra+(numero+1))) {
						StdOut.println("Asiento no disponible por medidas sanitarias escoja otro");
						StdOut.print("Letra: ");
						letra = StdIn.readString();
						StdOut.print("Numero: ");
						numero = StdIn.readInt();
						posLetra = convertirLetraANumero(letra);	
					}
					matrizSala2Mañana[posLetra][numero-1] = matrizClientes[pos][0];
				}
				int valorEntrada = 0;
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valorEntrada = 4000*cantEntradas; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				else{
					valorEntrada = 5500*cantEntradas;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				StdOut.println("Valor a pagar: " +valorEntrada);
				StdOut.print("Esta seguro de pagar(si/no): ");
				respuesta = StdIn.readString();
				if(respuesta.equals("si")) {
					if(Integer.parseInt(matrizClientes[pos][4]) >= valorEntrada) {
						matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) - valorEntrada);
						matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) + valorEntrada);
						matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) + valorEntrada);
						matrizPeliculasHorario[posPeli][0] += valorEntrada;
						StdOut.println("Entradas Compradas con exito");
					}
					else {
						StdOut.println("Saldo Insuficiente");
					}
				}
				
			}
			if(respuesta.equals("3")) {
				pelicula = matrizFunciones[0][2];
				int posPeli = buscarPelicula(matrizPeliculas,cantPeliculas,pelicula);
				for(int i = 0;i<10;i++) {
					for(int j = 0;j<30;j++) {
						StdOut.print(matrizSala3Mañana[i][j] + " ");
					}
					StdOut.println("");
				}
				StdOut.print("Numero de entradas a comprar: ");
				int cantEntradas = StdIn.readInt();
				for(int i = 0;i<cantEntradas;i++) {
					StdOut.println("Elija alguno de los asientos disponibles (que no tenga nombre)");
					StdOut.print("Letra: ");
					String letra = StdIn.readString();
					StdOut.print("Numero: ");
					int numero = StdIn.readInt();
					int posLetra = convertirLetraANumero(letra);
					while(!matrizSala2Mañana[posLetra][numero-2].equals(letra+(numero-1)) && !matrizSala2Mañana[posLetra][numero].equals(letra+(numero+1))) {
						StdOut.println("Asiento no disponible por medidas sanitarias escoja otro");
						StdOut.print("Letra: ");
						letra = StdIn.readString();
						StdOut.print("Numero: ");
						numero = StdIn.readInt();
						posLetra = convertirLetraANumero(letra);	
					}
					matrizSala3Mañana[posLetra][numero-1] = matrizClientes[pos][0];
				}
				int valorEntrada = 0;
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valorEntrada = 4000*cantEntradas; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				else{
					valorEntrada = 5500*cantEntradas;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				StdOut.println("Valor a pagar: " +valorEntrada);
				StdOut.print("Esta seguro de pagar(si/no): ");
				respuesta = StdIn.readString();
				if(respuesta.equals("si")) {
					if(Integer.parseInt(matrizClientes[pos][4]) >= valorEntrada) {
						matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) - valorEntrada);
						matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) + valorEntrada);
						matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) + valorEntrada);
						matrizPeliculasHorario[posPeli][0] += valorEntrada;
						StdOut.println("Entradas Compradas con exito");
					}
					else {
						StdOut.println("Saldo Insuficiente");
					}
				}
				
			}
			if(respuesta.equals("4")) {
				pelicula = matrizFunciones[1][0];
				int posPeli = buscarPelicula(matrizPeliculas,cantPeliculas,pelicula);
				for(int i = 0;i<10;i++) {
					for(int j = 0;j<30;j++) {
						StdOut.print(matrizSala1Tarde[i][j]);
					}
					StdOut.println("");
				}
				StdOut.print("Numero de entradas a comprar: ");
				int cantEntradas = StdIn.readInt();
				for(int i = 0;i<cantEntradas;i++) {
					StdOut.println("Elija alguno de los asientos disponibles (que no tenga nombre)");
					StdOut.print("Letra: ");
					String letra = StdIn.readString();
					StdOut.print("Numero: ");
					int numero = StdIn.readInt();
					int posLetra = convertirLetraANumero(letra);
					while(!matrizSala2Mañana[posLetra][numero-2].equals(letra+(numero-1)) && !matrizSala2Mañana[posLetra][numero].equals(letra+(numero+1))) {
						StdOut.println("Asiento no disponible por medidas sanitarias escoja otro");
						StdOut.print("Letra: ");
						letra = StdIn.readString();
						StdOut.print("Numero: ");
						numero = StdIn.readInt();
						posLetra = convertirLetraANumero(letra);	
					}
					matrizSala1Tarde[posLetra][numero-1] = matrizClientes[pos][0];
				}
				int valorEntrada = 0;
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valorEntrada = 4000*cantEntradas; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				else{
					valorEntrada = 5500*cantEntradas;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				StdOut.println("Valor a pagar: " +valorEntrada);
				StdOut.print("Esta seguro de pagar(si/no): ");
				respuesta = StdIn.readString();
				if(respuesta.equals("si")) {
					if(Integer.parseInt(matrizClientes[pos][4]) >= valorEntrada) {
						matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) - valorEntrada);
						matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) + valorEntrada);
						matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) + valorEntrada);
						matrizPeliculasHorario[posPeli][1] += valorEntrada;
						StdOut.println("Entradas Compradas con exito");
					}
					else {
						StdOut.println("Saldo Insuficiente");
					}
				}
			}
			if(respuesta.equals("5")) {
				pelicula = matrizFunciones[1][1];
				int posPeli = buscarPelicula(matrizPeliculas,cantPeliculas,pelicula);
				for(int i = 0;i<10;i++) {
					for(int j = 0;j<30;j++) {
						StdOut.print(matrizSala2Tarde[i][j]);
					}
					StdOut.println("");
				}
				StdOut.print("Numero de entradas a comprar: ");
				int cantEntradas = StdIn.readInt();
				for(int i = 0;i<cantEntradas;i++) {
					StdOut.println("Elija alguno de los asientos disponibles (que no tenga nombre)");
					StdOut.print("Letra: ");
					String letra = StdIn.readString();
					StdOut.print("Numero: ");
					int numero = StdIn.readInt();
					int posLetra = convertirLetraANumero(letra);
					while(!matrizSala2Mañana[posLetra][numero-2].equals(letra+(numero-1)) && !matrizSala2Mañana[posLetra][numero].equals(letra+(numero+1))) {
						StdOut.println("Asiento no disponible por medidas sanitarias escoja otro");
						StdOut.print("Letra: ");
						letra = StdIn.readString();
						StdOut.print("Numero: ");
						numero = StdIn.readInt();
						posLetra = convertirLetraANumero(letra);	
					}
					matrizSala2Tarde[posLetra][numero-1] = matrizClientes[pos][0];
				}
				int valorEntrada = 0;
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valorEntrada = 4000*cantEntradas; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				else{
					valorEntrada = 5500*cantEntradas;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				StdOut.println("Valor a pagar: " +valorEntrada);
				StdOut.print("Esta seguro de pagar(si/no): ");
				respuesta = StdIn.readString();
				if(respuesta.equals("si")) {
					if(Integer.parseInt(matrizClientes[pos][4]) >= valorEntrada) {
						matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) - valorEntrada);
						matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) + valorEntrada);
						matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) + valorEntrada);
						matrizPeliculasHorario[posPeli][1] += valorEntrada;
						StdOut.println("Entradas Compradas con exito");
					}
					else {
						StdOut.println("Saldo Insuficiente");
					}
				}
			}
			if(respuesta.equals("6")) {
				pelicula = matrizFunciones[1][2];
				int posPeli = buscarPelicula(matrizPeliculas,cantPeliculas,pelicula);
				for(int i = 0;i<10;i++) {
					for(int j = 0;j<30;j++) {
						StdOut.print(matrizSala3Tarde[i][j]);
					}
					StdOut.println("");
				}
				StdOut.print("Numero de entradas a comprar: ");
				int cantEntradas = StdIn.readInt();
				for(int i = 0;i<cantEntradas;i++) {
					StdOut.println("Elija alguno de los asientos disponibles (que no tenga nombre)");
					StdOut.print("Letra: ");
					String letra = StdIn.readString();
					StdOut.print("Numero: ");
					int numero = StdIn.readInt();
					int posLetra = convertirLetraANumero(letra);
					while(!matrizSala2Mañana[posLetra][numero-2].equals(letra+(numero-1)) && !matrizSala2Mañana[posLetra][numero].equals(letra+(numero+1))) {
						StdOut.println("Asiento no disponible por medidas sanitarias escoja otro");
						StdOut.print("Letra: ");
						letra = StdIn.readString();
						StdOut.print("Numero: ");
						numero = StdIn.readInt();
						posLetra = convertirLetraANumero(letra);	
					}
					matrizSala3Tarde[posLetra][numero-1] = matrizClientes[pos][0];
				}
				int valorEntrada = 0;
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valorEntrada = 4000*cantEntradas; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				else{
					valorEntrada = 5500*cantEntradas;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valorEntrada = valorEntrada- ((valorEntrada*15)/100);
					}
				}
				StdOut.println("Valor a pagar: " +valorEntrada);
				StdOut.print("Esta seguro de pagar(si/no): ");
				respuesta = StdIn.readString();
				if(respuesta.equals("si")) {
					if(Integer.parseInt(matrizClientes[pos][4]) >= valorEntrada) {
						matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) - valorEntrada);
						matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) + valorEntrada);
						matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) + valorEntrada);
						matrizPeliculasHorario[posPeli][1] += valorEntrada;
						StdOut.println("Entradas Compradas con exito");
					}
					else {
						StdOut.println("Saldo Insuficiente");
					}
				}
				
			}
	}
	/**
	 * this function print all the movies of the day
	 * @param matrizFunciones
	 */
	public static void Cartelera(String [][] matrizFunciones) {
		StdOut.println("Horario mañana Sala 1: "+ matrizFunciones[0][0]);
		StdOut.println("Horario mañana Sala 2: "+ matrizFunciones[0][1]);
		StdOut.println("Horario mañana Sala 3: "+ matrizFunciones[0][2]);
		StdOut.println("Horario tarde Sala 1: "+ matrizFunciones[1][0]);
		StdOut.println("Horario tarde Sala 2: "+ matrizFunciones[1][1]);
		StdOut.println("Horario tarde Sala 3: "+ matrizFunciones[1][2]);
	}
	/**
	 * this function traverse the matrix
	 * @param matrizSala
	 * @param nombre
	 * @return
	 */
	public static int recorrerMatriz(String [][] matrizSala, String nombre) {
		int sumador = 0;
		for(int i = 0; i<10;i++) {
			for(int j = 0;j<30;j++) {
				if(matrizSala[i][j].equals(nombre)) {
					sumador++;
				}
			}
		}
		return sumador;
	}
	/**
	 * this function convert the letter to numbers
	 * @param letra
	 * @return
	 */
	public static int convertirLetraANumero(String letra) {
		int numero = -1;
		if(letra.equals("A")) {
			numero = 0;
		}
		if(letra.equals("B")) {
			numero = 1;
		}
		if(letra.equals("C")) {
			numero = 2;
		}
		if(letra.equals("D")) {
			numero = 3;
		}
		if(letra.equals("E")) {
			numero = 4;
		}
		if(letra.equals("F")) {
			numero = 5;
		}
		if(letra.equals("G")) {
			numero = 6;
		}
		if(letra.equals("H")) {
			numero = 7;
		}
		if(letra.equals("I")) {
			numero = 8;
		}
		if(letra.equals("J")) {
			numero = 9;
		}
		return numero;
	}
	/**
	 * this function convert a number to letter
	 * @param numero
	 * @return
	 */
	public static String convertirNumeroAletra(int numero) {
		String letra = "";
		if(numero == 0) {
			letra = "A";
		}
		if(numero == 1) {
			letra = "B";
		}
		if(numero == 2) {
			letra = "C";
		}
		if(numero == 3) {
			letra = "D";
		}
		if(numero == 4) {
			letra = "E";
		}
		if(numero == 5) {
			letra = "F";
		}
		if(numero == 6) {
			letra = "G";
		}
		if(numero == 7) {
			letra = "H";
		}
		if(numero == 8) {
			letra = "I";
		}
		if(numero == 9) {
			letra = "J";
		}
		return letra;
	}
	/**
	 * this function return an array of the letters of customer seats
	 * @param matrizSala
	 * @param cantAsientos
	 * @param nombre
	 * @return
	 */
	public static String [] asientosClienteLetra(String [][] matrizSala,int cantAsientos,String nombre) {
		String [] listaAsientosLetra = new String[cantAsientos];
		for(int i = 0; i<10;i++) {
			for(int j = 0;j<30;j++) {
				if(matrizSala[i][j].equals(nombre)) {
					listaAsientosLetra[cantAsientos-1] = convertirNumeroAletra(i);  
				}
			}
		}
		return listaAsientosLetra;
	}
	/**
	 * this function return an array of the numbers of customer seats
	 * @param matrizSala
	 * @param cantAsientos
	 * @param nombre
	 * @return
	 */
	public static int [] asientosClienteNumero(String [][] matrizSala,int cantAsientos,String nombre) {
		int [] listaAsientosLetra = new int[cantAsientos];
		for(int i = 0; i<10;i++) {
			for(int j = 0;j<30;j++) {
				if(matrizSala[i][j].equals(nombre)) {
					listaAsientosLetra[cantAsientos-1] = j+1;  
				}
			}
		}
		return listaAsientosLetra;
	}
	/**
	 * this function print the information of the customer
	 * @param pos
	 * @param matrizClientes
	 * @param matrizSala1Mañana
	 * @param matrizSala2Mañana
	 * @param matrizSala3Mañana
	 * @param matrizSala1Tarde
	 * @param matrizSala2Tarde
	 * @param matrizSala3Tarde
	 * @param matrizFunciones
	 */
	public static void infoUsuario(int pos,String [][] matrizClientes,String [][] matrizSala1Mañana,String [][] matrizSala2Mañana,String [][] matrizSala3Mañana,String [][] matrizSala1Tarde,String [][] matrizSala2Tarde,String [][] matrizSala3Tarde, String [][] matrizFunciones) {
		StdOut.println("Nombre: " + matrizClientes[pos][0]);
		StdOut.println("Apellido: " + matrizClientes[pos][1]);
		StdOut.println("Rut: " + matrizClientes[pos][2]);
		StdOut.println("Saldo: " + matrizClientes[pos][4]);
		StdOut.println("Entradas Compradas para las siguientes peliculas: ");
		int cont = recorrerMatriz(matrizSala1Mañana,matrizClientes[pos][0]);
		if(cont>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala1Mañana,cont,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala1Mañana,cont,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		cont = recorrerMatriz(matrizSala2Mañana,matrizClientes[pos][0]);
		if(cont>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala2Mañana,cont,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala2Mañana,cont,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		cont = recorrerMatriz(matrizSala3Mañana,matrizClientes[pos][0]);
		if(cont>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala3Mañana,cont,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala3Mañana,cont,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		cont = recorrerMatriz(matrizSala1Tarde,matrizClientes[pos][0]);
		if(cont>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala1Tarde,cont,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala1Tarde,cont,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		cont = recorrerMatriz(matrizSala2Tarde,matrizClientes[pos][0]);
		if(cont>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala2Tarde,cont,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala2Tarde,cont,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		cont = recorrerMatriz(matrizSala3Tarde,matrizClientes[pos][0]);
		if(cont>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala3Tarde,cont,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala3Tarde,cont,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
	}
	/**
	 * this subprogram is the login of the program
	 * @param matrizSala1Mañana
	 * @param matrizSala2Mañana
	 * @param matrizSala3Mañana
	 * @param matrizSala1Tarde
	 * @param matrizSala2Tarde
	 * @param matrizSala3Tarde
	 * @param matrizClientes
	 * @param matrizPeliculas
	 * @param matrizFunciones
	 * @param cantClientes
	 * @param cantPeliculas
	 * @param matrizPeliculasHorario
	 */
	public static void InicioSesion(String [][] matrizSala1Mañana,String [][] matrizSala2Mañana,String [][] matrizSala3Mañana,String [][] matrizSala1Tarde,String [][] matrizSala2Tarde,String [][] matrizSala3Tarde,String [][] matrizClientes,String [][] matrizPeliculas,String [][] matrizFunciones,int cantClientes,int cantPeliculas,int [][] matrizPeliculasHorario) {
		boolean inicio = false;
		StdOut.print("Ingrese su rut: ");
		String rut = StdIn.readString();
		if(rut.equals("ADMIN")) {
			StdOut.print("Ingrese su clave: ");
			String pass = StdIn.readString();
			while(!pass.equals("ADMIN")) {
				StdOut.print("Clave incorrecta, ingrese nuevamente: ");
				pass = StdIn.readString();
			}
			MenuAdmin(matrizSala1Mañana,matrizSala2Mañana,matrizSala3Mañana,matrizSala1Tarde,matrizSala2Tarde,matrizSala3Tarde,matrizClientes,matrizPeliculas,matrizFunciones,cantClientes,cantPeliculas,matrizPeliculasHorario);
		}
		else {
			rut = CambioRut(rut);
			int pos = 0;
			while(inicio == false) {
				pos = buscarCliente(matrizClientes,cantClientes,rut);
				if(pos == 1) {
					inicio = false;
					StdOut.print("Rut no econtrado, ¿Sesea registrase?(si/no): ");
					String respuesta = StdIn.readString();
					while(!respuesta.equals("si") && !respuesta.equals("no")) {
						StdOut.println("Respuesta incorrecta");
						StdOut.print("Rut no econtrado, ¿Sesea registrase?(si/no): ");
						respuesta = StdIn.readString();
					}
					if(respuesta.equals("si")) {
						cantClientes = Registro(matrizClientes,cantClientes,rut);
						inicio = true;
					}
					else {
						StdOut.print("Ingrese rut nuevamente: ");
						rut = StdIn.readString();
						pos = buscarCliente(matrizClientes,cantClientes,rut);
					}
				}
				else {
					StdOut.print("Ingrese clave: ");
					String clave = StdIn.readString();
					while(!clave.equals(matrizClientes[pos][3])) {
						StdOut.print("Calve incorrecta, ingrese nuevamente: ");
						clave = StdIn.readString();
					}
					inicio = true;
				}
			}
			MenuCliente(matrizSala1Mañana,matrizSala2Mañana,matrizSala3Mañana,matrizSala1Tarde,matrizSala2Tarde,matrizSala3Tarde,matrizClientes,matrizPeliculas,matrizFunciones,cantClientes,cantPeliculas,pos,matrizPeliculasHorario);
			
		
		
		}
	}
	/**
	 * this function is the registration of the program
	 * @param matrizClientes
	 * @param cantClientes
	 * @param rut
	 * @return
	 */
	public static int Registro(String[][] matrizClientes, int cantClientes,String rut) {
		StdOut.print("Ingrese su nombre: ");
		String nombre = StdIn.readString();
		StdOut.print("Ingrese su apellido: ");
		String apellido = StdIn.readString();
		StdOut.print("Ingrese una clave para su rut: ");
		String password = StdIn.readString();
		StdOut.print("Ingrese saldo: ");
		String saldo = StdIn.readString();
		StdOut.print("¿Posee pase de movilidad? (si/no): ");
		String pase = StdIn.readString();
		while(!pase.equals("si") && !pase.equals("no")) {
			StdOut.println("Respuesta incorrecta");
			StdOut.print("Rut no econtrado, ¿Sesea registrase?(si/no): ");
			pase = StdIn.readString();
		}
		matrizClientes[cantClientes][0] = nombre;
		matrizClientes[cantClientes][1] = apellido;
		matrizClientes[cantClientes][2] = rut;
		matrizClientes[cantClientes][3] = password;
		matrizClientes[cantClientes][4] = saldo;
		if(pase.equals("si")) {
			matrizClientes[cantClientes][5] = "HABILITADO";
		}
		else {
			matrizClientes[cantClientes][5] = "NO HABILITADO";
		}
		cantClientes++;
		return cantClientes;
	}
	/**
	 * this function eliminates the points and the script in the rut
	 * @param rut
	 * @return
	 */
	public static String CambioRut(String rut){
		rut = rut.toUpperCase();
		rut= rut.replace(".", "");
		rut = rut.replace("-", "");
		return rut;
	}
	/**
	 * this function search a client for them rut
	 * @param matrizClientes
	 * @param cantClientes
	 * @param rut
	 * @return
	 */
	public static int buscarCliente(String [][] matrizClientes,int cantClientes,String rut) {
		int i;
		for(i=0;i<cantClientes;i++) {
			if(matrizClientes[i][2].equals(rut)) {
				break;
			}
		}
		if(i == cantClientes) {
			return -1;
		}
		else {
			return i;
		}
	}
	/**
	 * this function read all the txts
	 * @param matrizClientes
	 * @param matrizPeliculas
	 * @param matrizFunciones
	 * @return
	 * @throws IOException
	 */
	public static int [] LeerArchivos(String [][] matrizClientes, String[][] matrizPeliculas, String [][] matrizFunciones) throws IOException{
		int [] listaContadores = new int[2];
		ArchivoEntrada arch1 = new ArchivoEntrada("clientes.txt");
		while(!arch1.isEndFile()) {
			Registro reg = arch1.getRegistro();
			String nombre = reg.getString();
			String apellido = reg.getString();
			String rut = reg.getString();
			rut = CambioRut(rut);
			String password = reg.getString();
			String saldo = reg.getString();
			matrizClientes[listaContadores[0]][0] = nombre;
			matrizClientes[listaContadores[0]][1] = apellido;
			matrizClientes[listaContadores[0]][2] = rut;
			matrizClientes[listaContadores[0]][3] = password;
			matrizClientes[listaContadores[0]][4] = saldo;
			listaContadores[0] ++;
		}
		arch1.close();
		ArchivoEntrada arch2 = new ArchivoEntrada("status.txt");
		while(!arch2.isEndFile()) {
			Registro reg = arch2.getRegistro();
			String rut = reg.getString();
			rut = CambioRut(rut);
			int pos = buscarCliente(matrizClientes,listaContadores[0],rut);
			String status = reg.getString();
			matrizClientes[pos][5] = status;
		}
		arch2.close();
		ArchivoEntrada arch3 = new ArchivoEntrada("peliculas.txt");
		while(!arch3.isEndFile()) {
			Registro reg = arch3.getRegistro();
			String nombre = reg.getString();
			String tipo = reg.getString();
			String recaudacion = reg.getString();
			matrizPeliculas[listaContadores[1]][0] = nombre;
			matrizPeliculas[listaContadores[1]][1] = tipo;
			matrizPeliculas[listaContadores[1]][2] = recaudacion;
			matrizPeliculas[listaContadores[1]][3] = "0";
			String sala = reg.getString();
			while(sala != null) {
				String horario = reg.getString();
				if(horario.equals("M")) {
					matrizFunciones[0][Integer.parseInt(sala)-1]= nombre;
				}
				else {
					matrizFunciones[1][Integer.parseInt(sala)-1]= nombre;
				}
				sala = reg.getString();
			}
			listaContadores[1]++;
		}
		arch3.close();
		return listaContadores;
	}
	/**
	 * this function renames the txts
	 * @param matrizClientes
	 * @param matrizPeliculas
	 * @param matrizFunciones
	 * @param cantClientes
	 * @param cantPeliculas
	 * @throws IOException
	 */
	public static void Cierre_sistema(String [][] matrizClientes, String[][] matrizPeliculas, String [][] matrizFunciones,int cantClientes,int cantPeliculas) throws IOException {
        ArchivoSalida arch1 = new ArchivoSalida("clientes.txt");
        for(int i=0;i<cantClientes;i++) {
            Registro rg= new Registro(5+Integer.valueOf(matrizClientes[i][5]));
            rg.agregarCampo(matrizClientes[i][0]);
            rg.agregarCampo(matrizClientes[i][1]);
            rg.agregarCampo(matrizClientes[i][2]);
            rg.agregarCampo(matrizClientes[i][3]);
            rg.agregarCampo(matrizClientes[i][4]);
            arch1.writeRegistro(rg);
        }
        arch1.close();
        ArchivoSalida arch2 = new ArchivoSalida("status.txt");
        for(int q=0;q<cantClientes;q++) {
            Registro rg2 = new Registro(2);
            rg2.agregarCampo(matrizClientes[q][2]);
            rg2.agregarCampo(matrizClientes[q][5]);
            arch2.writeRegistro(rg2);
        }
        arch2.close();
        ArchivoSalida arch3 = new ArchivoSalida("productos.txt");
        for(int r=0;r<cantPeliculas;r++) {
        	int contFunciones = 0;
        	String [] salas = new String[6];
        	String [] horario = new String[6];
        	if(matrizPeliculas[r][0].equals(matrizFunciones[0][0])) {
        		salas[0] = "1";
        		horario[0] = "M";
        		contFunciones++;
        	}
        	if(matrizPeliculas[r][0].equals(matrizFunciones[0][1])) {
        		salas[0] = "2";
        		horario[0] = "M";
        		contFunciones++;
        	}
        	if(matrizPeliculas[r][0].equals(matrizFunciones[0][2])) {
        		salas[0] = "3";
        		horario[0] = "M";
        		contFunciones++;
        	}
        	if(matrizPeliculas[r][0].equals(matrizFunciones[1][0])) {
        		salas[0] = "1";
        		horario[0] = "T";
        		contFunciones++;
        	}
        	if(matrizPeliculas[r][0].equals(matrizFunciones[1][1])) {
        		salas[0] = "2";
        		horario[0] = "T";
        		contFunciones++;
        	}
        	if(matrizPeliculas[r][0].equals(matrizFunciones[1][2])) {
        		salas[0] = "3";
        		horario[0] = "T";
        		contFunciones++;
        	}
        	Registro rg2 = new Registro(2+contFunciones*2);
            rg2.agregarCampo(matrizPeliculas[r][0]);
            rg2.agregarCampo(matrizPeliculas[r][1]);
            rg2.agregarCampo(matrizPeliculas[r][2]);
            for(int i = 0;i<contFunciones;i++) {
            	rg2.agregarCampo(salas[i]);
            	rg2.agregarCampo(horario[i]);
            }
            arch2.writeRegistro(rg2);
        }
            
        arch3.close();
        }
	/**
	 * this function returns money to the customer for their input
	 * @param matrizSala1Mañana
	 * @param matrizSala2Mañana
	 * @param matrizSala3Mañana
	 * @param matrizSala1Tarde
	 * @param matrizSala2Tarde
	 * @param matrizSala3Tarde
	 * @param matrizClientes
	 * @param matrizPeliculas
	 * @param matrizFunciones
	 * @param cantClientes
	 * @param cantPeliculas
	 * @param pos
	 * @param matrizPeliculasHorario
	 */
	public static void devolucion(String [][] matrizSala1Mañana,String [][] matrizSala2Mañana,String [][] matrizSala3Mañana,String [][] matrizSala1Tarde,String [][] matrizSala2Tarde,String [][] matrizSala3Tarde,String [][] matrizClientes,String [][] matrizPeliculas,String [][] matrizFunciones,int cantClientes,int cantPeliculas,int pos,int [][] matrizPeliculasHorario) {
		StdOut.println("Entradas Compradas para las siguientes peliculas: ");
		int cont1 = recorrerMatriz(matrizSala1Mañana,matrizClientes[pos][0]);
		if(cont1>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala1Mañana,cont1,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala1Mañana,cont1,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont1;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		int cont2 = recorrerMatriz(matrizSala2Mañana,matrizClientes[pos][0]);
		if(cont2>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala2Mañana,cont2,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala2Mañana,cont2,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont2;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		int cont3 = recorrerMatriz(matrizSala3Mañana,matrizClientes[pos][0]);
		if(cont3>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala3Mañana,cont3,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala3Mañana,cont3,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont3;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		int cont4 = recorrerMatriz(matrizSala1Tarde,matrizClientes[pos][0]);
		if(cont4>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala1Tarde,cont4,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala1Tarde,cont4,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont4;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		int cont5 = recorrerMatriz(matrizSala2Tarde,matrizClientes[pos][0]);
		if(cont5>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala2Tarde,cont5,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala2Tarde,cont5,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont5;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		int cont6 = recorrerMatriz(matrizSala3Tarde,matrizClientes[pos][0]);
		if(cont6>0) {
			StdOut.println("Pelicula: "+matrizFunciones[0][0]);
			StdOut.println("Horario: mañana");
			String [] listaAsientosLetra = asientosClienteLetra(matrizSala3Tarde,cont6,matrizClientes[pos][0]);
			int [] listaAsientosNumero = asientosClienteNumero(matrizSala3Tarde,cont6,matrizClientes[pos][0]);
			StdOut.println("Asientos: ");
			for(int i = 0; i<cont6;i++) {
				StdOut.println(listaAsientosLetra[i]+listaAsientosNumero[i]);
			}
		}
		StdOut.print("Ingrese pelicula para devolucion: ");
		String pelicula = StdIn.readString();
		int posPeli = buscarPelicula(matrizPeliculas,cantPeliculas,pelicula);
		int valor = 0;
		if(pelicula.equals(matrizFunciones[0][0]) && cont1 > 0) {
			StdOut.print("Cantidad de entradas a devolver: ");
			int cant = StdIn.readInt();
			if(cant == cont1) {
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
			}
			if(cant < cont1 && cant > 0) {
				for(int i=0;i<cant;i++) {
					StdOut.print("Letra asiento: ");
					String letra = StdIn.readString();
					int posLetra = convertirLetraANumero(letra);
					StdOut.print("Numero asiento: ");
					int numero = StdIn.readInt();
					matrizSala1Mañana[posLetra][numero-1] = letra+numero; 
				}
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
				
			}
		}
		if(pelicula.equals(matrizFunciones[0][1]) && cont1 > 0) {
			StdOut.print("Cantidad de entradas a devolver: ");
			int cant = StdIn.readInt();
			if(cant == cont1) {
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
			}
			if(cant < cont1 && cant > 0) {
				for(int i=0;i<cant;i++) {
					StdOut.print("Letra asiento: ");
					String letra = StdIn.readString();
					int posLetra = convertirLetraANumero(letra);
					StdOut.print("Numero asiento: ");
					int numero = StdIn.readInt();
					matrizSala2Mañana[posLetra][numero-1] = letra+numero; 
				}
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
				
			}
		}
		if(pelicula.equals(matrizFunciones[0][2]) && cont1 > 0) {
			StdOut.print("Cantidad de entradas a devolver: ");
			int cant = StdIn.readInt();
			if(cant == cont1) {
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
			}
			if(cant < cont1 && cant > 0) {
				for(int i=0;i<cant;i++) {
					StdOut.print("Letra asiento: ");
					String letra = StdIn.readString();
					int posLetra = convertirLetraANumero(letra);
					StdOut.print("Numero asiento: ");
					int numero = StdIn.readInt();
					matrizSala3Mañana[posLetra][numero-1] = letra+numero; 
				}
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
				
			}
		}
		if(pelicula.equals(matrizFunciones[1][0]) && cont1 > 0) {
			StdOut.print("Cantidad de entradas a devolver: ");
			int cant = StdIn.readInt();
			if(cant == cont1) {
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
			}
			if(cant < cont1 && cant > 0) {
				for(int i=0;i<cant;i++) {
					StdOut.print("Letra asiento: ");
					String letra = StdIn.readString();
					int posLetra = convertirLetraANumero(letra);
					StdOut.print("Numero asiento: ");
					int numero = StdIn.readInt();
					matrizSala1Tarde[posLetra][numero-1] = letra+numero; 
				}
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
				
			}
		}
		if(pelicula.equals(matrizFunciones[1][1]) && cont1 > 0) {
			StdOut.print("Cantidad de entradas a devolver: ");
			int cant = StdIn.readInt();
			if(cant == cont1) {
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
			}
			if(cant < cont1 && cant > 0) {
				for(int i=0;i<cant;i++) {
					StdOut.print("Letra asiento: ");
					String letra = StdIn.readString();
					int posLetra = convertirLetraANumero(letra);
					StdOut.print("Numero asiento: ");
					int numero = StdIn.readInt();
					matrizSala2Tarde[posLetra][numero-1] = letra+numero; 
				}
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
				
			}
		}
		if(pelicula.equals(matrizFunciones[1][2]) && cont1 > 0) {
			StdOut.print("Cantidad de entradas a devolver: ");
			int cant = StdIn.readInt();
			if(cant == cont1) {
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
			}
			if(cant < cont1 && cant > 0) {
				for(int i=0;i<cant;i++) {
					StdOut.print("Letra asiento: ");
					String letra = StdIn.readString();
					int posLetra = convertirLetraANumero(letra);
					StdOut.print("Numero asiento: ");
					int numero = StdIn.readInt();
					matrizSala3Tarde[posLetra][numero-1] = letra+numero; 
				}
				if(matrizPeliculas[posPeli][1].equals("liberada")) {
					valor = 4000*cant; 
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				else{
					valor = 5500*cant;
					if(matrizClientes[pos][5].equals("HABILITADO")) {
						valor = valor- ((valor*15)/100);
					}
				}
				valor = valor- ((valor*20)/100);
				matrizClientes[pos][4] = String.valueOf(Integer.parseInt(matrizClientes[pos][4]) + valor);
				matrizPeliculas[posPeli][2] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][2]) - valor);
				matrizPeliculas[posPeli][3] = String.valueOf(Integer.parseInt(matrizPeliculas[posPeli][3]) - valor);
				matrizPeliculasHorario[posPeli][0] -= valor;
				
			}
		}
	}
	/**
	 * this function prints the information of the movies
	 * @param matrizPeliculas
	 * @param matrizPeliculasHorario
	 * @param cantPeliculas
	 */
	public static void Taquilla(String [][] matrizPeliculas, int [][] matrizPeliculasHorario,int cantPeliculas) {
		for(int i = 0;i<cantPeliculas;i++) {
			StdOut.println("Pelicula: " + matrizPeliculas[i][0]);
			StdOut.println("Monto Recaudado Total: "+ matrizPeliculas[i][2]);
			StdOut.println("Monto Recaudado Dia: "+ matrizPeliculas[i][3]);
			StdOut.println("Monto recaudado Mañana: "+ matrizPeliculasHorario[i][0]);
			StdOut.println("Monto recaudado Tarde: "+ matrizPeliculasHorario[i][1]);
		}
	}
}
