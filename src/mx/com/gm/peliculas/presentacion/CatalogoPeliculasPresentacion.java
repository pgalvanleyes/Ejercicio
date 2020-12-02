package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;
import mx.com.gm.peliculas.negocio.IAcatalogoPeliculas;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        var opcion = -1;
        Scanner sc = new Scanner(System.in);
        IAcatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elige una opcion \n"
                    + "1-Iniciar Catalogo de Peliculas\n"
                    + "2-Agregar Pelicula\n"
                    + "3-Lista de Peliculas\n"
                    + "4-Buscar Pelicula\n"
                    + "0-Salir");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) 
                    {
                case 1:
                    catalogo.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula = sc.nextLine();
                    catalogo.AgregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPelicula();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la pelicula");
                    var buscar = sc.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta luego");
                    break;

            }
        }
    }

}
