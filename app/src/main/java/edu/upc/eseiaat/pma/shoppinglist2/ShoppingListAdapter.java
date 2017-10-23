package edu.upc.eseiaat.pma.shoppinglist2;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by juliaromeu on 23/10/17.
 */

//Classe ArrayAdapter que trabaja con objetos String, sino no funciona y tienes que convertirlos en (String)
public class ShoppingListAdapter extends ArrayAdapter <String> {

    //CONSTRUCTOR --> Llama al constructor de la clase ArrayAdapter
    public ShoppingListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    // GETVIEW: Función que llama al ListView cuando le quiere pedir al adaptador una de las 'pastillitas'
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //POSITION: posición de la 'pastillita'
        //CONVERTVIEW: reciclar
        //VIEWGROUP: la lista en si

        //Resultado de getView = 'pastillita'
        View result = convertView;
        //Si no hay convertView, no se está reciclando nada porque aún se está creando la lisgta nueva. La tendremos que crear nosotros una a una(Inflador)
        if (result == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            result = inflater.inflate(R.layout.shopping_item, null);

        }

        CheckBox shopping_item = (CheckBox) result.findViewById(R.id.shopping_item);
        //Pedirle al adaptador el elemento de los datos de esta posición
        String item_text = getItem(position);
        shopping_item.setText(item_text);
        return result;
    }
}
