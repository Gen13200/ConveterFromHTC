package com.ru.htccs.converter.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ru.htccs.converter.R;
import static com.ru.htccs.converter.model.types.ConverterTypes.*;


public class ConverterMainActivity extends AppCompatActivity implements ConverterView, View.OnClickListener {
    final int LOW = 1;
    final int MEDIUM = 2;
    final int HIGH = 3;
    final int EXTRA_HIGH = 4;
    final int EXTRA_EXTRA_HIGH = 5;
    final int EXTRA_EXTRA_EXTRA_HIGH = 6;

    TextView textView;
    TextView contextMenu;
    TextView viewDp;
    TextView viewSp;
    TextView viewPx;
    TextView viewMm;
    TextView viewPt;
    TextView viewIn;

    EditText editText;
    Button plus;
    Button minus;

    ConverterPresenter converterPresenter = new ConverterPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView.findViewById(R.id.information);
        contextMenu.findViewById(R.id.context_menu);
        viewDp.findViewById(R.id.viewDp).setOnClickListener(this);
        viewSp.findViewById(R.id.viewSp).setOnClickListener(this);
        viewPx.findViewById(R.id.viewPx).setOnClickListener(this);
        viewMm.findViewById(R.id.viewMm).setOnClickListener(this);
        viewPt.findViewById(R.id.viewPt).setOnClickListener(this);
        viewIn.findViewById(R.id.viewIn).setOnClickListener(this);
        plus.findViewById(R.id.button_plus).setOnClickListener(this);
        minus.findViewById(R.id.button_minus).setOnClickListener(this);

        converterPresenter.onAttach(this);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
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
                contextMenu.setText("ldpi (low) ~120dpi");
                break;
            case MEDIUM:
                converterPresenter.setDpi(160);
                contextMenu.setText("mdpi (medium) ~160dpi");
                break;
            case HIGH:
                converterPresenter.setDpi(240);
                contextMenu.setText("hdpi (high) ~240dpi");
                break;
            case EXTRA_HIGH:
                converterPresenter.setDpi(320);
                contextMenu.setText("xhdpi (extra-high) ~320dpi");
                break;
            case EXTRA_EXTRA_HIGH:
                converterPresenter.setDpi(480);
                contextMenu.setText("xxhdpi (extra-extra-high) ~480dpi");
                break;
            case EXTRA_EXTRA_EXTRA_HIGH:
                converterPresenter.setDpi(640);
                contextMenu.setText("xxxhdpi (extra-extra-extra-high) ~640dpi");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.viewDp:
                converterPresenter.setNameConverter(DP);
                textView.setText("dp is abstract unit which is based\n" +
                        "on the physical density of the screen.\n" +
                        "It keeps exact dimensions allowing some physical size\n" +
                        "variation depending on device density(dpi).");
                break;
            case R.id.viewSp:
                converterPresenter.setNameConverter(SP);
                textView.setText("sp is same as dp unit, but it scaled depands by\n" +
                        "the user's font size preference.\n" +
                        "go Settings (Phone) > Accessibility to check user's font size ");
                break;
            case R.id.viewPx:
                converterPresenter.setNameConverter(PX);
                textView.setText("pixel is a single dot in the screen.\n" +
                        "The counts of pixels in screen area define as dpi (dots per inch). \n" +
                        "120 dpi is equivalent to total pixel count in one inch");
                break;
            case R.id.viewMm:
                converterPresenter.setNameConverter(MM);
                textView.setText("unit of measurement based on the physical size of the screen");
                break;
            case R.id.viewPt:
                converterPresenter.setNameConverter(PT);
                textView.setText("pt is exactly the same physical size on every density,\n" +
                        "which is 72(more accurately 72.27) points per inch. \n" +
                        "Android converts pt to px using the exact dpi of the device's screen.");
                break;
            case R.id.viewIn:
                converterPresenter.setNameConverter(IN);
                textView.setText("unit of measurement based on the physical size of the screen");
                break;
            case R.id.button_plus:
                converterPresenter.setValues(converterPresenter.getValues() + 1);
                break;
            case R.id.button_minus:
                converterPresenter.setValues(converterPresenter.getValues() - 1);
                break;
        }
    }

    public double returnValues() {
        return Double.parseDouble(String.valueOf(editText.getText()));
    }
}
