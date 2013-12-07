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
import vue.V_Praticiens;

/**
 * Contrôleur de la fenêtre VuePresence
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class C_Praticien extends C_Abstrait {
    
   private DaoPraticien daoPraticien = new DaoPraticien();


    public C_Praticien(C_Principal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new V_Praticiens(this);
        actualiser();
    }

    public final void actualiser() {
        try {
            chargerListePraticien();
          praticienSelectionner();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlPraticien - actualiser - " + ex.getMessage(), "Saisie des Médicaments", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * presenceEnregistrer réaction au clic sur le bouton VALIDER de la vue
     * VuePresences
     */
    public void praticienSelectionner(){
               int nb = 0; // valeur de retour de l'opération de mise à jour
        String msg = ""; // message à afficher à l'issue de la mise à jour
        int typeMsg = 0;
         // Lire et contrôler les données du formulaire
        Praticien praticienSelect =(Praticien) getVue().getCbChercher().getSelectedItem();
    if (praticienSelect ==null){
        //Saisie incomplète
     
            msg = "Saisie incomplète";
            typeMsg = JOptionPane.WARNING_MESSAGE;
        } else {
        getVue().getTxtAdresse().setText(praticienSelect.getPra_Adresse());
        getVue().getTxtCodePostal().setText(praticienSelect.getPra_Cp());
        getVue().getTxtCoeffNotoriete().setText(praticienSelect.getPra_CoefNotoriete().toString());
        getVue().getTxtLieuExercice().setText(praticienSelect.getType_Practicien().getTyp_Lieu());
        getVue().getTxtNom().setText(praticienSelect.getPra_Nom());
        getVue().getTxtNumero().setText(String.valueOf(praticienSelect.getPra_Num()));
        getVue().getTxtPrenom().setText(praticienSelect.getPra_Prenom());
        getVue().getTxtVille().setText(praticienSelect.getPra_Ville());
             
    }
    }
    /**
     *
     */
    public void suivant(){
         int index = getVue().getCbChercher().getSelectedIndex()+1;
         if(index== getVue().getCbChercher().getItemCount()) index=0;
         getVue().getCbChercher().setSelectedIndex(index);
        // combo.hidePopup();
    }
     public void precedant(){
         int index = getVue().getCbChercher().getSelectedIndex()-1;
         if(index== -1) index=getVue().getCbChercher().getItemCount()-1;
         getVue().getCbChercher().setSelectedIndex(index);
        // combo.hidePopup();
    }
      
 
    /**
     * presenceAnnuler réaction au clic sur le bouton ANNULER de la vue Le
     * contrôle est rendu au contrôleur frontal
     */
    public void praticienQuitter() {
        this.getCtrlPrincipal().action(EnumAction.PRATICIEN_QUITTER);
    }
    
    /**
     * chargerListeEquipiers renseigner le modèle du composant jComboBoxEquipier
     * à partir de la base de données
     *
     * @throws DaoException
     */
    /* */
    private void chargerListePraticien() throws DaoException {
        List<Praticien> lesPraticiens = daoPraticien.getAll();
        getVue().getMcbChercher().removeAllElements();
        for (Praticien unPraticien : lesPraticiens) {
            getVue().getMcbChercher().addElement(unPraticien);
        }
    }

    @Override
    public V_Praticiens getVue() {
        return (V_Praticiens) vue;
    }
    
}
