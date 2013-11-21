/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Interagir {
    Medicament med_Perturbateur;
    Medicament med_Perturbe;

    public Interagir(Medicament med_Perturbateur, Medicament med_Perturbe) {
        this.med_Perturbateur = med_Perturbateur;
        this.med_Perturbe = med_Perturbe;
    }

    @Override
    public String toString() {
        return "Interagir{" + "med_Perturbateur=" + med_Perturbateur + ", med_Perturbe=" + med_Perturbe + '}';
    }

    public Medicament getMed_Perturbateur() {
        return med_Perturbateur;
    }

    public void setMed_Perturbateur(Medicament med_Perturbateur) {
        this.med_Perturbateur = med_Perturbateur;
    }

    public Medicament getMed_Perturbe() {
        return med_Perturbe;
    }

    public void setMed_Perturbe(Medicament med_Perturbe) {
        this.med_Perturbe = med_Perturbe;
    }
    
    
    
}
