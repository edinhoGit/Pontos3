package teste;

import java.util.ArrayList;


/**
 * 16/09/2019
 * @author dinho
 */
public class Teste {
    public static void main(String[] args){
        // TODO code application logic here
    long tempo1 = System.currentTimeMillis();
    PontosEspecificos gpsEspec = new PontosEspecificos();
    ArrayList<PontosEspecificos> pontosEspec = new ArrayList<>();
    pontosEspec.addAll(gpsEspec.lerArquivoEspecifico("caminho do arquivo .txt de pontos de interesse com [Nome do local, latitude, longitude]. ps: sem cochetes"));
    gpsEspec.limpar();
    
    PontosRota gpsUser = new PontosRota();
    ArrayList<PontosRota> pontosUser = new ArrayList<>();
    pontosUser.addAll(gpsUser.lerArquivoRotaUsuario("caminho do arquivo .txt de pontos de gps usuário com [latitude, longitude]. ps: sem cochetes"));
    gpsUser.limpar();
    
    PontosNoRaio pr = new PontosNoRaio();
    
    for(int i = 0; i < pontosUser.size(); i++){
        for(int j = 0; j < pontosEspec.size(); j++){
            boolean res = pr.estaNoRaio(pontosUser.get(i).getLatitude(), pontosUser.get(i).getLongitude(),
                          pontosEspec.get(j).getLatitude(), pontosEspec.get(j).getLongitude(), 0.500); // 0.500 é o tamanho do raio, pode ser alterado
            if(res){
                System.out.println("O Ponto " + (i + 1) + " está perto de " + pontosEspec.get(j).getLocal());
                System.out.println("\n");
            }
        }
    }
//    long tempo2 = System.currentTimeMillis();
    System.out.println("Tempo: " + (System.currentTimeMillis() - tempo1) + " Ms");
    }
}
