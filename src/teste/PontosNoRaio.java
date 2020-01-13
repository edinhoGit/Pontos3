package teste;

import java.util.ArrayList;

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
//    private ArrayList<Double> arq = new ArrayList<>();
    private String buffer;
    private int index = 0;
    
    // Uso da Fórmula de Haversine para achar a distância entre dois pontos
    public Double Haversine(double lat1, double long1,double lat2, double long2){
        setLatDentroRaio(lat1);
        setLongDentroRaio(long1);
        setDistanciaLat(Math.toRadians(lat2 - lat1));
        setDistanciaLong(Math.toRadians(long2 - long1));
        Double a = Math.sin(getDistanciaLat() / 2) * Math.sin(getDistanciaLat() / 2) + 
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * 
                   Math.sin(getDistanciaLong() / 2) * Math.sin(getDistanciaLong() / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distanciaPontos = R * c;
        setDistancia(distanciaPontos);
        return distanciaPontos;
    }
    
    //método para fazer a verificação se o ponto especificado está dentro do raio dado
    public Boolean estaNoRaio(double lat1, double long1, double lat2, double long2, Double raio){
        double resultado = Haversine(lat1, long1, lat2, long2);
        if(resultado <= raio){
//            System.out.printf("%.3f: ", getDistancia());
//            System.out.println();
            return true;
        } else {
//            System.out.println("fora");
            return false;
        }
    }
 
    
//    método para limpar o ArrayList
//    public void limpar(){
//        arq.clear();
//    }

    private double getDistanciaLat() {
        return distanciaLat;
    }

    private void setDistanciaLat(double distanciaLat) {
        this.distanciaLat = distanciaLat;
    }

    private double getDistanciaLong() {
        return distanciaLong;
    }

    private void setDistanciaLong(double distanciaLong) {
        this.distanciaLong = distanciaLong;
    }

    private double getLatDentroRaio() {
        return latDentroRaio;
    }

    private void setLatDentroRaio(double latDentroRaio) {
        this.latDentroRaio = latDentroRaio;
    }

    private double getLongDentroRaio() {
        return longDentroRaio;
    }

    private void setLongDentroRaio(double longDentroRaio) {
        this.longDentroRaio = longDentroRaio;
    }

    private double getDistancia() {
        return distancia;
    }

    private void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    private String getBuffer() {
        return buffer;
    }

    private void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    private int getIndex() {
        return index;
    }

    private void setIndex(int index) {
        this.index = index;
    }
    
    
}
