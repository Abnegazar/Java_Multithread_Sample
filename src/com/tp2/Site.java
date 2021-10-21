package com.tp2;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
class Site{

    /*Constantes communes à tous les sites */
    static final int STOCK_INIT = 5;
    static final int STOCK_MAX = 10;
    static final int BORNE_SUP = 8;
    static final int BORNE_INF = 2;
    //Permet d'identifier la position du site dans le lot de sites créé
    private int id;
    private int currentStock;

    public Site(int id) {
        this.currentStock = STOCK_INIT;
        this.id = id;
    }

    // Camions
    public synchronized void deposer(Camion camion){
        int diff = Site.STOCK_INIT - currentStock;
        int depot = 0;
        if(diff > 0){
            while (camion.getCurrentBikeNumber() > 0 && currentStock < Site.STOCK_INIT){
                currentStock++;
                depot++;
                camion.setCurrentBikeNumber(camion.getCurrentBikeNumber() - 1);
            }
        }
        System.out.println("Passage sur le site " +id+ ": " + depot + " vélos déposés.");
        notifyAll();
    }

    public synchronized void degager(Camion camion){
        int diff = currentStock - Site.BORNE_SUP;
        if(diff > 0){
            camion.setCurrentBikeNumber(camion.getCurrentBikeNumber() + diff);
            currentStock = Site.STOCK_INIT;
        }
        System.out.println("Passage sur le site " +id+ ": " + Math.max(diff, 0) + " vélos enlevés.");
        notifyAll();
    }

    // Clients
    public synchronized void emprunter(Client client){
        while (currentStock <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentStock--;
        System.out.println("Le client " + client.getNom() + " vient de prendre un vélo sur le site " + id);
        notifyAll();
    }

    public synchronized void restituer(Client client){
        while (currentStock >= Site.STOCK_MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        currentStock++;
        System.out.println("Le client " + client.getNom() + " vient de rendre un vélo sur le site " + id);
        notifyAll();
    }

    public int getId() {
        return id;
    }
}
