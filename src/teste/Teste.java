package teste;

import java.util.ArrayList;


/**
 *
 * @author dinho
 */
public class Teste {
    public static void main(String[] args){
        // TODO code application logic here
        ArrayList<Double> latUsuario = new ArrayList<>();
        ArrayList<Double> longUsuario = new ArrayList<>();
        PontosNoRaio pn = new PontosNoRaio();
//  --------------------------------------------------------------------------------------------------------------------------------------------------------        
        latUsuario.addAll(pn.lerArquivo("C:\\Users\\dinho\\Downloads\\Testes OoO Cametá\\Testes OoO Cametá\\Teste 1 (ufpa-centro)\\testeLat.txt"));
        pn.limpar();
        longUsuario.addAll(pn.lerArquivo("C:\\Users\\dinho\\Downloads\\Testes OoO Cametá\\Testes OoO Cametá\\Teste 1 (ufpa-centro)\\testeLong.txt"));
//  --------------------------------------------------------------------------------------------------------------------------------------------------------        
        for(int i = 0; i < longUsuario.size(); i++){
            boolean estaNoRaio2 = pn.estaNoRaio(latUsuario.get(i), longUsuario.get(i), -2.2338789, -49.494298, 1.5);
            if(estaNoRaio2){
                System.out.println("O ponto " + (i+1) + " tá no raio dado");
            }
        }
    }
}
