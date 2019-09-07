package com.uigitdev.plantshophomepage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.uigitdev.plantshophomepage.adapter.GalleryAdapter;
import com.uigitdev.plantshophomepage.model.Pictures;
import com.uigitdev.plantshophomepage.model.Shop;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pictures> pictures;
    private ImageView shop_cover_photo, shop_logo;
    private Shop shop;
    private TextView shop_name, shop_subtitle;
    private RelativeLayout instagram_parent, facebook_parent;
    private RecyclerView recyclerView;
    private final int GRID_COLUMN = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setType();
        setAdapterType();
        initListData();
        initShop();
        setShopInfo();
        setAdapter();
    }

    private void setAdapterType() {
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, GRID_COLUMN);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    private void setAdapter() {
        GalleryAdapter galleryAdapter = new GalleryAdapter(MainActivity.this, shop, getPictureRectSize());
        recyclerView.setAdapter(galleryAdapter);
    }

    private int getPictureRectSize() {
        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        return gridWidth / GRID_COLUMN;
    }

    private void initListData() {
        pictures = new ArrayList<>();
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/69383140_2485550481490583_2649595281964246420_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/67963262_2367407163307407_5535401468767764545_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/67428816_2367250756872995_7688800847571148507_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/67348270_705779656530441_3704684935795006409_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/67308422_621067241751331_6489361575004045906_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/67232862_155919858888507_7594271827606241091_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/67065946_398157004147037_175501721157447973_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/66649767_2339844116337890_3529760264114260396_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/66413195_1579920208805061_1951971814327237948_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/64361347_440915626741940_1547629154827032535_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/64303038_1340759162739441_7635481004608560755_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/61837830_438274883693039_7383121807091719635_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/60478518_619725391832909_145630189456714102_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/59372895_604670906711277_7190855021809053465_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/58711688_564857530703520_6601318954345212590_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/55777062_883891965275599_8639462520271481894_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/54732117_988386028034317_1044955096301886696_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/54277726_318270388880366_3982793211226451572_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/53382046_731162287279135_8221304685307949006_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/52029405_2220106258317321_7197217050173178098_n.jpg"));
        pictures.add(new Pictures("http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/37126890_2196896650542010_6688090006377988096_n.jpg"));
    }

    private void setType() {
        shop_cover_photo = findViewById(R.id.shop_cover_photo);
        shop_logo = findViewById(R.id.shop_logo);
        shop_name = findViewById(R.id.shop_name);
        shop_subtitle = findViewById(R.id.shop_subtitle);
        instagram_parent = findViewById(R.id.instagram_parent);
        facebook_parent = findViewById(R.id.facebook_parent);
    }

    private void initShop() {
        shop = new Shop(
                "Haegur",
                "Hægur Plant Shop",
                "an urban, interior plant shop on peninsular Charleston. Follow the site links to learn more about our services, workshops, events and more.",
                "http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/58711688_564857530703520_6601318954345212590_n.jpg",
                "https://www.instagram.com/haegur/",
                "https://www.facebook.com/haegur/",
                "http://uigitdev.nhely.hu/project_tools_images/plant_shop_about/37126890_2196896650542010_6688090006377988096_n.jpg",
                pictures);
    }

    private void setShopInfo() {
        setShopCover();
        setShopLogo();
        setShopTitle();
        setShopSubtitle();
        socialClicks();
    }

    private void socialClicks() {
        instagram_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(shop.getInstagram());
            }
        });

        facebook_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadURL(shop.getFacebook());
            }
        });
    }

    private void loadURL(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
    }

    private void setShopTitle() {
        shop_name.setText(shop.getTitle());
    }

    private void setShopSubtitle() {
        shop_subtitle.setText(shop.getSubtitle());
    }

    private void setShopLogo() {
        Picasso.get().load(shop.getLogoURL()).fit().centerCrop().into(shop_logo, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                shop_logo.setBackgroundResource(R.drawable.ic_launcher_background);
            }
        });
    }

    private void setShopCover() {
        Picasso.get().load(shop.getCoverURL()).fit().centerCrop().into(shop_cover_photo, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                shop_cover_photo.setBackgroundResource(R.drawable.ic_launcher_background);
            }
        });
    }
}
