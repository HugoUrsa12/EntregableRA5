package ra5.eurovision.modelo;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


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
    private static HashMap<String, Integer> festival;

    /**
     * Constructor de la clase FestivalEurovision
     */
    public Festival() {

        festival = new HashMap<>();

    }

    /**
     * A�ade al map los puntos dados a un pa�s
     * El nombre del pa�s siempre se a�ade en may�sculas
     * Si el pa�s no existe se crea una nueva entrada en el map,
     * si existe el pa�s se a�aden los puntos
     */
    public void addPuntos(String pais, int puntos) {

        if(festival.containsKey(pais)){
            int punt = festival.get(pais) + puntos;
            festival.remove(pais);
            festival.put(pais, punt);
        }
        else {
            festival.put(pais, puntos);
        }


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

        try (BufferedReader read = new BufferedReader(new FileReader(nombre))){
            String linea = read.readLine();
            int incorrectas = 0;
            while(linea != null){
                try {
                    tratarLinea(linea);
                }
                catch (Exception e){
                    incorrectas++;
                }
            }
            return incorrectas;

        } catch (IOException e) {
            throw new RuntimeException(e);


        }
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

        String[] trozos = linea.split(":");
        if (trozos.length % 2 != 0) {
                throw new IllegalArgumentException("Formato de l�nea incorrecto: " + linea);
        }
        for (int i = 0; i < trozos.length - 1; i+=2) {
                festival.put(trozos[i].trim(), Integer.parseInt(trozos[i+1]));
        }

    }

    /**
     * Dado un pa�s devuelve su puntuaci�n
     * Si el pa�s no existe se lanza la excepci�n personalizada
     * PaisExcepcion con el mensaje "Pa�s XXX no existe"
     *
     * Se propagan las posibles excepciones
     */
    public static int puntuacionDe(String pais) throws PaisExcepcion {

        if (pais == null) {
            throw new PaisExcepcion("El pa�s " + pais + " no esta en la lista");
        }
        return festival.get(pais);

    }

    /**
     * Devuelve el nombre del pais ganador
     * (el primero encontrado)
     */
    public static String ganador() {
        int max = 0;
        String ganador = null;
        for (String clave : festival.keySet()) {
            if (festival.get(clave) > max) {
                max = festival.get(clave);
                ganador = clave;
            }
        }

        return ganador;
    }

    /**
     * Guarda en el fichero SALIDA el nombre de cada pa�s y la puntuaci�n
     * total obtenida
     * Se propagan todas las excepciones
     * Usar try-with-resources
     */
    public void guardarResultados() throws IOException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(SALIDA)))) {
            for (String clave : festival.keySet()) {
                writer.println(clave + ": " + festival.get(clave));
            }
        }
        catch(IOException e){
                throw new IOException("No se puda guardar los resultados", e);
            }




    }




}
