package at.fh.swengb.furniturelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import at.fh.swengb.furniturelist.model.Furniture;

/**
 * Created by Elli on 23.11.2016.
 */

public class CustomAdapter extends android.widget.BaseAdapter{
    List<Furniture> listFurniture;
    Context context;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, List<Furniture> listFurniture) {
        this.context = applicationContext;
        this.listFurniture= listFurniture;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return listFurniture.size();
    }

    @Override
    public Object getItem(int i) {
        return listFurniture.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null) {
            view = inflter.inflate(R.layout.row_item, null);//set layout for displaying items
        }
        TextView viewName=(TextView)view.findViewById(R.id.textViewListName);
        TextView viewCategory=(TextView)view.findViewById(R.id.textViewListCategory);
        TextView viewPrice=(TextView)view.findViewById(R.id.textViewListPrice);

        Furniture furniture = listFurniture.get(i);
        viewName.setText(furniture.getName());
        viewCategory.setText(furniture.getCategory());
        viewPrice.setText(String.valueOf(furniture.getPrice())+"€");

        return view;
    }
}
