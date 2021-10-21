package com.tp2;

public class Client extends Thread {

    private Site siteDep;
    private Site siteArr;
    private String nom;

    public Client(String nom, Site siteDep, Site siteArr) {
        this.nom = nom;
        this.siteDep = siteDep;
        this.siteArr = siteArr;
    }

    public void run() {
        siteDep.emprunter(this);
        //Attente pendant une certaine période de temps correspondant à la "distance" entre
        //le site de départ et le site d'arrivée
        try {
            Thread.sleep(2L * siteArr.getId());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        siteArr.restituer(this);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
