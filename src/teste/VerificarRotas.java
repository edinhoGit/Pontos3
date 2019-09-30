/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author dinho
 */
public class VerificarRotas {
    public VerificarRotas(){
        pontosEspec();
//        System.out.println(pontosEspec.get(2).getLocal());
    }
    
    PontosEspecificos gpsEspec = new PontosEspecificos();
    ArrayList<PontosEspecificos> pontosEspec = new ArrayList<>();
    
    ArrayList<PontosRota> pontosRota = new ArrayList<>();
    LinkedList<ArrayList<PontosRota>> rotas = new LinkedList<>();
    
    ArrayList<Boolean> inicioNaRota = new ArrayList<>();
    ArrayList<Boolean> fimNaRota = new ArrayList<>();
    
    public LinkedList<ArrayList<PontosRota>> carregarListaRotas(String[] qtdRotas){
        try {
            for(int i = 0; i < qtdRotas.length; i++){
                PontosRota pr = new PontosRota();
                pontosRota.addAll(pr.lerArquivoRotaUsuario("C:\\Users\\dinho\\Downloads\\Testes OoO Cametá\\Testes OoO Cametá\\Rotas\\rota_ufpa " + qtdRotas[i]));
                rotas.add(i, pontosRota);
                pr.limpar();
            }
        } catch (Exception e) {
        }
        return rotas;
    }
    
    private void pontosEspec(){
        pontosEspec.addAll(gpsEspec.lerArquivoEspecifico("C:\\Users\\dinho\\Downloads\\Testes OoO Cametá\\Testes OoO Cametá\\Pontos Específicos.txt")); //ArrayList com os pontos específicos
        gpsEspec.limpar();
    }
    
    private void continuaçãoRota(LinkedList<ArrayList<PontosRota>> listaPontos, Double raio){
        Integer cont = null;
        Boolean inicio = false;
        Boolean fim = false;
        PontosNoRaio pr = new PontosNoRaio();
        
        for(int i = 0; i < rotas.size(); i++){  // inicio do for das listas das rotas
            for(int j = 0; j < pontosEspec.size(); j++){    // inicio do for dos pontos específicos
                for(int k = 0; k < rotas.get(i).size(); k++){   // inicio do for do ArrayList de rotas que está dentro da lista
                    Boolean res = pr.estaNoRaio(rotas.get(i).get(k).getLatitude(), rotas.get(i).get(k).getLongitude(), //...................
                                            pontosEspec.get(j).getLatitude(), pontosEspec.get(j).getLongitude(), raio); // método para verificar se um ponto está dentro do raio
                    
                    if(k == (rotas.get(i).size()-1) && res == false){ // caso verificar todos os pontos e não achar nenhum ponto correspondente e o resultado ser falso
                        if(cont == null){                            // mandar uma mensagem de erro alem de definir o início como false
                            fim = false;
                            inicioNaRota.add(i, inicio = false);
                        } else {
                            cont = null;
                           fimNaRota.add(i, fim = false);
                        }
//                        System.out.println("Ponto " + pontosEspec.get(j).getLocal() + " não foi encontrado na rota " + (i + 1));
                    } else if(res){                        
                        if(cont == null){
                            cont = 0;
                            inicioNaRota.add(i, inicio = true);
                        } else if(cont == 0){
                            fim = true;
                            cont = null;
                            fimNaRota.add(i, fim = true);
                        }
                        k = rotas.get(i).size();
//                        System.out.println("O ponto " + pontosEspec.get(j).getLocal() + " está na perto da rota " + (i+1) + " no ponto " + (k+1));
                    }
                }
            }
        }
    }
    
    public void validarRotas(LinkedList<ArrayList<PontosRota>> listaPontos, Double raio){
        continuaçãoRota(listaPontos, raio);
        for(int i = 0; i < inicioNaRota.size(); i++){
            System.out.println("Inicio rota " + (i+1) + " " + inicioNaRota.get(i) + " Fim rota " + (i+1) + " " + fimNaRota.get(i));
            if(inicioNaRota.get(i) != fimNaRota.get(i)){
            }
        
        }
    }
}
