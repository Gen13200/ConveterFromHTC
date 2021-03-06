package com.ru.htccs.converter.ui;

import com.ru.htccs.converter.model.FactoryConverter;
import com.ru.htccs.converter.model.base.Converter;
import com.ru.htccs.converter.model.types.ConverterTypes;

class ConverterPresenter {
    private ConverterView converterView;
    private int dpi = 0;
    private ConverterTypes nameConverter;
    private double values = 0;

    public double getValues(){
        return values;
    }

    public void setValues(double values) {
        this.values = values;
    }

    void setNameConverter(ConverterTypes nameConverter) {
        this.nameConverter = nameConverter;
    }

    void setDpi(int dpi) {
        this.dpi = dpi;
    }

    void onAttach(ConverterView converterView) {
        this.converterView = converterView;
        Converter converter = new FactoryConverter().createConverter(nameConverter);
        values = converterView.returnValues();
        converter.resultConversion(values, dpi);
    }
}
