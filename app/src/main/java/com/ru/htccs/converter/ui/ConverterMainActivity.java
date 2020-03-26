package com.ru.htccs.converter.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ru.htccs.converter.R;

public class ConverterMainActivity extends AppCompatActivity implements  ConverterView{
    final int LOW = 1;
    final int MEDIUM = 2;
    final int HIGH = 3;
    final int EXTRA_HIGH = 4;
    final int EXTRA_EXTRA_HIGH = 5;
    final int EXTRA_EXTRA_EXTRA_HIGH = 6;

    TextView textView;
    ConverterPresenter converterPresenter = new ConverterPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.context_menu);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.context_menu) {
            menu.add(0, LOW, 0, "ldpi (low) ~120dpi");
            menu.add(0, MEDIUM, 0, "mdpi (medium) ~160dpi");
            menu.add(0, HIGH, 0, "hdpi (high) ~240dpi");
            menu.add(0, EXTRA_HIGH, 0, "xhdpi (extra-high) ~320dpi");
            menu.add(0, EXTRA_EXTRA_HIGH, 0, "xxhdpi (extra-extra-high) ~480dpi");
            menu.add(0, EXTRA_EXTRA_EXTRA_HIGH, 0, "xxxhdpi (extra-extra-extra-high) ~640dpi");
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case LOW:
                converterPresenter.setDpi(120);
                textView.setText("ldpi (low) ~120dpi");
                break;
            case MEDIUM:
                converterPresenter.setDpi(160);
                textView.setText("mdpi (medium) ~160dpi");
                break;
            case HIGH:
                converterPresenter.setDpi(240);
                textView.setText("hdpi (high) ~240dpi");
                break;
            case EXTRA_HIGH:
                converterPresenter.setDpi(320);
                textView.setText("xhdpi (extra-high) ~320dpi");
                break;
            case EXTRA_EXTRA_HIGH:
                converterPresenter.setDpi(480);
                textView.setText("xxhdpi (extra-extra-high) ~480dpi");
                break;
            case EXTRA_EXTRA_EXTRA_HIGH:
                converterPresenter.setDpi(640);
                textView.setText("xxxhdpi (extra-extra-extra-high) ~640dpi");
                break;
        }
        return super.onContextItemSelected(item);
    }
}
