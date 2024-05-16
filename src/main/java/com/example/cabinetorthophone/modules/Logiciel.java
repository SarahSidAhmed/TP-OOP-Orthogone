package com.example.cabinetorthophone.modules;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Logiciel implements Serializable {
    static private HashMap<String, Orthogone> orthogonistes = new HashMap<String, Orthogone>();
    private Orthogone connectedUser = null;
    private static Orthogone orthogoneCourrant;


    public Logiciel() {
    }


    public static void setOrthogoneCourrant(Orthogone o ){
        orthogoneCourrant = o;
    }

    public static Orthogone getOrthogoneCourrant(){return orthogoneCourrant;}
    public static HashMap<String, Orthogone> getOrthogonistes() {
        return orthogonistes;
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
//        Orthogone o;
//        do {
//            if (!var2.hasNext()) {
//                return false;
//            }
//
//            o = (Orthogone)var2.next();
//        } while(!o.getEmail().equals(email));
//
//        return true;
    }

    public static Boolean seConnecter(String email, String password) {

        boolean found = rechercheCompte(email);
        if (found ) {
            if (orthogonistes.get(email).getPassword().equals(password)) return true;
            else return false;
        }else return false;
//        Iterator var3 = this.orthogonistes.iterator();
//
//
//        while(true) {
//            while(var3.hasNext()) {
//                Orthogone o = (Orthogone)var3.next();
//                if (o.getEmail().equals(email) && o.getPassword().equals(password)) {
//                    this.connectedUser = o;
//                    System.out.println("Vous êtes maintenant connecté.");
//                } else {
//                    System.out.println("Email ou mot de passe incorrect.");
//                }
//            }
//
//            return;
//        }
    }

    public void seDeconnecter() {
        if (this.connectedUser != null) {
            System.out.println("Vous êtes maintenant déconnecté.");
        } else {
            System.out.println("Vous n'êtes pas connecté.");
        }

    }

    public static void chargerUtilisateurs() {
        try (FileInputStream fis = new FileInputStream("FichierCabinet.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            orthogonistes = (HashMap<String, Orthogone>) ois.readObject();
            System.out.println("Utilisateurs chargés avec succès.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erreur lors du chargement des utilisateurs : " + e.getMessage());
        }
    }
}
