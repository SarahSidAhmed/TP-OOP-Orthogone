package com.example.cabinetorthophone.modules;


import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Logiciel implements Serializable {
    static private HashMap<String, Orthogone> orthogonistes = new HashMap<String, Orthogone>();
    private Orthogone connectedUser = null;
    private static Orthogone orthogoneCourrant;
    private static Patient patientCurrant;
    private static Dossier dossierCourrant;
    private static Fiche ficheCourrant;
    private static Epreuve epreuveCourrant;
    private static Bo boCourrant;



    public Logiciel() {
    }


    public static void setOrthogoneCourrant(Orthogone o ){
        orthogoneCourrant = o;
    }

    public static Orthogone getOrthogoneCourrant(){return orthogoneCourrant;}
    public static HashMap<String, Orthogone> getOrthogonistes() {
        return orthogonistes;
    }

    public static Patient getPatientCurrant() {
        return patientCurrant;
    }


    public static void setPatientCurrant(Patient patientCurrant) {
        Logiciel.patientCurrant = patientCurrant;
    }

    public static void setDossierCourrant(Dossier data) {
        dossierCourrant = data;
    }

    public static Dossier getDossierCourrant() {
return dossierCourrant;    }

    public static void setFicheCourrant(Fiche data) {
        ficheCourrant = data;
    }

    public static Fiche getFicheCourrant() {
        return ficheCourrant;
    }

    public static Epreuve getEpreuveCourrant() {
        return epreuveCourrant;
    }

    public static void setEpreuveCourrant(Epreuve epreuveCourrant) {
        Logiciel.epreuveCourrant = epreuveCourrant;
    }

    public static Bo getBoCourrant() {
        return boCourrant;
    }

    public static void setBoCourrant(Bo boCourrant) {
        Logiciel.boCourrant = boCourrant;
    }

    public void ajouterOrthophone(Orthogone orthogone){
        orthogonistes.put(orthogone.getEmail(), orthogone);
    }

    public static String CreerCompte(Orthogone o) {
        if (orthogonistes.containsKey(o.getEmail())) {
            return "An account with this email already exists. Try connecting instead.";
        } else {
            orthogonistes.put(o.getEmail(), o);
            return "Account created successfully.";
        }

    }

    void supprimerCompte(String email) {
        //Iterator<Orthogone> iterator = this.orthogonistes.iterator();

        this.orthogonistes.remove(email);
//        while(iterator.hasNext()) {
//            Orthogone o = (Orthogone)iterator.next();
//            if (o.getEmail().equals(email)) {
//                iterator.remove();
//                System.out.println("Le compte a été supprimé avec succès.");
//                return;
//            }
//
//            System.out.println("Compte non trouve.");
//        }

    }

    public static Orthogone getCompte(String email){
        if (rechercheCompte(email)){
            return orthogonistes.get(email);
        }else return null;
    }


    public static boolean rechercheCompte(String email) {
        //Iterator var2 = this.orthogonistes.iterator();

        boolean found = orthogonistes.containsKey(email);
        return found;

    }

    public static Boolean seConnecter(String email, String password) {

        boolean found = rechercheCompte(email);
        if (found ) {
            if (orthogonistes.get(email).getPassword().equals(password)) return true;
            else return false;
        }else return false;
    }

    public void seDeconnecter() {
        if (this.connectedUser != null) {
            System.out.println("Vous êtes maintenant déconnecté.");
        } else {
            System.out.println("Vous n'êtes pas connecté.");
        }

    }

    public static void sauvegarderUsers(){
        try{
            FileOutputStream fOut =new FileOutputStream("DataFile.dat");
            ObjectOutputStream ojOut = new ObjectOutputStream(fOut);
            ojOut.writeObject(orthogonistes);
            System.out.println("Data sauvegardés avec succés");
        }catch (IOException o ){
            System.out.println("Erreur lors de la sauvegarde des utilisateurs "+o.getMessage());
        }
    }


    public static void chargerUtilisateurs() {
        try (FileInputStream fis = new FileInputStream("DataFile.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            orthogonistes = (HashMap<String, Orthogone>) ois.readObject();
            System.out.println("Utilisateurs chargés avec succès.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des utilisateurs : " + e.getMessage());
        }
    }
}
