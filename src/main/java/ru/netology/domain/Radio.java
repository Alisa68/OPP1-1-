package ru.netology.domain;

public class Radio {
    private String name = "Radioman";


    private int currentVolume;
    private int maxVolume = 100;
    private int minVolume = 0;

    private int minRadioStation = 0;
    private int numberOfRadioStations = 10;
    private int currentRadioStation = minRadioStation;
    private int maxRadioStation = calculationOfTheMaximumStationNumber(numberOfRadioStations);

    public Radio() {
    }

    public Radio(int numberOfRadioStations) {
        this.maxRadioStation = calculationOfTheMaximumStationNumber(numberOfRadioStations);

    }

    public int calculationOfTheMaximumStationNumber(int numberOfRadioStations) {

        if (numberOfRadioStations <= 0) {
            numberOfRadioStations = this.numberOfRadioStations;
        }
        maxRadioStation = minRadioStation;
        for (int cycle = 1; cycle < numberOfRadioStations; cycle++) {
            maxRadioStation++;
        }
        return maxRadioStation;
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

    public int getCurrentVolume() {
        return currentVolume;

    }

    public void setCurrentVolume(int currentVolume) {
        this.currentVolume = currentVolume;

    }

    public void setCurrentRadioStation(int currentRadioStation) {
        if (currentRadioStation < minRadioStation) {
            this.currentRadioStation = minRadioStation;
            return;
        }
        if (currentRadioStation > maxRadioStation) {
            this.currentRadioStation = maxRadioStation;
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    public int getCurrentRadioStation() {
        return currentRadioStation;
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

}

