/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Type_Individu {
    String tin_Code;
    String tin_Libelle;

    public Type_Individu(String tin_Code, String tin_Libelle) {
        this.tin_Code = tin_Code;
        this.tin_Libelle = tin_Libelle;
    }

    @Override
    public String toString() {
        return "Type_Individu{" + "tin_Code=" + tin_Code + ", tin_Libelle=" + tin_Libelle + '}';
    }

    public String getTin_Code() {
        return tin_Code;
    }

    public void setTin_Code(String tin_Code) {
        this.tin_Code = tin_Code;
    }

    public String getTin_Libelle() {
        return tin_Libelle;
    }

    public void setTin_Libelle(String tin_Libelle) {
        this.tin_Libelle = tin_Libelle;
    }
    
    
    
}
