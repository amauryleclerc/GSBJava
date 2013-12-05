/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Type_Praticien {
    String typ_Code;
    String typ_Libelle;
    String typ_Lieu;

    public Type_Praticien(String typ_Code, String typ_Libelle, String typ_Lieu) {
        this.typ_Code = typ_Code;
        this.typ_Libelle = typ_Libelle;
        this.typ_Lieu = typ_Lieu;
    }

    @Override
    public String toString() {
        return "Type_Practicien{" + "typ_Code=" + typ_Code + ", typ_Libelle=" + typ_Libelle + ", typ_Lieu=" + typ_Lieu + '}';
    }

    public String getTyp_Code() {
        return typ_Code;
    }

    public void setTyp_Code(String typ_Code) {
        this.typ_Code = typ_Code;
    }

    public String getTyp_Libelle() {
        return typ_Libelle;
    }

    public void setTyp_Libelle(String typ_Libelle) {
        this.typ_Libelle = typ_Libelle;
    }

    public String getTyp_Lieu() {
        return typ_Lieu;
    }

    public void setTyp_Lieu(String typ_Lieu) {
        this.typ_Lieu = typ_Lieu;
    }
    
    
    
}
