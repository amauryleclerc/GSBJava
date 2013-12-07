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
    @Override
    public Visiteur getOne(Integer idVisiteur) throws DaoException {
        Visiteur result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR"
                + " LEFT JOIN TYPE_VISITEUR ON VISITEUR.TYP_CODE=TYP_VISITEUR.TYP_CODE"
                + " WHERE PRA_NUM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, idVisiteur);
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
                + " LEFT JOIN TYPE_VISITEUR ON VISITEUR.TYP_CODE=TYPE_VISITEUR.TYP_CODE";
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
    public boolean verification(String login, String password) throws DaoException{
         boolean result = false;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM VISITEUR WHERE PRA_NOM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (rs.next()) {
                result=true;
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoVisiteur::getOne : erreur requete SELECT : " + ex.getMessage());
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
   
            visiteur.setVis_Nom(rs.getString("PRA_NOM"));
            visiteur.setVis_Prenom(rs.getString("PRA_PRENOM"));
            visiteur.setVis_Adresse(rs.getString("PRA_ADRESSE"));
            visiteur.setVis_Cp(rs.getString("PRA_CP"));
            visiteur.setVis_Ville(rs.getString("PRA_VILLE"));
    
            
          
            return visiteur;
        } catch (SQLException ex) {
            throw new DaoException("DaoVisiteur - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 
    
}
