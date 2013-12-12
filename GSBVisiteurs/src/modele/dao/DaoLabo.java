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
 * Classe DAO pour la classe Labo
 */
public class DaoLabo implements DaoInterface<Labo, Integer> {

    /**
     * Non implémenté
     */
    @Override
    public int create(Labo unLabo) throws Exception {
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
    public Labo getOne(Integer idLabo) throws DaoException {
        Labo result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM LABO"
                                + " WHERE LAB_CODE=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, idLabo);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoLabo::getOne : erreur requete SELECT : " + ex.getMessage());
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
    public ArrayList<Labo> getAll() throws DaoException {
        ArrayList<Labo> result = new ArrayList<Labo>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM LABO";
        
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Labo unLabo = chargerUnEnregistrement(rs);
                result.add(unLabo);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoLabo::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Non implémenté
     */
    @Override
    public int update(Integer idMetier, Labo objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Non implémenté
     */
    @Override
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    private Labo chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            
                Labo labo = new Labo(null,null,null);
                labo.setLab_Code(rs.getString("LAB_CODE"));
                labo.setLab_ChefVente(rs.getString("LAB_CHEFVENTE"));
                labo.setLab_Nom(rs.getString("LAB_NOM"));
    
            
            
            
            return labo;
        } catch (SQLException ex) {
            throw new DaoException("DaoLabo - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 
    
}
