package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    private final Radio radioDefault = new Radio();
    private final Radio radio = new Radio(20);
    private final Radio radioNegative = new Radio(-20);


    @Test
    void shouldCurrentRadioStationNumberPositiveBoundaryValuesRadioDefaultMax() {
        radioDefault.setCurrentRadioStation(9);
        assertEquals(9, radioDefault.getCurrentRadioStation(), "выставление текущего номера" +
                " радиостанции - позитивный, граничные значения max");


    }

    @Test
    void shouldCurrentRadioStationNumberPositiveBoundaryValuesRadioDefaultMinD() {
        radioDefault.setCurrentRadioStation(0);
        assertEquals(0, radioDefault.getCurrentRadioStation(), "выставление текущего номера" +
                " радиостанции - позитивный, граничные значения min");


    }

    @Test
    void shouldCurrentRadioStationNumberPositiveBoundaryValuesRadioDefaultMaxD() {
        radio.setCurrentRadioStation(19);
        assertEquals(19, radio.getCurrentRadioStation(), "выставление текущего номера" +
                " радиостанции - позитивный, граничные значения max");


    }

    @Test
    void shouldCurrentRadioStationNumberPositiveBoundaryValuesRadioDefaultMin() {
        radio.setCurrentRadioStation(0);
        assertEquals(0, radio.getMinRadioStation(), "выставление текущего номера" +
                " радиостанции - позитивный, граничные значения min");


    }

    @Test
    void shouldCurrentRadioStationNumberNegativeBoundaryValuesRadioDefaultMin() {
        radioDefault.setCurrentRadioStation(-1);
        assertEquals(0, radioDefault.getCurrentRadioStation(), "Негативное минимальное граничное" +
                " значение");
    }

    @Test
    void shouldCurrentRadioStationNumberNegativeBoundaryValuesRadioDefaultMax() {
        radioDefault.setCurrentRadioStation(10);
        assertEquals(9, radioDefault.getCurrentRadioStation(), "Негативное max граничное" +
                " значение");
    }

    @Test
    void shouldCurrentRadioStationNumberNegativeBoundaryValuesRadioMin() { //Модифицированое радио

        radio.setCurrentRadioStation(-1);
        assertEquals(0, radio.getCurrentRadioStation(), "Негативное " +
                "min граничное значение");
    }

    @Test
    void shouldCurrentRadioStationNumberNegativeBoundaryValuesRadioMax() {

        radio.setCurrentRadioStation(20);
        assertEquals(19, radio.getCurrentRadioStation(), "Негативное max граничное значение");
    }

    @Test
    void shouldChangeTheStationByButtonNextIfCurrentIsNineStandart() {
        radioDefault.selectingTheWrongRadioStationNumber();
        assertEquals(0, radioDefault.getMinRadioStation(), "Текущая радиостанция - max, " +
                "next (следующая) на пульте, то текущая 0-ая");
    }

    @Test
    void shouldChangeTheStationByButtonNextIfCurrentIsNine() {
        radio.selectingTheWrongRadioStationNumber();
        assertEquals(0, radio.getMinRadioStation(), "Текущая радиостанция - max, " +
                "next (следующая) на пульте, то текущая 0-ая");
    }

    @Test
    void shouldTheNextChannelOfTheRadioStationMax() {
        radio.setCurrentRadioStation(19);
        radio.selectingTheWrongRadioStationNumber();
        assertEquals(0, radio.getCurrentRadioStation(), "Следующий канал.Max radio");
    }

    @Test
    void shouldTheNextChannelOfTheRadioStationMin() {
        radio.setCurrentRadioStation(0);
        radio.selectingTheWrongRadioStationNumber();
        assertEquals(1, radio.getCurrentRadioStation(), "Следующий канал.Min radio");
    }

    @Test
    void shouldTheNextChannelOfTheRadioStationStandartMax() {
        radioDefault.setCurrentRadioStation(9);
        radioDefault.selectingTheWrongRadioStationNumber();
        assertEquals(0, radioDefault.getCurrentRadioStation(), "Следующий канал. Max radio Default");
    }

    @Test
    void shouldTheNextChannelOfTheRadioStationStandartMin() {
        radioDefault.setCurrentRadioStation(0);
        radioDefault.selectingTheWrongRadioStationNumber();
        assertEquals(1, radioDefault.getCurrentRadioStation(), "Следующий канал.Min  radio Default ");
    }


    @Test
    void shouldChangeTheStationByPrevButtonIfCurrentIsNullStandart() {
        radioDefault.setCurrentRadioStation(0);
        radioDefault.changeTheStationByPrevButton();
        assertEquals(9, radioDefault.getMaxRadioStation(), "Текущая радиостанция - 0,  prev (предыдущая) " +
                "на пульте, то текущей должна стать максимальная");
    }

    @Test
    void shouldChangeTheStationByPrevButtonIfCurrentIsNull() {
        radio.setCurrentRadioStation(0);
        radio.changeTheStationByPrevButton();
        assertEquals(19, radio.getMaxRadioStation(), "Текущая радиостанция - 0,  prev (предыдущая) " +
                "на пульте, то текущей должна стать максимальная");
    }


    @Test
    void shouldChangeTheStationByPrevButtonMax() {
        radio.setCurrentRadioStation(19);
        radio.changeTheStationByPrevButton();
        assertEquals(18, radio.getCurrentRadioStation(), "Предыдущий канал.");
    }

    @Test
    void shouldChangeTheStationByPrevButtonStandartMax() {
        radioDefault.setCurrentRadioStation(9);
        radioDefault.changeTheStationByPrevButton();
        assertEquals(8, radioDefault.getCurrentRadioStation(), "Предыдущий канал.Стандартное радио.");
    }

    @Test
    void shouldAmountRadioStationNegative() {
        assertEquals(9, radioNegative.getMaxRadioStation(),
                "Количество радиостанций при создании объекта - негативный");

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

}
