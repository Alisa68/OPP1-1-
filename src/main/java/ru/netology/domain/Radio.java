package ru.netology.domain;

public class Radio {
    private String name = "Radioman";


    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;

    private int currentRadioStation=5;
    private int maxRadioStation = 9;
    private int numberOfRadioStations = 10;
    private int minRadioStation = 0;


    public Radio(int numberOfRadioStations) {
        this.numberOfRadioStations = numberOfRadioStations;
    }

    public Radio() {
    }


    public void setStations(int currentRadioStation) {

        if (currentRadioStation >= numberOfRadioStations) {
            return;
        }
        if (currentRadioStation < 0) {
            return;
        }
        this.currentRadioStation = currentRadioStation;


    }

    public void selectingTheWrongRadioStationNumber() {
        if (currentRadioStation >= maxRadioStation) {
            currentRadioStation = 0;

        } else {
            currentRadioStation += 1;
        }
    }

    public void changeTheStationByPrevButton() {
        if (currentRadioStation == minRadioStation) {
            currentRadioStation = maxRadioStation;

        } else {
            currentRadioStation -= 1;
        }
    }

    public void increaseVolume() {
        if (currentVolume >= maxVolume) {
            currentVolume = maxVolume;
            return;
        } else {
            currentVolume++;
            return;
        }
    }

    public void decreaseVolume() {
        if (currentVolume <= minVolume) {
            currentVolume = minVolume;
            return;

        } else {
            currentVolume--;
            return;

        }
    }

    public void setCurrentRadioStationNumber(int currentRadioStation) {
        if (currentRadioStation > maxRadioStation) {
            return;
        }
        if (currentRadioStation < minRadioStation) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    public int getCurrentVolume() {
        return currentVolume;

    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;

    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
    }

    public void setCurrentRadioStation(int currentRadioStation) {
        this.currentRadioStation = currentRadioStation;
    }

    public int getMaxVolume() {
        return maxVolume;
    }

    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxRadioStation() {
        return maxRadioStation;
    }

    public int getMinRadioStation() {
        return minRadioStation;
    }

    public int getNumberOfRadioStations() {
        return numberOfRadioStations;
    }
}

