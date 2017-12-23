package com.example.nico.apping_exam_memory_nicolaspelletier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by nico on 19/12/2017.
 */

public class HelloFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_main, container, false);

        Button b_google = view.findViewById(R.id.b_google);
        b_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragInteractionListener context = (FirstFragInteractionListener) getActivity();
                context.ButtonClickG();
            }
        });

        Button b_start = view.findViewById(R.id.b_start);
        b_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragInteractionListener context = (FirstFragInteractionListener) getActivity();
                context.ButtonClickStart();
            }
        });

        return view;
    }

}

interface FirstFragInteractionListener
{
    void ButtonClickG();
    void ButtonClickStart();
    void ShowScore(Integer score, Boolean b, String nameWinner, String testNameWinner);
}