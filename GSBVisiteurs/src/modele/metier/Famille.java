/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Famille {
    String fam_Code;
    String fam_Libelle;

    public Famille(String fam_Code, String fam_Libelle) {
        this.fam_Code = fam_Code;
        this.fam_Libelle = fam_Libelle;
    }

    @Override
    public String toString() {
        return "Famille{" + "fam_Code=" + fam_Code + ", fam_Libelle=" + fam_Libelle + '}';
    }

    public String getFam_Code() {
        return fam_Code;
    }

    public void setFam_Code(String fam_Code) {
        this.fam_Code = fam_Code;
    }

    public String getFam_Libelle() {
        return fam_Libelle;
    }

    public void setFam_Libelle(String fam_Libelle) {
        this.fam_Libelle = fam_Libelle;
    }
    
    
}
