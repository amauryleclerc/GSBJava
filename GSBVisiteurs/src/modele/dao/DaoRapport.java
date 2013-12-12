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
        String requete = "SELECT * FROM VISITEUR"
                + " LEFT OUTER JOIN VISITEUR ON RAPPORT_VISITE.VIS_MATRICULE=VISITEUR.VIS_MATRICULE"
                + " LEFT OUTER JOIN PRATICIEN ON RAPPORT_VISITE.PRA_NUM=PRATICIEN.PRA_NUM"
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
        String requete = "SELECT * FROM RAPPORT_VISITE"
                + " LEFT OUTER JOIN VISITEUR ON RAPPORT_VISITE.VIS_MATRICULE=VISITEUR.VIS_MATRICULE"
                + " LEFT OUTER JOIN PRATICIEN ON RAPPORT_VISITE.PRA_NUM=PRATICIEN.PRA_NUM";
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
       if(rs.getString("PRA_NUM")!=null){
           Praticien praticien=new Praticien(0,null,null,null,null,null,null,null);
             praticien.setPra_Num(rs.getInt("PRA_NUM"));
            praticien.setPra_Nom(rs.getString("PRA_NOM"));
            praticien.setPra_Prenom(rs.getString("PRA_PRENOM"));
            praticien.setPra_Adresse(rs.getString("PRA_ADRESSE"));
            praticien.setPra_Cp(rs.getString("PRA_CP"));
            praticien.setPra_Ville(rs.getString("PRA_VILLE"));
            praticien.setPra_CoefNotoriete(rs.getFloat("PRA_COEFNOTORIETE"));
            rapport.setPracticien(praticien);
       }   
        if(rs.getString("VIS_MATRICULE")!=null){
            Visiteur visiteur = new Visiteur(null,null,null,null,null,null,null,null,null);
      
            visiteur.setVis_Matricule(rs.getString("VIS_MATRICULE"));
            visiteur.setVis_Nom(rs.getString("VIS_NOM"));
            visiteur.setVis_Prenom(rs.getString("VIS_PRENOM"));
            visiteur.setVis_Adresse(rs.getString("VIS_ADRESSE"));
            visiteur.setVis_Cp(rs.getString("VIS_CP"));
            visiteur.setVis_Ville(rs.getString("VIS_VILLE"));
            rapport.setVisiteur(visiteur);
        }
            
            
            return rapport;
        } catch (SQLException ex) {
            throw new DaoException("DaoRapport - chargerUnEnregistrement : pb JDBC\n" + ex.getMessage());
        }
    } 
    
}
