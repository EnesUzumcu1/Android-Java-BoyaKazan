package com.example.boyakazan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.example.boyakazan.databinding.ActivityNasilOynanirEkraniBinding;

import java.util.ArrayList;

public class nasilOynanirEkrani extends AppCompatActivity {
    private ActivityNasilOynanirEkraniBinding binding;
    ArrayList<Integer> resimler;
    ArrayList<String> aciklamalar;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNasilOynanirEkraniBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        baslangic();

        binding.ileriButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == resimler.size() - 1) {
                    i = -1;
                    openActivity(girisEkrani.class);
                } else {
                    i++;
                    setGravity(i);
                    binding.resimImageView.setImageResource(resimler.get(i));
                    binding.aciklamaTextview.setText(aciklamalar.get(i));
                }

            }
        });
        binding.geriButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    i = resimler.size();
                }
                i--;
                setGravity(i);
                binding.resimImageView.setImageResource(resimler.get(i));
                binding.aciklamaTextview.setText(aciklamalar.get(i));
            }
        });
    }

    public void openActivity(Class<?> classAdi) {
        Intent intent = new Intent(this, classAdi);
        startActivity(intent);
    }

    public void baslangic() {
        i = 0;
        resimler = new ArrayList<>();
        resimler.add(R.drawable.telefonresim1);
        resimler.add(R.drawable.telefonresim2);
        resimler.add(R.drawable.telefonresim3);
        resimler.add(R.drawable.telefonresim4);
        resimler.add(R.drawable.telefonresim5);
        resimler.add(R.drawable.telefonresim6);
        resimler.add(R.drawable.telefonresim7);
        resimler.add(R.drawable.telefonresim8);
        resimler.add(R.drawable.telefonresim9);
        //0-255 arasi deger alir
        binding.resimImageView.setImageAlpha(150);
        aciklamalar = new ArrayList<>();
        aciklamalar.add("Oyunumuz ekran??n ??st??nde bulunan 10 adet butonla oynanmaktad??r.");
        aciklamalar.add("Ayarlar sayfas??ndan oyuncu isimleri ve renklerini belirleyebilirsiniz.");
        aciklamalar.add("Her butona t??klamada s??ra di??er oyuncuya ge??er.");
        aciklamalar.add("T??klanan butonun en alt??nda bulunan ve boyanmam???? en alt sat??rdan itibaren boyanmaya ba??lan??r.");
        aciklamalar.add("Oyunu kazanmak i??in ayn?? renkten 4 kare D??KEY,");
        aciklamalar.add("??apraz,");
        aciklamalar.add("??apraz,");
        aciklamalar.add("Veya Yatay konumda olmal??d??r.");
        aciklamalar.add("Bir oyuncu 4'l??s??n?? yap??nca oyun biter ve kazanan??n ismi yazar.");

        binding.aciklamaTextview.setText(aciklamalar.get(0));
        binding.resimImageView.setImageResource(resimler.get(0));
    }

    public void setGravity(int i) {
        if (i == resimler.size() - 1) {
            binding.aciklamaTextview.setGravity(Gravity.NO_GRAVITY);
        } else {
            binding.aciklamaTextview.setGravity(Gravity.CENTER);
        }
    }

    @Override
    public void onBackPressed() {
        openActivity(girisEkrani.class);
        finish();
        super.onBackPressed();
    }

}