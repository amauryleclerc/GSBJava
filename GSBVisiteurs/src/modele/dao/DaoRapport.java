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
 * Classe DAO pour la classe Rapport
 */
public class DaoRapport implements DaoInterface<Rapport_Visite, Integer> {
    private DaoVisiteur daoVisiteur = new DaoVisiteur();
    private DaoPraticien daoPraticien = new DaoPraticien();
    /**
     * Non implémenté
     */
    @Override
    public int create(Rapport_Visite unRapport) throws Exception {
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
    public Rapport_Visite getOne(Integer idRapport) throws DaoException {
        Rapport_Visite result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE"
                + " WHERE RAP_NUM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, idRapport);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapport::getOne : erreur requete SELECT : " + ex.getMessage());
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
    public ArrayList<Rapport_Visite> getAll() throws DaoException {
        ArrayList<Rapport_Visite> result = new ArrayList<Rapport_Visite>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM RAPPORT_VISITE";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Rapport_Visite unRapport = chargerUnEnregistrement(rs);
                result.add(unRapport);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapport::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Non implémenté
     */
    @Override
    public int update(Integer idMetier, Rapport_Visite objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Non implémenté
     */
    @Override
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean ajouter(Rapport_Visite rapport) throws DaoException {
        ResultSet rsGK = null; // ResultSet devant contenir le dernier ID généré ou vide
        int nb;
        boolean ok =true;
 java.sql.Date datesql = new java.sql.Date(rapport.getRap_Date().getTime());
        // préparer la requête
        String requete = "INSERT INTO RAPPORT_VISITE (VIS_MATRICULE,  PRA_NUM, RAP_DATE,  RAP_BILAN, RAP_MOTIF) VALUES (?, ? , ? , ?, ?)";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);

            ps.setString(1, rapport.getVisiteur().getVis_Matricule());
       //     ps.setInt(2,rapport.getRap_Num());
            ps.setInt(2, rapport.getPracticien().getPra_Num());
            ps.setDate(3,datesql);
            ps.setString(4, rapport.getRap_Bilan());
              ps.setString(5, rapport.getRap_Motif());
            nb = ps.executeUpdate();
    /*         rsGK = ps.getGeneratedKeys();
            if (rsGK.next()){
               
                 cle = rsGK.getInt(1);
            }
        */   
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapport::ajouter : erreur requete INSERT : " + ex.getMessage());
        }
        return ok;
    }
     public int getCleMax() throws DaoException {
        int result = 0;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT MAX(RAP_NUM) AS CLE FROM RAPPORT_VISITE";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
      
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("CLE");
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoRapport::getOne : erreur requete SELECT : " + ex.getMessage());
        }
        return (result);
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
    
    private Rapport_Visite chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            Rapport_Visite rapport = new Rapport_Visite(null,0,null,null,null,null);
       rapport.setRap_Bilan(rs.getString("RAP_BILAN"));
       rapport.setRap_Date(rs.getDate("RAP_DATE"));
       rapport.setRap_Motif(rs.getString("RAP_MOTIF"));
       rapport.setRap_Num(rs.getInt("RAP_NUM"));
       rapport.setVisiteur(daoVisiteur.getOne(rs.getString("VIS_MATRICULE")));
       rapport.setPracticien(daoPraticien.getOne(rs.getInt("PRA_NUM")));
   
            
            
            return rapport;
        } catch (SQLException ex) {
            throw new DaoException("DaoRapport - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 
    
}
