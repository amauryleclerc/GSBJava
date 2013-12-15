/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Praticien {
    int pra_Num;
    String pra_Nom;
    String pra_Prenom;
    String pra_Adresse;
    String pra_Cp;
    String pra_Ville;
    Float pra_CoefNotoriete;
    Type_Praticien type_Practicien;

    public Praticien(int pra_Num, String pra_Nom, String pra_Prenom, String pra_Adresse, String pra_Cp, String pra_Ville, Float pra_CoefNotoriete, Type_Praticien type_Practicien) {
        this.pra_Num = pra_Num;
        this.pra_Nom = pra_Nom;
        this.pra_Prenom = pra_Prenom;
        this.pra_Adresse = pra_Adresse;
        this.pra_Cp = pra_Cp;
        this.pra_Ville = pra_Ville;
        this.pra_CoefNotoriete = pra_CoefNotoriete;
        this.type_Practicien = type_Practicien;
    }

    @Override
    public String toString() {
        return pra_Num + " " + pra_Nom + " " + pra_Prenom;
    }

    public int getPra_Num() {
        return pra_Num;
    }

    public void setPra_Num(int pra_Num) {
        this.pra_Num = pra_Num;
    }

    public String getPra_Nom() {
        return pra_Nom;
    }

    public void setPra_Nom(String pra_Nom) {
        this.pra_Nom = pra_Nom;
    }

    public String getPra_Prenom() {
        return pra_Prenom;
    }

    public void setPra_Prenom(String pra_Prenom) {
        this.pra_Prenom = pra_Prenom;
    }

    public String getPra_Adresse() {
        return pra_Adresse;
    }

    public void setPra_Adresse(String pra_Adresse) {
        this.pra_Adresse = pra_Adresse;
    }

    public String getPra_Cp() {
        return pra_Cp;
    }

    public void setPra_Cp(String pra_Cp) {
        this.pra_Cp = pra_Cp;
    }

    public String getPra_Ville() {
        return pra_Ville;
    }

    public void setPra_Ville(String pra_Ville) {
        this.pra_Ville = pra_Ville;
    }

    public Float getPra_CoefNotoriete() {
        return pra_CoefNotoriete;
    }

    public void setPra_CoefNotoriete(Float pra_CoefNotoriete) {
        this.pra_CoefNotoriete = pra_CoefNotoriete;
    }

    public Type_Praticien getType_Practicien() {
        return type_Practicien;
    }

    public void setType_Practicien(Type_Praticien type_Practicien) {
        this.type_Practicien = type_Practicien;
    }
    
    
}
