/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import modele.dao.DaoException;
import modele.dao.DaoMedicament;
import modele.dao.DaoVisiteur;
import modele.jdbc.FabriqueJdbc;
import modele.jdbc.Jdbc;
import modele.metier.Medicament;
import modele.metier.Visiteur;

/**
 *
 * @author btssio
 */
public class testDao {
        static DaoMedicament daoMedicament = new DaoMedicament();
         static DaoVisiteur daoVisiteur = new DaoVisiteur();

    // test de lecture des enregistrements de la table PRESENCE pour un équipier donné
    public static boolean testDaoLireMedicament() throws DaoException {
        boolean ok = true;
        List<Medicament> desMedicaments = daoMedicament.getAll();
        System.out.println("Liste des Medicaments");
        for (Medicament medicament : desMedicaments ) {
            System.out.println(medicament);
        }
        return ok;
    }
        public static boolean testDaoLireVisiteur() throws DaoException {
        boolean ok = true;
        List<Visiteur> desVisiteurs = daoVisiteur.getAll();
        System.out.println("Liste des Visiteurs");
        for (Visiteur visiteur : desVisiteurs ) {
            System.out.println(visiteur);
            System.out.println(visiteur.getVis_DateEmbauche());
        }
        return ok;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException, DaoException {
        System.out.println("Tests unitaires DAO");
        FabriqueJdbc.creer("gsbVisiteurJdbc.properties");
        Jdbc.getInstance().connecter();


        System.out.println("\nTest DAO Lire Medicament");
        if (testDaoLireMedicament()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
                System.out.println("\nTest DAO Lire Visiteur");
        if (testDaoLireVisiteur()) {
            System.out.println("+++ Réussite");
        } else {
            System.out.println("--- Echec");
        }
        

        System.out.println("\nDéconnexion");
        Jdbc.getInstance().deconnecter();

    }
}
