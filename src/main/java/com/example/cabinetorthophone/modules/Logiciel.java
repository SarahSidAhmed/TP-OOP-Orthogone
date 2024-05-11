package com.example.cabinetorthophone.modules;


import java.util.HashSet;
import java.util.Iterator;

public class Logiciel {
    private HashSet<Orthogone> orthogonistes = new HashSet();
    private Orthogone connectedUser = null;

    public Logiciel() {
    }

    void CreerCompte(Orthogone o) {
        if (this.orthogonistes.contains(o)) {
            System.out.println("An account with this email already exists. Try connecting instead.");
        } else {
            this.orthogonistes.add(o);
            System.out.println("Account created successfully.");
        }

    }

    void supprimerCompte(String email) {
        Iterator<Orthogone> iterator = this.orthogonistes.iterator();

        while(iterator.hasNext()) {
            Orthogone o = (Orthogone)iterator.next();
            if (o.getEmail().equals(email)) {
                iterator.remove();
                System.out.println("Le compte a été supprimé avec succès.");
                return;
            }

            System.out.println("Compte non trouve.");
        }

    }

    public boolean rechercheCompte(String email) {
        Iterator var2 = this.orthogonistes.iterator();

        Orthogone o;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            o = (Orthogone)var2.next();
        } while(!o.getEmail().equals(email));

        return true;
    }

    public void seConnecter(String email, String password) {
        Iterator var3 = this.orthogonistes.iterator();

        while(true) {
            while(var3.hasNext()) {
                Orthogone o = (Orthogone)var3.next();
                if (o.getEmail().equals(email) && o.getPassword().equals(password)) {
                    this.connectedUser = o;
                    System.out.println("Vous êtes maintenant connecté.");
                } else {
                    System.out.println("Email ou mot de passe incorrect.");
                }
            }

            return;
        }
    }

    public void seDeconnecter() {
        if (this.connectedUser != null) {
            this.connectedUser = null;
            System.out.println("Vous êtes maintenant déconnecté.");
        } else {
            System.out.println("Vous n'êtes pas connecté.");
        }

    }
}
