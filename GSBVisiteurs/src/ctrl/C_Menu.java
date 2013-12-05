package ctrl;

import javax.swing.JOptionPane;
import vue.V_Menu;

/**
 * Contrôleur de la fenêtre VueMenu
 * @author nbourgeois
 * @version 1 20 novembre 2013
 */

public class C_Menu extends C_Abstrait {

    public C_Menu(C_Principal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new V_Menu(this);
    }

    /**
     * clic sur la commande Quitter du menu Fichier Le contrôleur délègue
     * l'action au contrôleur frontal
     */
    public void fichierQuitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Ambulances", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            this.getCtrlPrincipal().action(EnumAction.MENU_FICHIER_QUITTER);
        }
    }

    /**
     * clic sur la commande Ajouter du menu presence Le contrôleur délègue
     * l'action au contrôleur frontal
     */
    public void medicament() {
        this.getCtrlPrincipal().action(EnumAction.MENU_MEDICAMENT);
    }

    @Override
    public V_Menu getVue() {
        return (V_Menu) vue;
    }
}
