/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author btssio
 */
public class Prescrire {
    Medicament medicament;
    Type_Individu type_Individu;
    Dosage dosage;
    String pre_Posologie;

    public Prescrire(Medicament medicament, Type_Individu type_Individu, Dosage dosage, String pre_Posologie) {
        this.medicament = medicament;
        this.type_Individu = type_Individu;
        this.dosage = dosage;
        this.pre_Posologie = pre_Posologie;
    }

    @Override
    public String toString() {
        return "Prescrire{" + "medicament=" + medicament + ", type_Individu=" + type_Individu + ", dosage=" + dosage + ", pre_Posologie=" + pre_Posologie + '}';
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Type_Individu getType_Individu() {
        return type_Individu;
    }

    public void setType_Individu(Type_Individu type_Individu) {
        this.type_Individu = type_Individu;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    public String getPre_Posologie() {
        return pre_Posologie;
    }

    public void setPre_Posologie(String pre_Posologie) {
        this.pre_Posologie = pre_Posologie;
    }
    
    
    
}
