package com.example.peperoni.disenopbl.datasource;

import android.content.Context;


import com.example.peperoni.disenopbl.R;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by msahakyan on 22/10/15.
 */
public class ExpandableListDataSource {

    /**
     * Returns fake data of films
     *
     * @param context
     * @return
     */
    public static Map<String, List<String>> getData(Context context) {
        Map<String, List<String>> expandableListData = new TreeMap<>();

        List<String> desplegableMenu = Arrays.asList(context.getResources().getStringArray(R.array.desplegables));

        List<String> servicioDesplegable = Arrays.asList(context.getResources().getStringArray(R.array.services));

        expandableListData.put(desplegableMenu.get(0), servicioDesplegable);


        return expandableListData;
    }
}
