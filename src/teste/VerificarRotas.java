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
    
    public LinkedList<ArrayList<PontosRota>> carregarListaRotas(String[] qtdRotas){// método adcionar as rotas advindas de vários arquivos .txt
        try {
            for(int i = 0; i < qtdRotas.length; i++){
                PontosRota pr = new PontosRota();
                pontosRota.addAll(pr.lerArquivoRotaUsuario("caminho de arquivos das rotas numeradas " + qtdRotas[i]));
                rotas.add(i, pontosRota);
                pr.limpar();
            }
        } catch (Exception e) {
        }
        return rotas;
    }
    
    private void pontosEspec(){// método para adicionar o ponto do usuário e do local que ele quer ir
        pontosEspec.addAll(gpsEspec.lerArquivoEspecifico("caminho de arquivo descrito acima")); //ArrayList com os pontos específicos
//        System.out.println(pontosEspec.get(0).getLocal());
//        System.out.println(pontosEspec.get(1).getLocal());
        gpsEspec.limpar();
    }
    
    private void continuaçãoRota(LinkedList<ArrayList<PontosRota>> listaPontos, Double raio){// método para verificar a se uma rota
        Integer cont = null;                                                                 // possui os pontos do usuário e do local desejado  
        Boolean inicio = false;
        Boolean fim = false;
        PontosNoRaio pr = new PontosNoRaio();
        
        for(int i = 0; i < rotas.size(); i++){  // inicio do for das listas das rotas
            for(int j = 0; j < pontosEspec.size(); j++){    // inicio do for dos pontos específicos
                for(int k = 0; k < rotas.get(i).size(); k++){   // inicio do for do ArrayList de rotas que está dentro da lista
                    Boolean res = pr.estaNoRaio(rotas.get(i).get(k).getLatitude(), rotas.get(i).get(k).getLongitude(), //...................
                                            pontosEspec.get(j).getLatitude(), pontosEspec.get(j).getLongitude(), raio); // método para verificar se um
                                                                                                                        //ponto está dentro do raio
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
    
    public void validarRotas(LinkedList<ArrayList<PontosRota>> listaPontos, Double raio){// método para validação da rota caso o usuário tenha uma rota direta
        continuaçãoRota(listaPontos, raio);                                              // ou para verificar caso a uma interseção entre duas rotas
        ArrayList<Integer> rotasVerificarIntercecao = new ArrayList<>();
        ArrayList<Integer> rotasContinuacao = new ArrayList<>();
        PontosNoRaio pr = new PontosNoRaio();
        Integer k = 0;
        Boolean res;
//        System.out.println(rotasVerificarIntercecao.isEmpty());
        for(int i = 0; i < inicioNaRota.size(); i++){
//            System.out.println("Inicio rota " + (i+1) + " " + inicioNaRota.get(i) + " Fim rota " + (i+1) + " " + fimNaRota.get(i));
            if(!(inicioNaRota.get(i).equals(fimNaRota.get(i)))){
                rotasVerificarIntercecao.add(i); // vetor que armazena as rotas que não possuem continuação
            } else {
                rotasContinuacao.add(i);
                //vetor que armazena as rotas q possuem continuação
            }       
        }

        if(rotasContinuacao.isEmpty()){
            for(int vittas = 0; vittas < rotasVerificarIntercecao.size() - 1; vittas++){ // laço para verificar se as rotas possuem
                int indiceRota = rotasVerificarIntercecao.get(vittas);                  //intercessão entre elas
                int dorival = vittas + 1;
                
                while(dorival < rotasVerificarIntercecao.size()){
                    int indiceRotaProximo = rotasVerificarIntercecao.get(dorival);
                    
                    for(int u = 0; u < listaPontos.get(indiceRota).size(); u++){
                        for(int x = 0; x < listaPontos.get(indiceRotaProximo).size(); x++){
                            
                            res = pr.estaNoRaio(listaPontos.get(indiceRotaProximo).get(x).getLatitude(),
                                    listaPontos.get(indiceRotaProximo).get(x).getLongitude(),
                                    listaPontos.get(indiceRota).get(u).getLatitude(),
                                    listaPontos.get(indiceRota).get(u).getLatitude(), 0.050);
                            
                            if(res){
                                x = listaPontos.get(indiceRotaProximo).size();
                                System.out.println("A linha " + rotasVerificarIntercecao.get(indiceRota) + " possui intercessão com a linha " +
                                                        rotasVerificarIntercecao.get(indiceRotaProximo));
                                
                                } else if(!res && x >= listaPontos.get(indiceRotaProximo).size() - 2 && u >= listaPontos.get(indiceRota).size() - 2){
                                    System.out.println("A linha " + rotasVerificarIntercecao.get(indiceRota) + " não possui intercessão com a linha " +
                                                        rotasVerificarIntercecao.get(indiceRotaProximo));
                                }
                            x++;
                            }
                        u++;
                    }
                    dorival++;
                }
            }
        } else{

        }
    }
}
