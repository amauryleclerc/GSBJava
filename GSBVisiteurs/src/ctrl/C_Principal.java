/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;


import static ctrl.EnumAction.*;
import javax.swing.JOptionPane;
import modele.jdbc.Jdbc;
import vue.Fenetre;


/**
 *
 * @author btssio
 */
public class C_Principal {
    

    private Fenetre fenetre =  new Fenetre();
    private C_Medicament ctrlMedicament = null;
    private C_Praticien ctrlPraticien = null;
    private C_Menu ctrlMenu = null;
    private C_Connexion ctrlConnexion = null;
    

    /**
     * action par défaut action au démarrage de l'application
     */
    public void action() {
        if (ctrlConnexion == null) {
            ctrlConnexion = new C_Connexion(this);
        }
        fenetre.setEnabled(true);
        fenetre.setContentPane(ctrlConnexion.getVue());
        fenetre.setVisible(true);
    }

    public void action(EnumAction action) {
        switch (action) {
            case MENU_MEDICAMENT: // activation de vueMedicament depuis vueMenu
                menuMedicament();
                break;
            case MEDICAMENT_QUITTER:    // retour à vueMenu depuis la vueMedicament
                medicamentQuitter();
                break;
            case MENU_PRATICIEN: 
                menuPraticien();
                break;
            case PRATICIEN_QUITTER:   
                medicamentQuitter();
                break;
           case MENU_VISITEUR: 
                menuMedicament();
                break;
            case VISITEUR_QUITTER:   
                medicamentQuitter();
                break;
             case MENU_RAPPORT: 
                menuMedicament();
                break;
            case RAPPORT_QUITTER:   
                medicamentQuitter();
                break;
             case CONNEXION:   
                connexionQuitter();
                break;
            case MENU_FICHIER_QUITTER: // fin de l'application depuis vueMenu
                menuFichierQuitter();
                break;
        }

    }

    /**
     * Fin définitive de l'application La demande de confirmation est gérée par
     * le contrôleur spécialisé
     */
    private void menuFichierQuitter() {
        try {
            Jdbc.getInstance().deconnecter();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.exit(0);
        }
    }

    /**
     * Transition vueMenu / vuePresence
     */
    private void menuMedicament() {
        if (ctrlMedicament == null) {
            ctrlMedicament = new C_Medicament(this);
        } else {
            // si la le contrôleur et sa vue existent déjà
            // il faut rafraîchir le contenu à partir de la base de données
            ctrlMedicament.actualiser();
        }
        // vuPresence est une fenêtre modale :
        // -> vueMenu reste visible, mais n'est pas active
        fenetre.setVisible(false);
        fenetre.setContentPane(ctrlMedicament.getVue());
        fenetre.setVisible(true);
    }

    /**
     * Transition vuePresence / vueMenu
     */
    private void medicamentQuitter() {
        if (ctrlMenu == null) {
            ctrlMenu = new C_Menu(this);
        }
        fenetre.setVisible(false);
        fenetre.setContentPane(ctrlMenu.getVue());
        fenetre.setVisible(true);
    }
    private void menuPraticien() {
        if (ctrlPraticien == null) {
            ctrlPraticien = new C_Praticien(this);
        } else {
            // si la le contrôleur et sa vue existent déjà
            // il faut rafraîchir le contenu à partir de la base de données
            ctrlPraticien.actualiser();
        }
        // vuPresence est une fenêtre modale :
        // -> vueMenu reste visible, mais n'est pas active
        fenetre.setVisible(false);
        fenetre.setContentPane(ctrlPraticien.getVue());
        fenetre.setVisible(true);
    }

    /**
     * Transition vuePresence / vueMenu
     */
    private void PraticienQuitter() {
        if (ctrlMenu == null) {
            ctrlMenu = new C_Menu(this);
        }
        fenetre.setVisible(false);
        fenetre.setContentPane(ctrlMenu.getVue());
        fenetre.setVisible(true);
    }
        private void connexionQuitter() {
        if (ctrlMenu == null) {
            ctrlMenu = new C_Menu(this);
        }
        fenetre.setVisible(false);
        fenetre.setContentPane(ctrlMenu.getVue());
        fenetre.setVisible(true);
    }
    
}

