/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Formuler {
    Medicament medicament;
    Presentation presentation;

    public Formuler(Medicament medicament, Presentation presentation) {
        this.medicament = medicament;
        this.presentation = presentation;
    }

    @Override
    public String toString() {
        return "Formuler{" + "medicament=" + medicament + ", presentation=" + presentation + '}';
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    public Presentation getPresentation() {
        return presentation;
    }

    public void setPresentation(Presentation presentation) {
        this.presentation = presentation;
    }
    
    
    
}
