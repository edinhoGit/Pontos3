

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author dinho
 */
public class PontosEspecificos {
    private String local;
    private String linha;
    private Double latitude;
    private Double longitude;
    private Integer index = 0;
    private ArrayList<PontosEspecificos> arq = new ArrayList<>();
    private PontosEspecificos ptsEsp;
    
    public ArrayList<PontosEspecificos> lerArquivo(String caminhoArq){
        try {
            FileReader pontosEspecificos = new FileReader(caminhoArq);
            BufferedReader reader = new BufferedReader(pontosEspecificos);
            while((linha = reader.readLine()) != null){
                String[] buffer = linha.split(", ");
                this.ptsEsp.setLocal(buffer[0]);
                this.ptsEsp.setLatitude(Double.parseDouble(buffer[1]));
                this.ptsEsp.setLongitude(Double.parseDouble(buffer[2]));
                arq.add(this.getIndex(), this.ptsEsp);
                this.setIndex(this.getIndex() + 1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nâo encontrado");
        } catch (IOException e){
            
        }
        this.setIndex(0);
        return this.getArq();
    }
    
//    método para limpar o ArrayList
    public void limpar(){
        arq.clear();
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public ArrayList<PontosEspecificos> getArq() {
        return arq;
    }

    public void setArq(ArrayList<PontosEspecificos> arq) {
        this.arq = arq;
    }
    
}
