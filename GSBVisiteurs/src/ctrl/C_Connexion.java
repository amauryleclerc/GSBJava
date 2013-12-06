/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ctrl;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dao.*;
import modele.metier.*;
import vue.V_Connexion;

/**
 * Contrôleur de la fenêtre VuePresence
 *
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */
public class C_Connexion extends C_Abstrait {
    
   private DaoPraticien daoPraticien = new DaoPraticien();


    public C_Connexion(C_Principal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new V_Connexion(this);
        actualiser();
    }
    public void seConnecter() {
        // Déclarations de variables locales
        int nb = 0; // valeur de retour de l'opération de mise à jour
        String msg = ""; // message à afficher à l'issue de la mise à jour
        int typeMsg = 0;
        String login = null;
        String password =null;
        //récupération des valeur du formulaire
        login = getVue().getTxtLogin().getText();
        password = getVue().getTxtPassword().getText();
          //(CodeEtat) getVue().getjComboBoxEtatPresence().getSelectedItem();

            try {
                if(!daoPraticien.verification(login, password)){
                 msg = "mauvais login ou mot de passe";
                typeMsg = JOptionPane.ERROR_MESSAGE;
                } else {
                ctrlPrincipal.action(EnumAction.MENU_RAPPORT);
            }
            } catch (DaoException ex) {
                msg = "CtrlConnexion - seConnecter() - " + ex.getMessage();
                typeMsg = JOptionPane.ERROR_MESSAGE;
            } 
       
     
        
    }

    public final void actualiser() {
    /*    try {
            chargerListeEquipiers();
            chargerLesCodesEtat();
        } catch (DaoException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlPresence - actualiser - " + ex.getMessage(), "Saisie des présences", JOptionPane.ERROR_MESSAGE);
        }*/
    }

    /**
     * presenceEnregistrer réaction au clic sur le bouton VALIDER de la vue
     * VuePresences
     */
    /*
    public void presenceEnregistrer() {
        // Déclarations de variables locales
        int nb = 0; // valeur de retour de l'opération de mise à jour
        String msg = ""; // message à afficher à l'issue de la mise à jour
        int typeMsg = 0;
        // Lire et contrôler les données du formulaire
        // récupérer l'Equipier sélectionné
        Equipier equipierSelect = (Equipier) getVue().getjComboBoxEquipier().getSelectedItem();
        Jour dateSelect = new Jour(getVue().getjDateChooserDatePresence().getDate().getTime());
        CodeEtat etatPresenceSelect = (CodeEtat) getVue().getjComboBoxEtatPresence().getSelectedItem();
        if (equipierSelect == null || dateSelect == null || etatPresenceSelect == null) {
            //Saisie incomplète
            msg = "Saisie incomplète";
            typeMsg = JOptionPane.WARNING_MESSAGE;
        } else {
            try {
                // n° d'identification de cet équipier
                int id = equipierSelect.getId();
                // récupérer la liste des présences actuelles pour cet équipier
                equipierSelect.setLesPresences(daoPresence.getListePresences(id));
                // rechercher la date saisie dans cette liste
                Presence presenceRecherchee = equipierSelect.rechercherUnePresence(dateSelect);
                if (presenceRecherchee != null) {
                    // si elle est déjà présente, la mettre à jour
                    presenceRecherchee.setEtatPresence(etatPresenceSelect);
                    nb = daoPresence.update(id, presenceRecherchee);
                    msg = "Présence mise à jour";
                    typeMsg = JOptionPane.INFORMATION_MESSAGE;
                } else {
                    // sinon, l'ajouter
                    presenceRecherchee = new Presence(dateSelect, etatPresenceSelect);
                    nb = daoPresence.create(id, presenceRecherchee);
                    msg = "Présence ajoutée";
                    typeMsg = JOptionPane.INFORMATION_MESSAGE;
                }
                // On vérifie qu'au moins un enregistrement a été ajouté ou modifié
                if (nb == 0) {
                    msg = "La mise à jour a échoué";
                    typeMsg = JOptionPane.WARNING_MESSAGE;
                }

            } catch (DaoException ex) {
                msg = "CtrlPresence - presenceEnregistrer() - " + ex.getMessage();
                typeMsg = JOptionPane.ERROR_MESSAGE;
            }
            JOptionPane.showMessageDialog(getVue(), msg, "Saisie des présences", typeMsg);
        }
    }
*/
    /**
     * presenceAnnuler réaction au clic sur le bouton ANNULER de la vue Le
     * contrôle est rendu au contrôleur frontal
     */
    public void medicamentQuitter() {
        this.getCtrlPrincipal().action(EnumAction.MEDICAMENT_QUITTER);
    }

    @Override
    public V_Connexion getVue() {
        return (V_Connexion) vue;
    }
    
}
