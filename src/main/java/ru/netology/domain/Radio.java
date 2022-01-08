package ru.netology.domain;

public class Radio {
    private int currentVolume;
    private int maxVolume = 10;
    private int minVolume = 0;

    private int currentRadioStation;
    private int maxRadioStation = 9;
    private int minRadioStation = 0;


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


    public int getCurrentRadioStation() {
        return currentRadioStation;

    }

    public void setCurrentRadioStation(int currentRadioStation) {
        this.currentRadioStation = currentRadioStation;
    }
}

