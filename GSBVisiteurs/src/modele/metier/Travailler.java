/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.util.Date;

/**
 *
 * @author btssio
 */
public class Travailler {
    Visiteur visiteur;
    Date jjmmaa;
    Region region;
    String tra_Role;

    public Travailler(Visiteur visiteur, Date jjmmaa, Region region, String tra_Role) {
        this.visiteur = visiteur;
        this.jjmmaa = jjmmaa;
        this.region = region;
        this.tra_Role = tra_Role;
    }

    @Override
    public String toString() {
        return "Travailler{" + "visiteur=" + visiteur + ", jjmmaa=" + jjmmaa + ", region=" + region + ", tra_Role=" + tra_Role + '}';
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Date getJjmmaa() {
        return jjmmaa;
    }

    public void setJjmmaa(Date jjmmaa) {
        this.jjmmaa = jjmmaa;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getTra_Role() {
        return tra_Role;
    }

    public void setTra_Role(String tra_Role) {
        this.tra_Role = tra_Role;
    }
    
    
    
}
