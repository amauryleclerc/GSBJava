/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author btssio
 */
public class Medicament {
    String med_DepotLegal;
    String med_NomCommercial;
    Famille famille;
    String med_Composition;
    String med_Effets;
    String med_ContreIndic;
    Float med_PricEchantillon;

    public Medicament(String med_DepotLegal, String med_NomCommercial, Famille famille, String med_Composition, String med_Effets, String med_ContreIndic, Float med_PricEchantillon) {
        this.med_DepotLegal = med_DepotLegal;
        this.med_NomCommercial = med_NomCommercial;
        this.famille = famille;
        this.med_Composition = med_Composition;
        this.med_Effets = med_Effets;
        this.med_ContreIndic = med_ContreIndic;
        this.med_PricEchantillon = med_PricEchantillon;
    }

    @Override
    public String toString() {
        return "Medicament{" + "med_DepotLegal=" + med_DepotLegal + ", med_NomCommercial=" + med_NomCommercial + ", famille=" + famille + ", med_Composition=" + med_Composition + ", med_Effets=" + med_Effets + ", med_ContreIndic=" + med_ContreIndic + ", med_PricEchantillon=" + med_PricEchantillon + '}';
    }

    public String getMed_DepotLegal() {
        return med_DepotLegal;
    }

    public void setMed_DepotLegal(String med_DepotLegal) {
        this.med_DepotLegal = med_DepotLegal;
    }

    public String getMed_NomCommercial() {
        return med_NomCommercial;
    }

    public void setMed_NomCommercial(String med_NomCommercial) {
        this.med_NomCommercial = med_NomCommercial;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public String getMed_Composition() {
        return med_Composition;
    }

    public void setMed_Composition(String med_Composition) {
        this.med_Composition = med_Composition;
    }

    public String getMed_Effets() {
        return med_Effets;
    }

    public void setMed_Effets(String med_Effets) {
        this.med_Effets = med_Effets;
    }

    public String getMed_ContreIndic() {
        return med_ContreIndic;
    }

    public void setMed_ContreIndic(String med_ContreIndic) {
        this.med_ContreIndic = med_ContreIndic;
    }

    public Float getMed_PricEchantillon() {
        return med_PricEchantillon;
    }

    public void setMed_PricEchantillon(Float med_PricEchantillon) {
        this.med_PricEchantillon = med_PricEchantillon;
    }
    
    
    
    
    
}
