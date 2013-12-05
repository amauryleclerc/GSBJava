/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Dosage {
    String dos_Code;
    String dos_Quantite;
    String dos_Unite;

    public Dosage(String dos_Code, String dos_Quantite, String dos_Unite) {
        this.dos_Code = dos_Code;
        this.dos_Quantite = dos_Quantite;
        this.dos_Unite = dos_Unite;
    }

    @Override
    public String toString() {
        return "Dosage{" + "dos_Code=" + dos_Code + ", dos_Quantite=" + dos_Quantite + ", dos_Unite=" + dos_Unite + '}';
    }

    public String getDos_Code() {
        return dos_Code;
    }

    public void setDos_Code(String dos_Code) {
        this.dos_Code = dos_Code;
    }

    public String getDos_Quantite() {
        return dos_Quantite;
    }

    public void setDos_Quantite(String dos_Quantite) {
        this.dos_Quantite = dos_Quantite;
    }

    public String getDos_Unite() {
        return dos_Unite;
    }

    public void setDos_Unite(String dos_Unite) {
        this.dos_Unite = dos_Unite;
    }
    
    
    
}
