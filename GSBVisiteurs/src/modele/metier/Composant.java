/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Composant {
    String cmp_Code;
    String cmp_Libelle;

    public Composant(String cmp_Code, String cmp_Libelle) {
        this.cmp_Code = cmp_Code;
        this.cmp_Libelle = cmp_Libelle;
    }

    @Override
    public String toString() {
        return "Composant{" + "cmp_Code=" + cmp_Code + ", cmp_Libelle=" + cmp_Libelle + '}';
    }

    public String getCmp_Code() {
        return cmp_Code;
    }

    public void setCmp_Code(String cmp_Code) {
        this.cmp_Code = cmp_Code;
    }

    public String getCmp_Libelle() {
        return cmp_Libelle;
    }

    public void setCmp_Libelle(String cmp_Libelle) {
        this.cmp_Libelle = cmp_Libelle;
    }
    
    
    
}
