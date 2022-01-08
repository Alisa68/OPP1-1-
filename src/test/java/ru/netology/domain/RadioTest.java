package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {


    @Test
    void shouldSetNumberRadiostationChanging() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(5);
        int actual = rad.getCurrentRadioStation();
        assertEquals(5, actual);
    }

    @Test
    void shoruldSelectingTheWrongRadioStationNumbe() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(-1);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(0, rad.getCurrentRadioStation());
    }

    @Test
    void shouldChangeTheStationByButtonNextIfCurrentIsNine() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(9);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(0, rad.getCurrentRadioStation());
    }

    @Test
    void shouldTheNextChannelOfTheRadioStation() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(5);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(6, rad.getCurrentRadioStation());
    }

    @Test
    void shouldChangeTheStationByPrevButtonIfCurrentIsNull() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(0);
        rad.changeTheStationByPrevButton();
        assertEquals(9, rad.getCurrentRadioStation());
    }

    @Test
    void shouldChangeTheStationByPrevButton() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(5);
        rad.changeTheStationByPrevButton();
        assertEquals(4, rad.getCurrentRadioStation());
    }


    @Test
    void shouldIincreaseTheVolumeByOneStep() {
        Radio rad = new Radio();
        rad.setCurrentVolume(5);
        rad.increaseVolume();
        assertEquals(6, rad.getCurrentVolume());
    }

    @Test
    void shouldIncreaseTheMaximumVolumeValue() {
        Radio rad = new Radio();
        rad.setCurrentVolume(11);
        rad.increaseVolume();
        assertEquals(10, rad.getCurrentVolume());
    }

    @Test
    void shouldReduceTheVolumeByOneStep() {
        Radio rad = new Radio();
        rad.setCurrentVolume(0);
        rad.decreaseVolume();
        assertEquals(0, rad.getCurrentVolume());
    }


    @Test
    void shouldReduceTheMinimumVolumeValue() {
        Radio rad = new Radio();
        rad.setCurrentVolume(5);
        rad.decreaseVolume();
        assertEquals(4, rad.getCurrentVolume());
    }

    @Test
    void shouldSetTheRadioChannelToIndicateItsNumber() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(5);
        assertEquals(5, rad.getCurrentRadioStation());

    }
    @Test
    void shouldSetCurrentRadioStation(){
        Radio rad = new Radio();
        rad.setCurrentRadioStationNumber(4);
        assertEquals(4,rad.getCurrentRadioStation());
    }
    @Test
    void shouldSetCurrentRadioStationNegativMin() {
        Radio rad = new Radio();
        rad.setCurrentRadioStationNumber(-10);
        assertEquals(0, rad.getCurrentRadioStation());
    }
        @Test
        void shouldSetCurrentRadioStationNegativMax() {
            Radio rad = new Radio();
            rad.setCurrentRadioStationNumber(11);
            assertEquals(0, rad.getCurrentRadioStation());
        }
}