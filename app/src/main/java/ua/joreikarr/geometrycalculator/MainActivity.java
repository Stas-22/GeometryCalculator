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
        EditText squareSideInput = findViewById(R.id.squareSideInput);
        EditText rectangleLengthInput = findViewById(R.id.rectangleLengthInput);
        EditText rectangleWidthInput = findViewById(R.id.rectangleWidthInput);
        EditText triangleBaseInput = findViewById(R.id.triangleBaseInput);
        EditText triangleHeightInput = findViewById(R.id.triangleHeightInput);
        TextView resultView = findViewById(R.id.resultView);
        Button calculateCircleButton = findViewById(R.id.calculateCircleButton);
        Button calculateSquareButton = findViewById(R.id.calculateSquareButton);
        Button calculateRectangleButton = findViewById(R.id.calculateRectangleButton);
        Button calculateTriangleButton = findViewById(R.id.calculateTriangleButton);

        calculateCircleButton.setOnClickListener(new View.OnClickListener() {
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
        calculateSquareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sideText = squareSideInput.getText().toString();
                if (!sideText.isEmpty()) {
                    double sideLength = Double.parseDouble(sideText);
                    double area = SquareAreaCalculator.calculateArea(sideLength);
                    resultView.setText(String.format("Square Area: %.2f", area));
                } else {
                    resultView.setText("Please enter a side length.");
                }
            }
        });

        calculateRectangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lengthText = rectangleLengthInput.getText().toString();
                String widthText = rectangleWidthInput.getText().toString();
                if (!lengthText.isEmpty() && !widthText.isEmpty()) {
                    double length = Double.parseDouble(lengthText);
                    double width = Double.parseDouble(widthText);
                    double area = RectangleAreaCalculator.calculateArea(length, width);
                    resultView.setText(String.format("Rectangle Area: %.2f", area));
                } else {
                    resultView.setText("Please enter both length and width.");
                }
            }
        });

        calculateTriangleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String baseText = triangleBaseInput.getText().toString();
                String heightText = triangleHeightInput.getText().toString();
                if (!baseText.isEmpty() && !heightText.isEmpty()) {
                    double base = Double.parseDouble(baseText);
                    double height = Double.parseDouble(heightText);
                    double area = TriangleAreaCalculator.calculateArea(base, height);
                    resultView.setText(String.format("Triangle Area: %.2f", area));
                } else {
                    resultView.setText("Please enter both base and height.");
                }
            }
        });

    }
}
