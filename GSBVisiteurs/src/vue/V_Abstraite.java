/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import javax.swing.JPanel;
import ctrl.C_Abstrait;

/**
 *
 * @author btssio
 */
public class V_Abstraite extends JPanel{
        protected C_Abstrait controleur=null;
    
    public V_Abstraite(C_Abstrait ctrl) {
        this.controleur = ctrl;
    }    
    
}
