package teste;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dinho
 * R = earth’s radius (mean radius = 6,371km)
   Δlat = lat2− lat1
   Δlong = long2− long1
   a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
   c = 2.atan2(√a, √(1−a))
   d = R.c
 */
public class PontosNoRaio {
    double distanciaLat;
    double distanciaLong;
    double latDentroRaio;
    double longDentroRaio;
    double distancia;
    final int R = 6371; // Raio da Terra
    ArrayList<Double> arq = new ArrayList<>();
    String buffer;
//    ArrayList<String> teste = new ArrayList<>();
    int index = 0;
    
    // Uso da Fórmula de Haversine para achar a distância entre dois pontos
    public Double Haversine(double lat1, double long1,double lat2, double long2){
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
    
    //método para pegar o conteúdo dentro de um arquivo .txt (pode ser usados outros arquivos se os número de coordenadas forem organizado como 
    //                                                                                                                latitude longitude
    //                                                                                                                latitude longitude
    //                                                                                                                latitude longitude
    //                                                                                                                        .
    //                                                                                                                        .
    //                                                                                                                        .
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
    
    public void limpar(){
        arq.clear();
    }
}
