package teste;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;


/**
 * 16/09/2019
 * @author dinho
 */
public class Teste {
    public static void main(String[] args){
        // TODO code application logic here
        
    long tempo1 = System.currentTimeMillis();
        System.out.println(tempo1);
// código para ver se a rota está perto de um ponto específico (praça, monumento, loja, etc.)
//    PontosEspecificos gpsEspec = new PontosEspecificos();
//    ArrayList<PontosEspecificos> pontosEspec = new ArrayList<>();
//    pontosEspec.addAll(gpsEspec.lerArquivoEspecifico("caminho do arquivos de pontos específicos"));
//    gpsEspec.limpar();
    
//    PontosRota gpsUser = new PontosRota();
//    ArrayList<PontosRota> pontosUser = new ArrayList<>();
//    pontosUser.addAll(gpsUser.lerArquivoRotaUsuario("caminho do arquivos das dos pontos reais do gps do usuario"));
//    gpsUser.limpar();
    
//    PontosNoRaio pr = new PontosNoRaio();
//    
//    for(int i = 0; i < pontosUser.size(); i++){
//        for(int j = 0; j < pontosEspec.size(); j++){
//            boolean res = pr.estaNoRaio(pontosUser.get(i).getLatitude(), pontosUser.get(i).getLongitude(),
//                          pontosEspec.get(j).getLatitude(), pontosEspec.get(j).getLongitude(), 0.500); // 0.500 é o tamanho do raio, pode ser alterado
//            if(res){
//                System.out.println("O Ponto " + (i + 1) + " está perto de " + pontosEspec.get(j).getLocal());
//                System.out.println("\n");
//            }
//        }
//    }

// código para ver se a rota possui continuidade
//    String[] rotasQtd = {"1.txt", "2.txt", "3.txt"};
//    VerificarRotas vr = new VerificarRotas();
//    LinkedList<ArrayList<PontosRota>> rotas = new LinkedList<>();
//    rotas.addAll(vr.carregarListaRotas(rotasQtd));
//    
//    vr.validarRotas(rotas, 0.500);
//    System.out.println("Tempo: " + (System.currentTimeMillis() - tempo1) + " Ms");
        
        System.out.println((System.currentTimeMillis() - tempo1));
    }
}
