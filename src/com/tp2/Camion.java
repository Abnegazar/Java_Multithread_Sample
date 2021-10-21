package com.tp2;

public class Camion extends Thread {

    private int currentBikeNumber;
    private final Site[] sites;

    public Camion(Site[] sites) {
        this.currentBikeNumber = 0;
        this.sites = sites;
    }

    public void run() {
        while (true) {
            int i = 0;
            while (i < sites.length) {
                reguler(sites[i]);
                //attendre 10*i i étant la position du site dans le lots
                try {
                    sleep(2L * sites[i].getId());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }

    public void reguler(Site site) {
        site.degager(this);
        site.deposer(this);
        System.out.println("Le camion contient à présent " + currentBikeNumber + " vélos.");
    }

    public int getCurrentBikeNumber() {
        return currentBikeNumber;
    }

    public void setCurrentBikeNumber(int currentBikeNumber) {
        this.currentBikeNumber = currentBikeNumber;
    }
}
