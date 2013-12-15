/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ctrl;

import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.*;
import modele.metier.*;
import vue.V_RapportDeVisite;
import vue.V_Visiteur;

/**
 * Contrôleur de la fenêtre VuePresence
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class C_Rapport extends C_Abstrait {
   
   private DaoRapport daoRapport = new DaoRapport();
   private DaoPraticien daoPraticien = new DaoPraticien();


    public C_Rapport(C_Principal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new V_RapportDeVisite(this);
        actualiser();
    }

    public final void actualiser() {
        try {
            chargerListeRapport();
            rapportSelectionner();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlVisiteur - actualiser - " + ex.getMessage(), "Saisie des Médicaments", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * presenceEnregistrer réaction au clic sur le bouton VALIDER de la vue
     * VuePresences
     */
    public void rapportSelectionner(){
               int nb = 0; // valeur de retour de l'opération de mise à jour
        String msg = ""; // message à afficher à l'issue de la mise à jour
        int typeMsg = 0;
         // Lire et contrôler les données du formulaire
        Rapport_Visite rapportSelect =(Rapport_Visite) getVue().getCbRapport().getSelectedItem();
    if (rapportSelect ==null){
        //Saisie incomplète
     
            msg = "Saisie incomplète";
            typeMsg = JOptionPane.WARNING_MESSAGE;
        } else {
               getVue().getTxtBilan().setText(rapportSelect.getRap_Bilan());
               getVue().getTxtDateRapport().setText(rapportSelect.getRap_Date().toString());
               getVue().getTxtMotifVisite().setText(rapportSelect.getRap_Motif());
                getVue().getMcbPraticien().setSelectedItem(rapportSelect.getPracticien());

    }
    }
    /**
     *
     */
    public void suivant(){
         int index = getVue().getCbRapport().getSelectedIndex()+1;
         if(index== getVue().getCbRapport().getItemCount()) index=0;
         getVue().getCbRapport().setSelectedIndex(index);
        // combo.hidePopup();
    }
     public void precedant(){
         int index = getVue().getCbRapport().getSelectedIndex()-1;
         if(index== -1) index=getVue().getCbRapport().getItemCount()-1;
         getVue().getCbRapport().setSelectedIndex(index);
        // combo.hidePopup();
    }
      
 
    /**
     * presenceAnnuler réaction au clic sur le bouton ANNULER de la vue Le
     * contrôle est rendu au contrôleur frontal
     */
    public void rapportQuitter() {
        this.getCtrlPrincipal().action(EnumAction.RAPPORT_QUITTER);
    }
    
    /**
     * chargerListeEquipiers renseigner le modèle du composant jComboBoxEquipier
     * à partir de la base de données
     *
     * @throws DaoException
     */
    /* */
    private void chargerListeRapport() throws DaoException {
        List<Rapport_Visite> lesRapports = daoRapport.getAll();
        getVue().getMcbRapport().removeAllElements();
        for (Rapport_Visite unRapport : lesRapports) {
            getVue().getMcbRapport().addElement(unRapport);
        }
    }
        private void chargerListePratcien() throws DaoException {
        List<Praticien> lesPraticiens = daoPraticien.getAll();
        getVue().getMcbPraticien().removeAllElements();
        for (Praticien unPraticien : lesPraticiens) {
            getVue().getMcbPraticien().addElement(unPraticien);
        }
    }
    
    

    @Override
    public V_RapportDeVisite getVue() {
        return (V_RapportDeVisite) vue;
    }
    
}
