package ra5.eurovision.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Un objeto de esta clase guarda en un map (festival) las puntuaciones obtenidas
 * en el festival de Eurovisi�n por una serie de pa�ses
 * Las puntuaciones se leen de un fichero de texto (puntuaciones.txt)
 *
 * El map festival asocia nombre del pa�s con la puntuaci�n total obtenida
 * Importa el orden de las claves
 */
public class Festival {

    private static final String SALIDA = "resultados.txt";
  //  private      festival;

    /**
     * Constructor de la clase FestivalEurovision
     */
    public Festival() {
       //TODO

    }

    /**
     * A�ade al map los puntos dados a un pa�s
     * El nombre del pa�s siempre se a�ade en may�sculas
     * Si el pa�s no existe se crea una nueva entrada en el map,
     * si existe el pa�s se a�aden los puntos
     */
    public void addPuntos(String pais, int puntos) {
        //TODO



    }

    /**
     * Lee del fichero de texto ENTRADA las puntuaciones dadas
     * a los pa�ses
     * Se capturar�n todas las posibles excepciones
     * Si al leer el fichero hay alguna l�nea err�nea se
     * contabiliza pero se sigue leyendo
     * Se devuelve el n� de l�neas incorrectas
     * Se har� uso del m�todo tratarLinea()
     *
     * Usar try-with-resources
     */
    public int leerPuntuaciones(String nombre) {
        //TODO


        return 0;

    }

    /**
     * A partir de una l�nea extrae los puntos dados a cada uno de los pa�ses indicados
     * y a�ade al map esas puntuaciones
     *
     * El formato de la l�nea es
     * pais:puntos:pais:puntos:pais:puntos:pais:puntos
     *
     * Se propagan las posibles excepciones
     */
    private void tratarLinea(String linea) throws NumberFormatException, IllegalArgumentException {
        //TODO

    }

    /**
     * Dado un pa�s devuelve su puntuaci�n
     * Si el pa�s no existe se lanza la excepci�n personalizada
     * PaisExcepcion con el mensaje "Pa�s XXX no existe"
     *
     * Se propagan las posibles excepciones
     */
    public int puntuacionDe(String pais) throws PaisExcepcion {
        //TODO


        return 0;

    }

    /**
     * Devuelve el nombre del pais ganador
     * (el primero encontrado)
     */
    public String ganador() {
        //TODO


        return null;
    }

    /**
     * Guarda en el fichero SALIDA el nombre de cada pa�s y la puntuaci�n
     * total obtenida
     * Se propagan todas las excepciones
     * Usar try-with-resources
     */
    public void guardarResultados() throws IOException {
        //TODO



    }




}
