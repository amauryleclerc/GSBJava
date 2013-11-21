/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Date;

/**
 *
 * @author btssio
 */
public class Rapport_Visite {
    Visiteur visiteur;
    int rap_Num;
    Praticien practicien;
    Date rap_Date;
    String rap_Bilan;
    String rap_Motif;

    public Rapport_Visite(Visiteur visiteur, int rap_Num, Praticien practicien, Date rap_Date, String rap_Bilan, String rap_Motif) {
        this.visiteur = visiteur;
        this.rap_Num = rap_Num;
        this.practicien = practicien;
        this.rap_Date = rap_Date;
        this.rap_Bilan = rap_Bilan;
        this.rap_Motif = rap_Motif;
    }

    @Override
    public String toString() {
        return "Rapport_Visite{" + "visiteur=" + visiteur + ", rap_Num=" + rap_Num + ", practicien=" + practicien + ", rap_Date=" + rap_Date + ", rap_Bilan=" + rap_Bilan + ", rap_Motif=" + rap_Motif + '}';
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public int getRap_Num() {
        return rap_Num;
    }

    public void setRap_Num(int rap_Num) {
        this.rap_Num = rap_Num;
    }

    public Praticien getPracticien() {
        return practicien;
    }

    public void setPracticien(Praticien practicien) {
        this.practicien = practicien;
    }

    public Date getRap_Date() {
        return rap_Date;
    }

    public void setRap_Date(Date rap_Date) {
        this.rap_Date = rap_Date;
    }

    public String getRap_Bilan() {
        return rap_Bilan;
    }

    public void setRap_Bilan(String rap_Bilan) {
        this.rap_Bilan = rap_Bilan;
    }

    public String getRap_Motif() {
        return rap_Motif;
    }

    public void setRap_Motif(String rap_Motif) {
        this.rap_Motif = rap_Motif;
    }
    
    
    
}
