package ua.joreikarr.geometrycalculator;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText radiusInput = findViewById(R.id.radiusInput);
        TextView resultView = findViewById(R.id.resultView);
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radiusText = radiusInput.getText().toString();
                if (!radiusText.isEmpty()) {
                    double radius = Double.parseDouble(radiusText);
                    double area = CircleAreaCalculator.calculateArea(radius);
                    resultView.setText(String.format("Area: %.2f", area));
                } else {
                    resultView.setText("Please enter a radius");
                }
            }
        });
    }
}
