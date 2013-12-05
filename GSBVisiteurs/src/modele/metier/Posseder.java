/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Posseder {
    Praticien practicien;
    Specialiste specialite;
    String pos_Diplome;
    Float pos_CoefPrescription;

    public Posseder(Praticien practicien, Specialiste specialite, String pos_Diplome, Float pos_CoefPrescription) {
        this.practicien = practicien;
        this.specialite = specialite;
        this.pos_Diplome = pos_Diplome;
        this.pos_CoefPrescription = pos_CoefPrescription;
    }

    @Override
    public String toString() {
        return "Posseder{" + "practicien=" + practicien + ", specialite=" + specialite + ", pos_Diplome=" + pos_Diplome + ", pos_CoefPrescription=" + pos_CoefPrescription + '}';
    }

    public Praticien getPracticien() {
        return practicien;
    }

    public void setPracticien(Praticien practicien) {
        this.practicien = practicien;
    }

    public Specialiste getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialiste specialite) {
        this.specialite = specialite;
    }

    public String getPos_Diplome() {
        return pos_Diplome;
    }

    public void setPos_Diplome(String pos_Diplome) {
        this.pos_Diplome = pos_Diplome;
    }

    public Float getPos_CoefPrescription() {
        return pos_CoefPrescription;
    }

    public void setPos_CoefPrescription(Float pos_CoefPrescription) {
        this.pos_CoefPrescription = pos_CoefPrescription;
    }
    
    
    
}
