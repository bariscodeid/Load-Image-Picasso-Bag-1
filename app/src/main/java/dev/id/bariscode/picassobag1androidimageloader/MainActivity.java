package dev.id.bariscode.picassobag1androidimageloader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ivLoadingImagePicasso)
    ImageView ivLoadingImagePicasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Picasso.with(this) // Context diinisialisasikan yaitu Class dimana yang akan meload gambar
                .load("http://192.168.2.50/bariscode.tech/logo-bariscode.png") // URL Gambar
                .placeholder(R.drawable.not_opened) // Sebelum diinflate dengan gambar yang di download dari URL
                .error(R.drawable.error) // Jika URL Salah
                .into(ivLoadingImagePicasso); // Inflate ke ImaveView
    }
}
