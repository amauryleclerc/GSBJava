/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Region {
    String reg_Code;
    String reg_Nom;
    Secteur secteur;

    public Region(String reg_Code, String reg_Nom, Secteur secteur) {
        this.reg_Code = reg_Code;
        this.reg_Nom = reg_Nom;
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Region{" + "reg_Code=" + reg_Code + ", reg_Nom=" + reg_Nom + ", secteur=" + secteur + '}';
    }

    public String getReg_Code() {
        return reg_Code;
    }

    public void setReg_Code(String reg_Code) {
        this.reg_Code = reg_Code;
    }

    public String getReg_Nom() {
        return reg_Nom;
    }

    public void setReg_Nom(String reg_Nom) {
        this.reg_Nom = reg_Nom;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    
}
