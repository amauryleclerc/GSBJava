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
    public int create(Medicament unMedicament) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Lire un enregistrement d'après son identifiant
     *
     * @param identifiant métier de l'objet recherché
     * @return objet métier trouvé, ou null sinon
     * @throws Exception
     */
        public Medicament getOne(String idMedicament) throws DaoException {
        Medicament result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM MEDICAMENT"
                + "INNER JOIN FAMILLE ON MEDICAMENT.FAM_CODE = FAMILLE.FAM_CODE"
                + " WHERE MED_DEPOTLEGAL=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setString(1, idMedicament);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoMedicament::getOne : erreur requete SELECT : " + ex.getMessage());
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
        String requete = "SELECT * FROM MEDICAMENT";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Medicament unMedicament = chargerUnEnregistrement(rs);
                result.add(unMedicament);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoMedicament::getAll : erreur requete SELECT : " + ex.getMessage());
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
           
            
          medicament.setMed_DepotLegal(rs.getString("MED_DEPOTLEGAL"));
          medicament.setMed_NomCommercial(rs.getString("MED_NOMCOMMERCIAL"));
          if(rs.getString("FAM_CODE")!=null){
               Famille famille = new Famille(null,null);
               famille.setFam_Code(rs.getString("FAM_CODE"));
               famille.setFam_Libelle(rs.getString("FAM_LIBELLE"));
               medicament.setFamille(famille);
          }
            medicament.setMed_Composition(rs.getString("MED_COMPOSITION"));
            medicament.setMed_Effets(rs.getString("MED_EFFETS"));
            medicament.setMed_ContreIndic(rs.getString("MED_CONTREINDIC")); 
            medicament.setMed_PricEchantillon(rs.getFloat("MED_PRIXECHANTILLON"));
            return medicament;
        } catch (SQLException ex) {
            throw new DaoException("DaoMedicament - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 

    @Override
    public Medicament getOne(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
