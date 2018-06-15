package com.damian.examenmaven;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

    public static void main(String[] args) {
    //Declaramos la variable doc que usaremos durante todo el proyecto
        
        Document doc = null;
         /*
        try-catch para cargar el html
        */
       
        try {
            doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/SPXX0084:1:SP").get();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Codigo para cargar los datos e imprimirlos
          String title = doc.title();
          Element headerDiv = doc.select("div.today_nowcard-temp").first();
          
          String temp = "<div class=\"today_nowcard-temp\"></div>";
          Document doc1 = Jsoup.parseBodyFragment(temp);
          String frase = "<div class=\"today_nowcard-phrase\"></div>";
          Document doc2 = Jsoup.parseBodyFragment(frase);
          

          System.out.printf("Datos extraidos de: %s%n", title);
          System.out.printf("Temperatura: %n", doc1.html(temp));
          System.out.printf("Estado del Cielto: %n", doc1.html(frase));
          
          
          
//          System.out.printf("Body: %s", body);
    }
    
}
