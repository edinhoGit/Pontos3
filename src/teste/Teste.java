package teste;

import java.util.ArrayList;


/**
 * 16/09/2019
 * @author dinho
 */
public class Teste {
    public static void main(String[] args){
        // TODO code application logic here
        ArrayList<Double> latUsuario = new ArrayList<>();
        ArrayList<Double> longUsuario = new ArrayList<>();
        PontosNoRaio pn = new PontosNoRaio();
//  --------------------------------------------------------------------------------------------------------------------------------------------------------        
        latUsuario.addAll(pn.lerArquivo("caminho do arquivo .txt"));
        pn.limpar();
        longUsuario.addAll(pn.lerArquivo("caminho do arquivo .txt"));
//  --------------------------------------------------------------------------------------------------------------------------------------------------------        
        for(int i = 0; i < longUsuario.size(); i++){ //                       ..., latitude área, longitude área, tamanho do raio
            boolean estaNoRaio2 = pn.estaNoRaio(latUsuario.get(i), longUsuario.get(i), 0.0000, 0.0000, 0.0);
            if(estaNoRaio2){
                System.out.println("O ponto " + (i+1) + " tá no raio dado");
            }
        }
    }
}
