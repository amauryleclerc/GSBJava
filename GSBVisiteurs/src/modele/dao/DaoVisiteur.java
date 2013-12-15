/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modele.dao;

import modele.metier.*;
import modele.jdbc.Jdbc;
import java.sql.*;
import java.util.*;

/**
 * Classe DAO pour la classe Visiteur
 */
public class DaoVisiteur implements DaoInterface<Visiteur, Integer> {
     private DaoLabo daoLabo = new DaoLabo();
    /**
     * Non implémenté
     */
    @Override
    public int create(Visiteur unVisiteur) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Lire un enregistrement d'après son identifiant
     *
     * @param identifiant métier de l'objet recherché
     * @return objet métier trouvé, ou null sinon
     * @throws Exception
     */
        public Visiteur getOne(String idVisiteur) throws DaoException {
        Visiteur result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR"
                + " LEFT OUTER JOIN SECTEUR ON SECTEUR.SEC_CODE=VISITEUR.SEC_CODE"
                + " WHERE VIS_MATRICULE=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, idVisiteur);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoVisiteur::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        return (result);
    }

    /**
     * getAll
     *
     * @return ArrayList de l'ensemble des occurences d'equipiers de la table
     * EQUIPIER
     */
    @Override
    public ArrayList<Visiteur> getAll() throws DaoException {
        ArrayList<Visiteur> result = new ArrayList<Visiteur>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR"
                + " LEFT OUTER JOIN SECTEUR ON VISITEUR.SEC_CODE=SECTEUR.SEC_CODE";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Visiteur unVisiteur = chargerUnEnregistrement(rs);
                result.add(unVisiteur);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoVisiteur::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Non implémenté
     */
    @Override
    public int update(Integer idMetier, Visiteur objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Non implémenté
     */
    @Override
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      public boolean verification(String login, java.util.Date password) throws DaoException{
         boolean result = false;
        ResultSet rs = null;
        java.sql.Date passwordSql = new java.sql.Date(password.getTime());
      
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR WHERE VIS_NOM=? AND VIS_DATEEMBAUCHE=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, login);
            ps.setDate(2, passwordSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result=true;
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoVisiteur::verification : erreur requete SELECT : " + ex.getMessage());
        }
        
        return result;
    }
    
    

    //----------------------------------------------------------------------
    //  Méthodes privées
    //----------------------------------------------------------------------
    /**
     * chargerUnEnregistrementEquipier Instancie un objet equipier avec les
     * valeurs lues dans la base de données La jointure avec la table PRESENCE
     * n'est pas effectuée
     *
     * @param rs enregistrement de la table Equipier courant
     * @return un objet Equipier, dont la liste des "présences" n'est pas
     * renseignée
     * @throws DaoException
     */
    
    private Visiteur chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            Visiteur visiteur = new Visiteur(null,null,null,null,null,null,null,null,null);
        //    java.util.Date dateEmbauche = new java.util.Date(rs.getDate("VIS_DATEEMBAUCHE").getTime());
       
   
            visiteur.setVis_Matricule(rs.getString("VIS_MATRICULE"));
            visiteur.setVis_Nom(rs.getString("VIS_NOM"));
            visiteur.setVis_Prenom(rs.getString("VIS_PRENOM"));
            visiteur.setVis_Adresse(rs.getString("VIS_ADRESSE"));
            visiteur.setVis_Cp(rs.getString("VIS_CP"));
            visiteur.setVis_Ville(rs.getString("VIS_VILLE"));
            visiteur.setVis_DateEmbauche(rs.getDate("VIS_DATEEMBAUCHE"));
            visiteur.setLabo(daoLabo.getOne(rs.getString("LAB_CODE")));
            
            if(rs.getString("SEC_CODE")!=null){
                Secteur secteur = new Secteur(null,null);
                secteur.setSec_Code(rs.getString("SEC_CODE"));
                secteur.setSec_Libelle(rs.getString("SEC_LIBELLE"));
                visiteur.setSecteur(secteur);
            }
            /*
            if(rs.getString("LAB_CODE")!=null){
                Labo labo = new Labo(null,null,null);
                labo.setLab_Code(rs.getString("LAB_CODE"));
                labo.setLab_ChefVente(rs.getString("LAB_CHEFVENTE"));
                labo.setLab_Nom(rs.getString("LAB_NOM"));
                visiteur.setLabo(labo);
    
            
            }*/
            
            return visiteur;
        } catch (SQLException ex) {
            throw new DaoException("DaoVisiteur - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 

    @Override
    public Visiteur getOne(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
