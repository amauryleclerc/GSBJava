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
public class Activite_Compl {
    private String ac_Num;
    private Date ac_Date;
    private String ac_Lieu;
    private String ac_Theme;
    private String ac_Motif;

    public Activite_Compl(String ac_Num, Date ac_Date, String ac_Lieu, String ac_Theme, String ac_Motif) {
        this.ac_Num = ac_Num;
        this.ac_Date = ac_Date;
        this.ac_Lieu = ac_Lieu;
        this.ac_Theme = ac_Theme;
        this.ac_Motif = ac_Motif;
    }

    @Override
    public String toString() {
        return "Activite_Compl{" + "ac_Num=" + ac_Num + ", ac_Date=" + ac_Date + ", ac_Lieu=" + ac_Lieu + ", ac_Theme=" + ac_Theme + ", ac_Motif=" + ac_Motif + '}';
    }
    

    public String getAc_Num() {
        return ac_Num;
    }

    public void setAc_Num(String ac_Num) {
        this.ac_Num = ac_Num;
    }

    public Date getAc_Date() {
        return ac_Date;
    }

    public void setAc_Date(Date ac_Date) {
        this.ac_Date = ac_Date;
    }

    public String getAc_Lieu() {
        return ac_Lieu;
    }

    public void setAc_Lieu(String ac_Lieu) {
        this.ac_Lieu = ac_Lieu;
    }

    public String getAc_Theme() {
        return ac_Theme;
    }

    public void setAc_Theme(String ac_Theme) {
        this.ac_Theme = ac_Theme;
    }

    public String getAc_Motif() {
        return ac_Motif;
    }

    public void setAc_Motif(String ac_Motif) {
        this.ac_Motif = ac_Motif;
    }
    
    
    
}
