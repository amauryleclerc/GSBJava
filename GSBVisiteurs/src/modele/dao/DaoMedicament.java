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
public class DaoMedicament implements DaoInterface<Medicament, Integer> {

    /**
     * Non implémenté
     */
    @Override
    public int create(Medicament unEquipier) throws Exception {
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
    public Medicament getOne(Integer idEquipier) throws DaoException {
        Medicament result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM EQUIPIER WHERE ID_EQUIPIER=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, idEquipier);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoEquipier::getOne : erreur requete SELECT : " + ex.getMessage());
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
    public ArrayList<Medicament> getAll() throws DaoException {
        ArrayList<Medicament> result = new ArrayList<Medicament>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM EQUIPIER";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Medicament unEquipier = chargerUnEnregistrement(rs);
                result.add(unEquipier);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoEquipier::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Non implémenté
     */
    @Override
    public int update(Integer idMetier, Medicament objetMetier) throws Exception {
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
    private Medicament chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            Medicament medicament = new Medicament(null,null,null,null,null,null,null);
          medicament.setMed_DepotLegal(rs.getString("ID_EQUIPIER"));
            medicament.setMed_Composition(rs.getString("NOM"));
            medicament.setMed_ContreIndic(rs.getString("PRENOM")); 
            return medicament;
        } catch (SQLException ex) {
            throw new DaoException("DaoEquipier - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 
}
