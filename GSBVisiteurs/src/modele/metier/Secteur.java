/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Secteur {
    String sec_Code;
    String sec_Libelle;

    public Secteur(String sec_Code, String sec_Libelle) {
        this.sec_Code = sec_Code;
        this.sec_Libelle = sec_Libelle;
    }

    public String getSec_Code() {
        return sec_Code;
    }

    public void setSec_Code(String sec_Code) {
        this.sec_Code = sec_Code;
    }

    public String getSec_Libelle() {
        return sec_Libelle;
    }

    public void setSec_Libelle(String sec_Libelle) {
        this.sec_Libelle = sec_Libelle;
    }
    
    
}
