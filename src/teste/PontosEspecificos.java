package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *20/09/2019
 * @author dinho
 *
 */
public class PontosEspecificos {
    private String local;
    private String linha;
    private Double latitude;
    private Double longitude;
    private Integer index;
    private ArrayList<PontosEspecificos> arq = new ArrayList<>();
    
//    Método para ler um arquivo .txt
    public ArrayList<PontosEspecificos> lerArquivoEspecifico(String caminhoArq){
        index = 0;
        try {
            FileReader arquivo = new FileReader(caminhoArq);
            BufferedReader reader = new BufferedReader(arquivo);
            while((linha = reader.readLine()) != null){
                PontosEspecificos pe = new PontosEspecificos();
                String[] buffer = linha.split(", ");
                pe.setLocal(buffer[0]);
                pe.setLatitude(Double.parseDouble(buffer[1]));
                pe.setLongitude(Double.parseDouble(buffer[2]));
                arq.add(index, pe);
                setIndex(getIndex() + 1);
            }
            reader.close();
            arquivo.close();
            setIndex(0);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de pontos de referência nâo encontrado");
        } catch (IOException e){
            
        }
        return arq;
    }
    
//    método para limpar o ArrayList
    public void limpar(){
        arq.clear();
    } 
    
    private String concertarPalavra(String linha){
        
    return null;
}

// ----------------------------------------------------------------------------------------------------------------------------

    public String getLocal() {
        return local;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    private void setLocal(String local) {
        this.local = local;
    }

    private void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    private void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    
    private Integer getIndex(){
        return index;
    }
    
    private void setIndex(Integer index){
        this.index = index;
    }
}

