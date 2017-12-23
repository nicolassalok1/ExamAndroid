package com.example.nico.apping_exam_memory_nicolaspelletier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nico on 19/12/2017.
 */

public class ScoresFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.list_fragment, container, false);

        Bundle argumentsBundle = getArguments();

        String name = argumentsBundle.getString("name");
        String date = argumentsBundle.getString("date");
        String score = argumentsBundle.getString("score");
        Boolean win = argumentsBundle.getBoolean("win");


        ListView firstList = view.findViewById(R.id.first_list);
        List<Scores> data = new ArrayList<>();
        View emptylistview = view.findViewById(R.id.activity_main_text_emptylist);
        firstList.setEmptyView(emptylistview);

        if (date != null)
            data.add(new Scores(date, win, score, name));
        else
            data.add(new Scores(new String(""),new Boolean(true),new String(""),new String("")));

        firstList.setAdapter(new ScoreAdapter(data, getActivity()));

        return view;
    }
}
