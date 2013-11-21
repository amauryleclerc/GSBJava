/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Visiteur {
    String vis_Matricule;
    String vis_Nom;
    String vis_Prenom;
    String vis_Adresse;
    String vis_Cp;
    String vis_Ville;
    String vis_DateEmbauche;
    Labo labo;
    Secteur secteur;

    public Visiteur(String vis_Matricule, String vis_Nom, String vis_Prenom, String vis_Adresse, String vis_Cp, String vis_Ville, String vis_DateEmbauche, Labo labo, Secteur secteur) {
        this.vis_Matricule = vis_Matricule;
        this.vis_Nom = vis_Nom;
        this.vis_Prenom = vis_Prenom;
        this.vis_Adresse = vis_Adresse;
        this.vis_Cp = vis_Cp;
        this.vis_Ville = vis_Ville;
        this.vis_DateEmbauche = vis_DateEmbauche;
        this.labo = labo;
        this.secteur = secteur;
    }

    @Override
    public String toString() {
        return "Visiteur{" + "vis_Matricule=" + vis_Matricule + ", vis_Nom=" + vis_Nom + ", vis_Prenom=" + vis_Prenom + ", vis_Adresse=" + vis_Adresse + ", vis_Cp=" + vis_Cp + ", vis_Ville=" + vis_Ville + ", vis_DateEmbauche=" + vis_DateEmbauche + ", labo=" + labo + ", secteur=" + secteur + '}';
    }

    public String getVis_Matricule() {
        return vis_Matricule;
    }

    public void setVis_Matricule(String vis_Matricule) {
        this.vis_Matricule = vis_Matricule;
    }

    public String getVis_Nom() {
        return vis_Nom;
    }

    public void setVis_Nom(String vis_Nom) {
        this.vis_Nom = vis_Nom;
    }

    public String getVis_Prenom() {
        return vis_Prenom;
    }

    public void setVis_Prenom(String vis_Prenom) {
        this.vis_Prenom = vis_Prenom;
    }

    public String getVis_Adresse() {
        return vis_Adresse;
    }

    public void setVis_Adresse(String vis_Adresse) {
        this.vis_Adresse = vis_Adresse;
    }

    public String getVis_Cp() {
        return vis_Cp;
    }

    public void setVis_Cp(String vis_Cp) {
        this.vis_Cp = vis_Cp;
    }

    public String getVis_Ville() {
        return vis_Ville;
    }

    public void setVis_Ville(String vis_Ville) {
        this.vis_Ville = vis_Ville;
    }

    public String getVis_DateEmbauche() {
        return vis_DateEmbauche;
    }

    public void setVis_DateEmbauche(String vis_DateEmbauche) {
        this.vis_DateEmbauche = vis_DateEmbauche;
    }

    public Labo getLabo() {
        return labo;
    }

    public void setLabo(Labo labo) {
        this.labo = labo;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
    
    
}
