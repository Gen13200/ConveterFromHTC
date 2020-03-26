package com.ru.htccs.converter.model;

import com.ru.htccs.converter.model.base.Converter;
import com.ru.htccs.converter.model.converters.*;
import com.ru.htccs.converter.model.types.ConverterTypes;

public class FactoryConverter {

    public Converter createConverter(ConverterTypes converterTypes){
        switch (converterTypes) {
            case DP:
                return new ConverterDP();
            case IN:
                return new ConverterIN();
            case MM:
                return new ConverterMM();
            case PT:
                return new ConverterPT();
            case PX:
                return new ConverterPX();
            case SP:
                return new ConverterSP();
            default:
                throw new IllegalArgumentException("Wrong computer type:" + converterTypes);

        }
    }
}
