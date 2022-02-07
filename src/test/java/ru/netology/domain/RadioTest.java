package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {


    @Test
    void shouldConstructorWithOutParametersNegativMin() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(-1);
        radio.setStation();
        assertEquals(0, radio.getMinRadioStation(), "Конструктор без параметров." +
                "Негативное min значение.");

    }

    @Test
    void shouldСonstructorWithTheParameterNegativMin() {
        Radio radio = new Radio(20);
        radio.setCurrentRadioStation(20);
        radio.setStation();
        assertEquals(0, radio.getMinRadioStation(),
                "конструктор с параметром. Негативное max");
    }

    @Test
    void shouldStations() {
        Radio radio = new Radio();
        radio.setStation();
        assertEquals(5, radio.getCurrentRadioStation(),
                "Номер радиостанции,по умолчанию");
    }


    @Test
    void shouldSetNumberRadiostationChanging() {
        Radio radio = new Radio(5);
        radio.setCurrentRadioStation(4);
        assertEquals(4, radio.getCurrentRadioStation(), "Номер радиостанции с цифрового пульта");
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
        Radio rad = new Radio(20);
        rad.setCurrentRadioStation(21);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(0, rad.getCurrentRadioStation(), "Негативное максимальное граничное значение");
    }

    @Test
    void shouldChangeTheStationByButtonNextIfCurrentIsNine() {
        Radio radio = new Radio(11);
        radio.setMaxRadioStation(10);
        radio.selectingTheWrongRadioStationNumber();
        assertEquals(0, radio.getMinRadioStation(), "Текущая радиостанция - max, " +
                "next (следующая) на пульте, то текущая 0-ая");
    }

    @Test
    void shouldTheNextChannelOfTheRadioStation() {
        Radio rad = new Radio(15);
        rad.setMaxRadioStation(14);
        rad.setCurrentRadioStation(13);
        rad.selectingTheWrongRadioStationNumber();
        assertEquals(14, rad.getCurrentRadioStation(), "Следующий канал");
    }

    @Test
    void shouldChangeTheStationByPrevButtonIfCurrentIsNull() {
        Radio radio = new Radio();
        radio.setCurrentRadioStation(0);
        radio.setMaxRadioStation(9);
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
    void shouldSetNumberRadioStation() {
        Radio rad = new Radio();
        rad.setMaxRadioStation(9);
        rad.setNumberOfRadioStations();
        assertEquals(10, rad.getNumberOfRadioStations(), "Количество станций по умолчанию");
    }


    @Test
    void shouldSetNumberRadioStationMaxNegativ() {
        Radio rad = new Radio(49);
        rad.setMaxRadioStation(50);
        rad.setNumberOfRadioStations();
        assertEquals(49, rad.getNumberOfRadioStations(), "Количество станций с заданным max negariv");
    }

    @Test
    void shouldSetNumberRadioStationMinNegativ() {
        Radio rad = new Radio(2);
        rad.setMaxRadioStation(1);
        rad.setNumberOfRadioStations();
        assertEquals(2, rad.getNumberOfRadioStations(), "Количество станций с заданным min ");
    }
}