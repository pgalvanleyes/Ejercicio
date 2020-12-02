package mx.com.gm.peliculas.negocio;


import mx.com.gm.datos.AccesoDatosImpl;
import mx.com.gm.datos.IAccesoDatos;
import mx.com.gm.peliculas.domain.Peliculas;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements IAcatalogoPeliculas {

    private IAccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void AgregarPelicula(String nombreArchivo) {
        Peliculas pelicula = new Peliculas(nombreArchivo);
        boolean anexar = true;
        try {
            anexar = datos.Existe(NOMBRE_RECURSO);
            datos.Escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void listarPelicula() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Peliculas pelicula : peliculas) {
                System.out.println("Peliculas " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.Buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void iniciarArchivo() {
        try {
            if(this.datos.Existe(NOMBRE_RECURSO)){
                datos.Crear(NOMBRE_RECURSO);
                
            }
            else {
                datos.Borrar(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
    }

}
