package mx.com.gm.peliculas.negocio;

public interface IAcatalogoPeliculas {
    String NOMBRE_RECURSO = "Peliculas.txt";
    
    public void AgregarPelicula(String nombreArchivo);
    
    public void listarPelicula();
    
    public void buscarPelicula(String buscar);
    
    public void iniciarArchivo();
}
