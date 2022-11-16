package com.daniel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class webScraping {

    public static void main(String[] args) throws IOException {
        //DESCARGAR INFORMACION DE LA WEB
        List<String> links = new ArrayList<>();

        links.add("https://www.bbc.com/mundo");
        links.add("https://www.bbc.com/mundo/noticias-58984987");
        links.add("https://www.bbc.com/mundo/topics/c67q9nnn8z7t");
        links.add("https://www.bbc.com/mundo/topics/ckdxnw959n7t");
        links.add("https://www.bbc.com/mundo/noticias-43826245");


        links.stream().parallel().forEach(x -> getWebContent(x));


        String link = "https://www.bbc.com/mundo";
        //String resultado = getWebContent(link);
        //System.out.println(resultado);
        //System.out.println(getWebContent("https://www.bbc.com/mundo/topics/ckdxnw959n7t"));
        //System.out.println(getWebContent("https://www.bbc.com/mundo/media/video"));

    }

    private synchronized static String getWebContent(String link) {
        System.out.println("INIT");
        System.out.println(link);
        try {
            //PARA HACER LA CONEXION
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //PARA DESCARGAR LA CABECERA DE LA PAGINA WEB
            String encoding = conn.getContentEncoding();
            InputStream input = conn.getInputStream();
            //PARA PODER DESCARGAR EL RESULTADO USAMOS:
            //String resultado = new BufferedReader(new InputStreamReader(input))
            //.lines().collect(Collectors.joining());
            Stream<String> lines = new BufferedReader(new InputStreamReader(input)).lines();
            System.out.println("END");
            return lines.collect(Collectors.joining());
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
        return "";
    }

}
