package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void shouldSelectTheTenthRadioStation() {
        Radio radio = new Radio(5, 9,
                0, 15);
        assertEquals(15, radio.getNumberOfRadioStations(), "Количество радиостанций");
    }


    @Test
    void shouldSetNumberRadiostationChanging() {
        Radio radio = new Radio(5, 9, 0, 10);

        assertEquals(5, radio.getCurrentRadioStation(), "Номер радиостанции с цифрового пульта");
    }

    @Test
    void shoruldSelectingTheWrongRadioStationNumbe() {
        Radio rad = new Radio(-1, 9, 0, 10);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(0, rad.getCurrentRadioStation(), "Негативное минимальное граничное значение");
    }

    @Test
    void shouldChangeTheStationByButtonNextIfCurrentIsNine() {
        Radio radio = new Radio(9,
                9, 0, 10);
        radio.selectingTheWrongRadioStationNumber();
        assertEquals(0, radio.getMinRadioStation(), "Текущая радиостанция - max, " +
                "next (следующая) на пульте, то текущая 0-ая");
    }

    @Test
    void shouldTheNextChannelOfTheRadioStation() {
        Radio rad = new Radio(45, 49, 0, 50);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(46, rad.getCurrentRadioStation(), "Следующий канал");
    }

    @Test
    void shouldChangeTheStationByPrevButtonIfCurrentIsNull() {
        Radio radio = new Radio(0,
                9, 0, 10);
        radio.changeTheStationByPrevButton();
        assertEquals(9, radio.getMaxRadioStation(), "Текущая радиостанция - 0,  prev (предыдущая) " +
                "на пульте, то текущей должна стать максимальная");
    }

    @Test
    void shouldChangeTheStationByPrevButton() {
        Radio rad = new Radio(5, 9, 0, 10);
        rad.changeTheStationByPrevButton();
        assertEquals(4, rad.getCurrentRadioStation(), "Предыдущий канал");
    }


    @Test
    void shouldIincreaseTheVolumeByOneStep() {
        Radio rad = new Radio(100, 0, 50);
        rad.increaseVolume();
        assertEquals(51, rad.getCurrentVolume(), "Увеличить громкость++1");
    }

    @Test
    void shouldIncreaseTheMaximumVolumeValue() {
        Radio rad = new Radio(10, 0, 11);
        rad.increaseVolume();
        assertEquals(10, rad.getMaxVolume(), "Негативное максимальное граничное значение");
    }

    @Test
    void shouldReduceTheVolumeByOneStep() {
        Radio rad = new Radio();
        rad.setCurrentVolume(0);
        rad.decreaseVolume();
        assertEquals(0, rad.getMinVolume(), "Минимальное граничное значение");
    }


    @Test
    void shouldReduceTheMinimumVolumeValue() {
        Radio rad = new Radio(100, 0, 99);
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