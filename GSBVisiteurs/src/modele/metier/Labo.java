/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Labo {
    String lab_Code;
    String lab_Nom;
    String lab_ChefVente;

    public Labo(String lab_Code, String lab_Nom, String lab_ChefVente) {
        this.lab_Code = lab_Code;
        this.lab_Nom = lab_Nom;
        this.lab_ChefVente = lab_ChefVente;
    }

    @Override
    public String toString() {
        return lab_Code + " " + lab_Nom;
    }

    public String getLab_Code() {
        return lab_Code;
    }

    public void setLab_Code(String lab_Code) {
        this.lab_Code = lab_Code;
    }

    public String getLab_Nom() {
        return lab_Nom;
    }

    public void setLab_Nom(String lab_Nom) {
        this.lab_Nom = lab_Nom;
    }

    public String getLab_ChefVente() {
        return lab_ChefVente;
    }

    public void setLab_ChefVente(String lab_ChefVente) {
        this.lab_ChefVente = lab_ChefVente;
    }
    
    
}
