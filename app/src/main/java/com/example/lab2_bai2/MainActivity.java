package com.example.lab2_bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button startLoadingButton;
    private ImageView animalImage;
    private TextView animalText;
    private View darkOverlay;
    private TextView successText;
    private ImageView icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        startLoadingButton = findViewById(R.id.button);
        animalImage = findViewById(R.id.animalImage);
        animalText = findViewById(R.id.animalText);
        darkOverlay = findViewById(R.id.darkOverlay);

        // Xử lý khi nhấn nút "Start Loading"
        startLoadingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ẩn hình chú chim, chữ, và nút
                animalImage.setVisibility(View.GONE);
                animalText.setVisibility(View.GONE);
                startLoadingButton.setVisibility(View.GONE);

                // Hiển thị lớp phủ tối và ProgressBar
                darkOverlay.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                // Giả lập quá trình loading trong 5 giây
                progressBar.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Sau khi loading xong, ẩn ProgressBar và lớp phủ
                        progressBar.setVisibility(View.GONE);
                        darkOverlay.setVisibility(View.GONE);

                        // Bạn có thể hiển thị hình ảnh hoặc message khác sau khi hoàn thành
                        icon = findViewById(R.id.icon);
                        icon.setVisibility(View.VISIBLE);
                        successText = findViewById(R.id.successText);
                        successText.setVisibility(View.VISIBLE);
                    }
                }, 5000);// 5 giây
            }
        });

    }
}
