package mx.com.gm.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Peliculas;
import mx.com.gm.peliculas.excepciones.*;

    public interface IAccesoDatos {

    boolean Existe(String nombreArchivo) throws AccesoDatosEx;

    public List<Peliculas> listar(String nombreArchivo) throws LecturaDatosEx;

    public void Escribir(Peliculas pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
    
    public String Buscar(String nombreArchivo, String buscar)throws LecturaDatosEx;

    public void Crear(String nombreArchivo)throws AccesoDatosEx;

    public void Borrar(String nombreArchivo)throws AccesoDatosEx;

}
