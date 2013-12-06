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
public class DaoPraticien implements DaoInterface<Praticien, Integer> {

    /**
     * Non implémenté
     */
    @Override
    public int create(Praticien unPraticien) throws Exception {
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
    public Praticien getOne(Integer idPraticien) throws DaoException {
        Praticien result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM PRATICIEN WHERE PRA_NUM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, idPraticien);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoPraticien::getOne : erreur requete SELECT : " + ex.getMessage());
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
    public ArrayList<Praticien> getAll() throws DaoException {
        ArrayList<Praticien> result = new ArrayList<Praticien>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM PRATICIEN";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Praticien unPraticien = chargerUnEnregistrement(rs);
                result.add(unPraticien);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoPraticien::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Non implémenté
     */
    @Override
    public int update(Integer idMetier, Praticien objetMetier) throws Exception {
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
        return true;
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
    
    private Praticien chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            Praticien praticien = new Praticien(0,null,null,null,null,null,null,null);
            praticien.setPra_Num(rs.getInt("PRA_NUM"));
            praticien.setPra_Nom(rs.getString("PRA_NOM"));
            praticien.setPra_Prenom(rs.getString("PRA_PRENOM"));
            praticien.setPra_Adresse(rs.getString("PRA_ADRESSE"));
            praticien.setPra_Cp(rs.getString("PRA_CP"));
            praticien.setPra_Ville(rs.getString("PRA_VILLE"));
            praticien.setPra_CoefNotoriete(rs.getFloat("PRA_COEFNOTORIETE"));
       //     praticien.setType_Practicien(DAOType_Praticien.getOne());
            
          
            return praticien;
        } catch (SQLException ex) {
            throw new DaoException("DaoPraticien - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 
    
}
