package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    void shouldShowTheNumberOfStations() {
        Radio radio = new Radio();
        assertEquals(10, radio.getNumberOfRadioStations(), "Кол-во станций по умолчанию");
    }

    @Test
    void shouldSetNumberOfRadioStationsPositive() {
        Radio radio = new Radio(100);
        radio.setNumberOfRadioStations(1);
        assertEquals(1, radio.getNumberOfRadioStations(), "Установка количества радиостанций");
    }

    @Test
    void shouldSetNumberOfRadioStationsNegative() {
        Radio radio = new Radio(100);
        radio.setNumberOfRadioStations(101);
        assertEquals(100, radio.getNumberOfRadioStations(), "Установка количества радиостанций");
    }

    @Test
    void shouldSetNumberOfRadioStationsNegative2() {
        Radio radio = new Radio(100);
        radio.setNumberOfRadioStations(0);
        assertEquals(100, radio.getNumberOfRadioStations(), "Установка количества радиостанций");
    }

    @Test
    void shouldStations() {
        Radio radio = new Radio(20);
        radio.setStations(15);
        assertEquals(15, radio.getCurrentRadioStation(),
                "Номер радиостанции,с заданными 20-ю станциями");
    }

    @Test
    void shouldStationsNegativMax() {
        Radio radio = new Radio(20);
        radio.setStations(21);
        assertEquals(5, radio.getCurrentRadioStation(),
                "Номер радиостанции. Негативное max");
    }

    @Test
    void shouldSetStationIsMoreThanTheNumberOfStations() {
        Radio radio = new Radio();
        radio.setStations(10);
        assertEquals(5, radio.getCurrentRadioStation(), "Номер радиостанции. Негативное max значение");
    }

    @Test
    void shouldSetStationIsBorderThanTheNumberOfStations() {
        Radio radio = new Radio();
        radio.setStations(9);
        assertEquals(9, radio.getCurrentRadioStation(),
                "Номер радиостанции. Граничное значение станций по умолчанию");
    }

    @Test
    void shouldSetStationNumberOfStationsOne() {
        Radio radio = new Radio(1);
        radio.setCurrentRadioStation(0);
        radio.setStations(0);
        assertEquals(0, radio.getCurrentRadioStation(),
                "Номер радиостанции. Кол-во станций - одна.");
    }


    @Test
    void shouldSetStationNegativNumberOfStations() {
        Radio radio = new Radio();
        radio.setStations(-1);
        assertEquals(5, radio.getCurrentRadioStation(), "Номер радиостанции. Негативное  значение");
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
    void shoruldSelectingTheWrongRadioStationNumbeMax() {
        Radio rad = new Radio(30);
        rad.setCurrentRadioStation(30);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(0, rad.getCurrentRadioStation(), "Негативное максимальное граничное значение");
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
        rad.setCurrentVolume(-1);
        rad.decreaseVolume();
        assertEquals(0, rad.getMinVolume(), "Негативное граничное значение");
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