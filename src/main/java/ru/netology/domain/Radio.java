package ru.netology.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Radio {
     @Setter
     int currentVolume;
     @Setter
     int currentRadioStation = 5;
     int numberOfRadioStations = 10;
     int maxVolume = 100;
     int minVolume = 0;
     int maxRadioStation = 9;
     int minRadioStation = 0;


     public Radio(int currentRadioStation,
                  int maxRadioStation, int minRadioStation, int numberOfRadioStations) {

          this.currentRadioStation = currentRadioStation;
          this.maxRadioStation = maxRadioStation;
          this.minRadioStation = minRadioStation;
          this.numberOfRadioStations = numberOfRadioStations;
     }

     public Radio(int maxVolume, int minVolume, int currentVolume) {
          this.maxVolume = maxVolume;
          this.minVolume = minVolume;
          this.currentVolume = currentVolume;
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

     public void setCurrentRadioStation(int currentRadioStation) {
          this.currentRadioStation = currentRadioStation;
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
}







