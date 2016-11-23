package at.fh.swengb.furniturelist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import at.fh.swengb.furniturelist.model.Furniture;

public class ShowFurnitureActivity extends AppCompatActivity {

    private Furniture furniture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_furniture);

        Intent intent = getIntent();
        furniture = (Furniture) intent.getExtras().get("furniture");

        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        TextView textViewCategory = (TextView) findViewById(R.id.textViewCategory);
        TextView textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        TextView textViewAddress = (TextView) findViewById(R.id.textViewAddress);


        textViewName.setText(furniture.getName());
        textViewCategory.setText(furniture.getCategory());
        textViewPrice.setText(String.valueOf("Price: "+furniture.getPrice()+"€"));
        textViewAddress.setText(String.valueOf("Buy at: "+furniture.getAddress()));

    }

    public void showOnMap(View view) {
        // Map point based on address
        Uri location = Uri.parse("geo:0,0?q="+furniture.getAddress());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);
    }

    public void web(View view) {
        Uri webCall = Uri.parse(furniture.getUrl());
        Intent callIntent = new Intent(Intent.ACTION_VIEW, webCall);
        startActivity(callIntent);
    }

}
