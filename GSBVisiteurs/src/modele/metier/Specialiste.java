/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Specialiste {
    String spe_Code;
    String spe_Libelle;

    public Specialiste(String spe_Code, String spe_Libelle) {
        this.spe_Code = spe_Code;
        this.spe_Libelle = spe_Libelle;
    }

    @Override
    public String toString() {
        return "Specialiste{" + "spe_Code=" + spe_Code + ", spe_Libelle=" + spe_Libelle + '}';
    }

    public String getSpe_Code() {
        return spe_Code;
    }

    public void setSpe_Code(String spe_Code) {
        this.spe_Code = spe_Code;
    }

    public String getSpe_Libelle() {
        return spe_Libelle;
    }

    public void setSpe_Libelle(String spe_Libelle) {
        this.spe_Libelle = spe_Libelle;
    }
    
    
    
}
