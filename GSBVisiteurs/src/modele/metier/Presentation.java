/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Presentation {
    String pre_Code;
    String pre_Libelle;

    public Presentation(String pre_Code, String pre_Libelle) {
        this.pre_Code = pre_Code;
        this.pre_Libelle = pre_Libelle;
    }

    @Override
    public String toString() {
        return "Presentation{" + "pre_Code=" + pre_Code + ", pre_Libelle=" + pre_Libelle + '}';
    }

    public String getPre_Code() {
        return pre_Code;
    }

    public void setPre_Code(String pre_Code) {
        this.pre_Code = pre_Code;
    }

    public String getPre_Libelle() {
        return pre_Libelle;
    }

    public void setPre_Libelle(String pre_Libelle) {
        this.pre_Libelle = pre_Libelle;
    }
    
    
    
}
