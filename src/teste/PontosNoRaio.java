package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * 16/09/2019
 * @author dinho
 * R = earth’s radius (mean radius = 6,371km)
   Δlat = lat2− lat1
   Δlong = long2− long1
   a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
   c = 2.atan2(√a, √(1−a))
   d = R.c
 */
public class PontosNoRaio {
    private double distanciaLat;
    private double distanciaLong;
    private double latDentroRaio;
    private double longDentroRaio;
    private double distancia;
    private final int R = 6371; // Raio da Terra
    private ArrayList<Double> arq = new ArrayList<>();
    private String buffer;
    private int index = 0;
    
    // Uso da Fórmula de Haversine para achar a distância entre dois pontos
    private Double Haversine(double lat1, double long1,double lat2, double long2){
        latDentroRaio = lat1;
        longDentroRaio = long1;
        distanciaLat = Math.toRadians(lat2 - lat1);
        distanciaLong = Math.toRadians(long2 - long1);
        Double a = Math.sin(distanciaLat / 2) * Math.sin(distanciaLat / 2) + 
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * 
                   Math.sin(distanciaLong / 2) * Math.sin(distanciaLong / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distanciaPontos = R * c;
//        System.out.printf("A distância entre os pontos é de: %.3f Km\n", distanciaPontos);
        distancia = distanciaPontos;
        return distanciaPontos;
    }
    
    //método para fazer a verificação se o ponto especificado está dentro do raio dado
    public Boolean estaNoRaio(double lat1, double long1, double lat2, double long2, Double raio){
        double resultado = Haversine(lat1, long1, lat2, long2);
        if(resultado <= raio){
            System.out.printf("Latitude: " + latDentroRaio + ", Longitude: " + longDentroRaio + ", Distância: %.3f\n", distancia);
            return true;
        } else {
//            System.out.println("erro");
            return false;
        }
    }
    
    //método para pegar o conteúdo dentro de um arquivo .txt (pode ser usados outros
    //arquivos se os número de coordenadas forem organizado como 
    //                                latitude longitude
    //                                latitude longitude
    //                                latitude longitude
    //                                         .
    //                                         .
    //                                         .
    public ArrayList<Double> lerArquivo(String caminhoArq){
        
        try {
            File gpsUsuario = new File(caminhoArq);
            Scanner scanner = new Scanner(gpsUsuario);
            scanner.useDelimiter("\n");
            while(scanner.hasNextLine()){
                buffer = scanner.nextLine();
                arq.add(index, Double.parseDouble(buffer));
                index = index + 1;
            }
            index = 0;
//            System.out.println("Tamanho: " + arq.size());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Deu erro parente");
        }
        return arq;
    }
    
//    método para limpar o ArrayList
    public void limpar(){
        arq.clear();
    }
}
