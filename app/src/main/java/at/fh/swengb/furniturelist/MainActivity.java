package at.fh.swengb.furniturelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import at.fh.swengb.furniturelist.model.Furniture;

import static at.fh.swengb.furniturelist.R.styleable.View;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private List<Furniture> listFurniture;
    private ListView myListView;
    private CustomAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFurniture = new ArrayList<>();
        listFurniture.add(new Furniture("Norsborg","Sofa","Alte Poststraße 147, 8020 Graz",399.0,"http://www.ikea.com/at/de/catalog/products/S09124911/"));
        listFurniture.add(new Furniture("Hemnes","Shelf","Alte Poststraße 149, 8020 Graz",329.0,"http://www.ikea.com/at/de/catalog/products/70213593/"));
        listFurniture.add(new Furniture("Liatorp","Shelf","Alte Poststraße 1, 8020 Graz",349.0,"http://www.ikea.com/at/de/catalog/products/40268879/"));
        listFurniture.add(new Furniture("Arkelstorp","Table","Eggenberger Allee 5, 8020 Graz",149.0,"http://www.ikea.com/at/de/catalog/products/30260807/"));
        listFurniture.add(new Furniture("Malm","Bed","Herrengasse 10, 8010 Graz",279.0,"http://www.ikea.com/at/de/catalog/products/S99022673/"));
        listFurniture.add(new Furniture("Idolf","Chair","Neue Poststraße 147, 8020 Graz",49.99,"http://www.ikea.com/at/de/catalog/products/40228812/"));

        myListView = (ListView) findViewById(R.id.myUserList);

        myAdapter = new CustomAdapter(this,listFurniture);

        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Furniture selectedUser = listFurniture.get(i);
        Intent intent = new Intent(view.getContext(),ShowFurnitureActivity.class);
        intent.putExtra("furniture",selectedUser);
        startActivity(intent);

    }
}
