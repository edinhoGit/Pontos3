package teste;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *20/09/2019
 * @author dinho
 */
public class PontosRota {
    private Double latitude;
    private Double longitude;
    private Integer index;
    private String linha;
    private ArrayList<PontosRota> arq = new ArrayList<>();
    
//    Método para ler um arquivo .txt
    public ArrayList<PontosRota> lerArquivoRotaUsuario(String caminhoArq){
        setIndex(0);
        try {
            FileReader arquivo = new FileReader(caminhoArq);
            BufferedReader reader = new BufferedReader(arquivo);
            while((linha = reader.readLine()) != null){
                PontosRota pr = new PontosRota();
                String[] buffer = linha.split(", ");
                pr.setLatitude(Double.parseDouble(buffer[0]));
                pr.setLongitude(Double.parseDouble(buffer[1]));
                arq.add(getIndex(), pr);
                setIndex(getIndex() + 1);
            }
            reader.close();
            arquivo.close();
            setIndex(0);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de gps usuário não encontrado.");
        } catch(IOException e){
            
        }
        return arq;
    }
    
// ----------------------------------------------------------------------------------------------------------------------------
    
    public void limpar(){
        arq.clear();
    }

    public Double getLatitude() {
        return latitude;
    }

    private void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    private void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getIndex() {
        return index;
    }

    private void setIndex(Integer index) {
        this.index = index;
    } 
}
