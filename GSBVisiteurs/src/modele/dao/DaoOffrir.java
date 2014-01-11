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
public class DaoOffrir implements DaoInterface<Offrir, Integer> {
  private DaoVisiteur daoVisiteur = new DaoVisiteur();
    private DaoMedicament daoMedicament = new DaoMedicament();
      private DaoRapport daoRapport = new DaoRapport();
    
    /**
     * Non implémenté
     */
    @Override
    public int create(Offrir unOffrir) throws Exception {
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
    public Offrir getOne(Integer idOffrir) throws DaoException {
        Offrir result = null;
        ResultSet rs = null;
        // préparer la requête
        String requete = "SELECT * FROM OFFRIR";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            ps.setInt(1, idOffrir);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = chargerUnEnregistrement(rs);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoOffrir::getOne : erreur requete SELECT : " + ex.getMessage());
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
    public ArrayList<Offrir> getAll() throws DaoException {
        ArrayList<Offrir> result = new ArrayList<Offrir>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM OFFRIR";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Offrir unOffrir = chargerUnEnregistrement(rs);
                result.add(unOffrir);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoOffrir::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return result;
    }
    
        public ArrayList<Offrir> getRapport(int rapNum) throws DaoException {
        ArrayList<Offrir> result = new ArrayList<Offrir>();
        ResultSet rs;
        // préparer la requête
        String requete = "SELECT * FROM OFFRIR WHERE RAP_NUM=?";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);
             ps.setInt(1, rapNum);
            rs = ps.executeQuery();
            // Charger les enregistrements dans la collection
            while (rs.next()) {
                Offrir unOffrir = chargerUnEnregistrement(rs);
                result.add(unOffrir);
            }
        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoOffrir::getAll : erreur requete SELECT : " + ex.getMessage());
        }
        return result;
    }

    /**
     * Non implémenté
     */
    @Override
    public int update(Integer idMetier, Offrir objetMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Non implémenté
     */
    @Override
    public int delete(Integer idMetier) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       public boolean ajouter(Offrir offrir) throws DaoException {
        int nb;
        boolean ok =true;
        // préparer la requête
        String requete = "INSERT INTO OFFRIR (VIS_MATRICULE,  RAP_NUM, MED_DEPOTLEGAL,  OFF_QTE) VALUES (?, ? , ? , ?)";
        try {
            PreparedStatement ps = Jdbc.getInstance().getConnexion().prepareStatement(requete);

            ps.setString(1, offrir.getVisiteur().getVis_Matricule());
    
            ps.setInt(2, offrir.getRapport_visite().getRap_Num());
          
            ps.setString(3, offrir.getMedicament().getMed_DepotLegal());
              ps.setInt(4, offrir.getOff_Qte());
            nb = ps.executeUpdate();

        } catch (SQLException ex) {
            throw new modele.dao.DaoException("DaoOffrir::ajouter : erreur requete INSERT : " + ex.getMessage());
        }
        return ok;
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
    
    private Offrir chargerUnEnregistrement(ResultSet rs) throws DaoException {
        try {
            Offrir offrir = new Offrir(null,null,null,0);
            offrir.setMedicament(daoMedicament.getOne(rs.getString("MED_DEPOTLEGAL")));
            offrir.setRapport_visite(daoRapport.getOne(rs.getInt("RAP_NUM")));
            offrir.setVisiteur(daoVisiteur.getOne(rs.getString("VIS_MATRICULE")));
            offrir.setOff_Qte(rs.getInt("OFF_QTE"));
  
            
          
            return offrir;
        } catch (SQLException ex) {
            throw new DaoException("DaoOffrir - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 

 
    
}
