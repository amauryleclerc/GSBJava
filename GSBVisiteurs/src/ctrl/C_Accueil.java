/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

/**
 *
 * @author btssio
 */
import java.util.logging.Level;
import java.util.logging.Logger;
import vue.Fenetre;
import vue.V_Connexion;
import vue.V_Visiteur;

public class C_Accueil {

     Fenetre fenetre = new Fenetre();
     V_Connexion vueConnexion = new V_Connexion();
     V_Visiteur vueVisiteur = new V_Visiteur();

    public C_Accueil(){
        fenetre.setContentPane(vueConnexion);
        fenetre.setVisible(true);
    

    }
    
    private void changeVue() {
         try {
             Thread.sleep(2000);
         } catch (InterruptedException ex) {
             Logger.getLogger(C_Accueil.class.getName()).log(Level.SEVERE, null, ex);
         }
         fenetre.setVisible(false);
        fenetre.setContentPane(vueVisiteur);
        fenetre.setVisible(true);
    }


}
