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
import vue.V_Medicament;

/**
 * Contrôleur de la fenêtre VuePresence
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class C_Medicament extends C_Abstrait {
    
   private DaoMedicament daoMedicament = new DaoMedicament();


    public C_Medicament(C_Principal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new V_Medicament(this);
        actualiser();
    }

    public final void actualiser() {
        try {
            chargerListeMedicament();
          medicamentSelectionner();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlMedicament - actualiser - " + ex.getMessage(), "Saisie des Médicaments", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * presenceEnregistrer réaction au clic sur le bouton VALIDER de la vue
     * VuePresences
     */
    public void medicamentSelectionner(){
               int nb = 0; // valeur de retour de l'opération de mise à jour
        String msg = ""; // message à afficher à l'issue de la mise à jour
        int typeMsg = 0;
         // Lire et contrôler les données du formulaire
        Medicament medicamentSelect =(Medicament) getVue().getCbNomCommercial().getSelectedItem();
    if (medicamentSelect ==null){
        //Saisie incomplète
     
            msg = "Saisie incomplète";
            typeMsg = JOptionPane.WARNING_MESSAGE;
        } else {
        getVue().getTxtCode().setText(medicamentSelect.getMed_DepotLegal());
        getVue().getTxtComposition().setText(medicamentSelect.getMed_Composition());
        getVue().getTxtContreIndications().setText(medicamentSelect.getMed_ContreIndic());
        getVue().getTxtEffetsIndesirables().setText(medicamentSelect.getMed_Effets());
        getVue().getTxtFamille().setText(medicamentSelect.getFamille().getFam_Libelle());
        getVue().getTxtPrixEchantillon().setText(medicamentSelect.getMed_PricEchantillon().toString());
               
            
    }
    }
    /**
     *
     */
    public void suivant(){
         int index = getVue().getCbNomCommercial().getSelectedIndex()+1;
         if(index== getVue().getCbNomCommercial().getItemCount()) index=0;
         getVue().getCbNomCommercial().setSelectedIndex(index);
        // combo.hidePopup();
    }
     public void precedant(){
         int index = getVue().getCbNomCommercial().getSelectedIndex()-1;
         if(index== -1) index=getVue().getCbNomCommercial().getItemCount()-1;
         getVue().getCbNomCommercial().setSelectedIndex(index);
        // combo.hidePopup();
    }
      
 
    /**
     * presenceAnnuler réaction au clic sur le bouton ANNULER de la vue Le
     * contrôle est rendu au contrôleur frontal
     */
    public void medicamentQuitter() {
        this.getCtrlPrincipal().action(EnumAction.MEDICAMENT_QUITTER);
    }
    
    /**
     * chargerListeEquipiers renseigner le modèle du composant jComboBoxEquipier
     * à partir de la base de données
     *
     * @throws DaoException
     */
    /* */
    private void chargerListeMedicament() throws DaoException {
        List<Medicament> lesMedicaments = daoMedicament.getAll();
        getVue().getMcbNomCommercial().removeAllElements();
        for (Medicament unMedicament : lesMedicaments) {
            getVue().getMcbNomCommercial().addElement(unMedicament);
        }
    }

    @Override
    public V_Medicament getVue() {
        return (V_Medicament) vue;
    }
    
}
