/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Constituer {
    Medicament medicament;
    Composant composant;
    String cst_Qte;

    public Constituer(Medicament medicament, Composant composant, String cst_Qte) {
        this.medicament = medicament;
        this.composant = composant;
        this.cst_Qte = cst_Qte;
    }

    @Override
    public String toString() {
        return "Constituer{" + "medicament=" + medicament + ", composant=" + composant + ", cst_Qte=" + cst_Qte + '}';
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Composant getComposant() {
        return composant;
    }

    public void setComposant(Composant composant) {
        this.composant = composant;
    }

    public String getCst_Qte() {
        return cst_Qte;
    }

    public void setCst_Qte(String cst_Qte) {
        this.cst_Qte = cst_Qte;
    }
    
    
            
    
}
