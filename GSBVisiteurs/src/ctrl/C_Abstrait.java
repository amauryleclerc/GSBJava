package ctrl;

import vue.V_Abstraite;

/**
 * C_Abstrait
 * modèle de contrôleur de base
 * chaque contrôleur possède :
 * - une vue
 * - une liaison vers le contrôleur principal
 * @author nbourgeois
 * @version 22 novembre 2013
 */
public abstract class C_Abstrait {
    
    protected V_Abstraite vue = null;
    protected C_Principal ctrlPrincipal = null;

    protected C_Abstrait(C_Principal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
     
    public V_Abstraite getVue() {
        return vue;
    }

    public void setVue(V_Abstraite vue) {
        this.vue = vue;
    }

    public C_Principal getCtrlPrincipal() {
        return (C_Principal)ctrlPrincipal;
    }

    public void setCtrlPrincipal(C_Principal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
    

}
