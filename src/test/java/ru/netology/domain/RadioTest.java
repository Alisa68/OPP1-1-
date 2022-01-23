package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void shouldShowTheNumberOfStations() {
        Radio radio = new Radio(15);
        assertEquals(15, radio.getNumberOfRadioStations(), "Кол-во станций");
    }

    @Test
    void shouldStations() {
        Radio radio = new Radio(20);
        radio.setStations(15);
        assertEquals(15, radio.getCurrentRadioStation(), "Номер радиостанции,с заданным кол-вом станций");
    }

    @Test
    void shouldSetStationIsMoreThanTheNumberOfStations() {
        Radio radio = new Radio();
        radio.setStations(10);
        assertEquals(5, radio.getCurrentRadioStation(), "Номер радиостанции. Негативное max значение");
    }

    @Test
    void shouldSetStationOfASmallerNumberOfStations() {
        Radio radio = new Radio();
        radio.setStations(-1);
        assertEquals(5, radio.getCurrentRadioStation(), "Номер радиостанции. Негативное min значение");
    }

    @Test
    void shouldSetNumberRadiostationChanging() {
        Radio radio = new Radio();
        assertEquals(5, radio.getCurrentRadioStation(), "Номер радиостанции с цифрового пульта");
    }

    @Test
    void shoruldSelectingTheWrongRadioStationNumbe() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(-1);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(0, rad.getCurrentRadioStation(), "Негативное минимальное граничное значение");
    }

    @Test
    void shouldChangeTheStationByButtonNextIfCurrentIsNine() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(9);
        radio.selectingTheWrongRadioStationNumber();
        assertEquals(0, radio.getMinRadioStation(), "Текущая радиостанция - max, " +
                "next (следующая) на пульте, то текущая 0-ая");
    }

    @Test
    void shouldTheNextChannelOfTheRadioStation() {
        Radio rad = new Radio();
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(6, rad.getCurrentRadioStation(), "Следующий канал");
    }

    @Test
    void shouldChangeTheStationByPrevButtonIfCurrentIsNull() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);
        radio.changeTheStationByPrevButton();
        assertEquals(9, radio.getMaxRadioStation(), "Текущая радиостанция - 0,  prev (предыдущая) " +
                "на пульте, то текущей должна стать максимальная");
    }

    @Test
    void shouldChangeTheStationByPrevButton() {
        Radio rad = new Radio();
        rad.changeTheStationByPrevButton();
        assertEquals(4, rad.getCurrentRadioStation(), "Предыдущий канал");
    }


    @Test
    void shouldIincreaseTheVolumeByOneStep() {
        Radio rad = new Radio();
        rad.setCurrentVolume(50);
        rad.increaseVolume();
        assertEquals(51, rad.getCurrentVolume(), "Увеличить громкость++1");
    }

    @Test
    void shouldIncreaseTheMaximumVolumeValue() {
        Radio rad = new Radio();
        rad.setCurrentVolume(105);
        rad.increaseVolume();
        assertEquals(100, rad.getMaxVolume(), "Негативное максимальное граничное значение");
    }

    @Test
    void shouldReduceTheVolumeByOneStep() {
        Radio rad = new Radio();
        rad.setCurrentVolume(-5);
        rad.decreaseVolume();
        assertEquals(0, rad.getMinVolume(), "Минимальное граничное значение");
    }


    @Test
    void shouldReduceTheMinimumVolumeValue() {
        Radio rad = new Radio();
        rad.setCurrentVolume(99);
        rad.decreaseVolume();
        assertEquals(98, rad.getCurrentVolume(), "Уменьшение громкости 1--");
    }

    @Test
    void shouldSetTheRadioChannelToIndicateItsNumber() {
        Radio rad = new Radio();
        rad.setCurrentRadioStation(5);
        assertEquals(5, rad.getCurrentRadioStation());

    }

    @Test
    void shouldSetCurrentRadioStation() {
        Radio rad = new Radio();
        rad.setCurrentRadioStationNumber(4);
        assertEquals(4, rad.getCurrentRadioStation());
    }

    @Test
    void shouldSetCurrentRadioStationNegativMin() {
        Radio rad = new Radio();
        rad.setCurrentRadioStationNumber(-10);
        assertEquals(0, rad.getMinRadioStation(), "Негативное минимальное граничное значение");
    }

    @Test
    void shouldSetCurrentRadioStationNegativMax() {
        Radio rad = new Radio();
        rad.setCurrentRadioStationNumber(11);
        assertEquals(9, rad.getMaxRadioStation(), "Негативное максимальное граничное значение");
    }
}