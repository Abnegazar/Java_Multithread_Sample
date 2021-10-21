package com.tp2;

import java.util.Random;
import java.util.stream.IntStream;

class SystemeEmprunt {

    /* Constantes de la simulation */

    static final int NB_SITES = 5;
    static final int NB_CLIENTS = 10;

    private final Site[] sites = new Site[NB_SITES];
    private final Client[] clients = new Client[NB_CLIENTS];
    private Camion camion;

    /* Constructeur du systeme d'emprunt */
    SystemeEmprunt() {
        /* Instanciation des sites */
        for (int i = 0; i < NB_SITES; i++)
            sites[i] = new Site(i);

        /* Instanciation des clients */
        Random r = new Random();
        for (int i = 0; i < NB_CLIENTS; i++) {
            int siteDep = r.nextInt(NB_SITES);
            int siteArr = r.nextInt(NB_SITES);
            clients[i] = new Client("C"+i, sites[siteDep], sites[siteArr]);
        }

        /* Instanciation du camion */
        camion = new Camion(sites);

        //Initialisation du camion avec quelques vélos
        camion.setCurrentBikeNumber(10);
        camion.setDaemon(true);
        /* Démarrage du camion et des clients */
        //camion.start();
        for (Client client : clients) {
            client.start();
        }
    }

    public static void main(String[] args) {
        new SystemeEmprunt();
    }

} // SystemeEmprunt
