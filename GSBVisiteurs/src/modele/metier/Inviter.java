/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Inviter {
    Activite_Compl activite_Compl;
    Praticien praticien;
    boolean specialisteON;

    public Inviter(Activite_Compl activite_Compl, Praticien praticien, boolean specialisteON) {
        this.activite_Compl = activite_Compl;
        this.praticien = praticien;
        this.specialisteON = specialisteON;
    }

    @Override
    public String toString() {
        return "Inviter{" + "activite_Compl=" + activite_Compl + ", praticien=" + praticien + ", specialisteON=" + specialisteON + '}';
    }

    public Activite_Compl getActivite_Compl() {
        return activite_Compl;
    }

    public void setActivite_Compl(Activite_Compl activite_Compl) {
        this.activite_Compl = activite_Compl;
    }

    public Praticien getPraticien() {
        return praticien;
    }

    public void setPraticien(Praticien praticien) {
        this.praticien = praticien;
    }

    public boolean isSpecialisteON() {
        return specialisteON;
    }

    public void setSpecialisteON(boolean specialisteON) {
        this.specialisteON = specialisteON;
    }
    
    
    
}
