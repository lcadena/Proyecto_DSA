package hola;

import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONEscenario {

    public void run(Escenario bosque) {
        ObjectMapper mapa = new ObjectMapper();
        //Escenario escenario = createDummyObject();
        try {
            // Convert object to JSON string and save into a file directly
            mapa.writeValue(new File("C:\\Users\\Lizeth\\IdeaProjects\\EjColecciones1(1)\\Escenario.json"), bosque);

            // Convert object to JSON string
            String jsonInString = mapa.writeValueAsString(bosque);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapa.writerWithDefaultPrettyPrinter().writeValueAsString(bosque);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e){
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /*private Escenario createDummyObject(){
        Escenario escenario = new Escenario();

        escenario.setNombre("Bosque");
        escenario.setAlto(10);
        escenario.setAncho(10);

        Celda [][] celdas = new Celda[10][10];
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++) {
                celdas[i][j] = new Celda();
            }

        return escenario;

    }*/

    public Escenario run2() {
        ObjectMapper mapper = new ObjectMapper();
        Escenario bosque2 = new  Escenario();
        try {
            bosque2 = mapper.readValue(new File("C:\\Users\\Lizeth\\IdeaProjects\\EjColecciones1(1)\\Escenario.json"), Escenario.class);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bosque2;
    }

}
