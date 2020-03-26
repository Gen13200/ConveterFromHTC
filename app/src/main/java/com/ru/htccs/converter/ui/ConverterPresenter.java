package com.ru.htccs.converter.ui;

class ConverterPresenter {
    private ConverterView converterView;
    private int dpi = 0;

    ConverterPresenter(ConverterView converterView){
        this.converterView = converterView;
    }

    public int getDpi() {
        return dpi;
    }

    void setDpi(int dpi) {
        this.dpi = dpi;
    }
}
