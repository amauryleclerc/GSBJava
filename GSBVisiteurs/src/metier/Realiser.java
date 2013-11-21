/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Realiser {
    Activite_Compl activite_Compl;
    Visiteur visiteur;
    Float rea_MttFrais;

    public Realiser(Activite_Compl activite_Compl, Visiteur visiteur, Float rea_MttFrais) {
        this.activite_Compl = activite_Compl;
        this.visiteur = visiteur;
        this.rea_MttFrais = rea_MttFrais;
    }

    @Override
    public String toString() {
        return "Realiser{" + "activite_Compl=" + activite_Compl + ", visiteur=" + visiteur + ", rea_MttFrais=" + rea_MttFrais + '}';
    }

    public Activite_Compl getActivite_Compl() {
        return activite_Compl;
    }

    public void setActivite_Compl(Activite_Compl activite_Compl) {
        this.activite_Compl = activite_Compl;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Float getRea_MttFrais() {
        return rea_MttFrais;
    }

    public void setRea_MttFrais(Float rea_MttFrais) {
        this.rea_MttFrais = rea_MttFrais;
    }
    
    
    
}
