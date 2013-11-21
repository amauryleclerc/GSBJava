/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Offrir {
    Visiteur visiteur;
    Rapport_Visite rapport_visite;
    Medicament medicament;
    int off_Qte;

    public Offrir(Visiteur visiteur, Rapport_Visite rapport_visite, Medicament medicament, int off_Qte) {
        this.visiteur = visiteur;
        this.rapport_visite = rapport_visite;
        this.medicament = medicament;
        this.off_Qte = off_Qte;
    }

    @Override
    public String toString() {
        return "Offrir{" + "visiteur=" + visiteur + ", rapport_visite=" + rapport_visite + ", medicament=" + medicament + ", off_Qte=" + off_Qte + '}';
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Rapport_Visite getRapport_visite() {
        return rapport_visite;
    }

    public void setRapport_visite(Rapport_Visite rapport_visite) {
        this.rapport_visite = rapport_visite;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public int getOff_Qte() {
        return off_Qte;
    }

    public void setOff_Qte(int off_Qte) {
        this.off_Qte = off_Qte;
    }
    
    
}
