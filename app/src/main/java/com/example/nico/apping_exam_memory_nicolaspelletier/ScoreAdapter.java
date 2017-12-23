package com.example.nico.apping_exam_memory_nicolaspelletier;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nico on 19/12/2017.
 */

public class ScoreAdapter extends BaseAdapter {

    private List<Scores> data;
    private Context context;

    public ScoreAdapter(List<Scores> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Scores getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //1 : LayoutInflater pour créer les row d'index 'i'
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //2 : création des lignes qu'il va falloir afficher
        View row_view = layoutInflater.inflate(R.layout.row_view, viewGroup, false);

        //3 : on récupère les Champs à remplir depuis la row pour les remplir avec les API
        TextView winTV = row_view.findViewById(R.id.didWin);
        TextView dateTV = row_view.findViewById(R.id.date);
        TextView scoreTV = row_view.findViewById(R.id.score);

        //4 : on les rempli
        winTV.setText(getItem(i).getDidWin().toString());
        dateTV.setText(getItem(i).getDate().toString());
        scoreTV.setText(getItem(i).getScore().toString());

        //5 : on return la row correctement créée
        return row_view;
    }
}
