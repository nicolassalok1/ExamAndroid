package com.example.nico.apping_exam_memory_nicolaspelletier;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by nico on 23/12/2017.
 */

public class GameFragment extends Fragment {

    protected int cpt = 0;
    protected List<Pair> pairList = new ArrayList<Pair>();
    protected List<ImageButton> buttonBox = new ArrayList<ImageButton>();

    protected ImageButton first = null;
    protected ImageButton second = null;
    private Integer tries = 7;
    private Integer score = 0;
    private TextView triesT = null;
    private Integer mark1 = null;
    private Integer mark2 = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.game_fragment, container, false);

        triesT = view.findViewById(R.id.scoreText);

        int i = 0;
        int randomNum = 0;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 7 + 1);
        }

        ImageButton bite0 = view.findViewById(R.id.button0);
        ImageButton bite1 = view.findViewById(R.id.button1);
        ImageButton bite2 = view.findViewById(R.id.button2);
        ImageButton bite3 = view.findViewById(R.id.button3);

        ImageButton bite5 = view.findViewById(R.id.button5);
        ImageButton bite6 = view.findViewById(R.id.button6);
        ImageButton bite7 = view.findViewById(R.id.button7);
        ImageButton bite8 = view.findViewById(R.id.button8);

        buttonBox.add(bite0);
        buttonBox.add(bite1);
        buttonBox.add(bite2);
        buttonBox.add(bite3);
        //buttonBox.add(bite4);
        buttonBox.add(bite5);
        buttonBox.add(bite6);
        buttonBox.add(bite7);
        buttonBox.add(bite8);

        do {
            pairList.add(new Pair(randomNum, 7 - randomNum));
            if (pairList.size() == 4)
                break;

            while (pairList.contains(new Pair(randomNum, 7 - randomNum)) || pairList.contains(new Pair(7 - randomNum, randomNum))) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    randomNum = ThreadLocalRandom.current().nextInt(0, 7 + 1);
                }
            }
            i++;

        } while (i < 4);

        final ArrayList<Integer> imageList = new ArrayList<>();
        for (i = 0; i < buttonBox.size(); i++) {
            buttonBox.get(i).setImageResource(R.drawable.ic_launcher_foreground);
        }

        imageList.add(R.drawable.abra);
        imageList.add(R.drawable.ball);
        imageList.add(R.drawable.oeuf);
        imageList.add(R.drawable.pikachu);

        for (int j = 0; j < pairList.size(); j++) {

            final int jj = j;

            final ImageButton b_a = buttonBox.get((Integer) pairList.get(j).first);
            final ImageButton b_b = buttonBox.get((Integer) pairList.get(j).second);

            b_a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NotifyCpt(b_a, jj);
                    b_a.setImageResource(imageList.get(jj));
                }
            });

            b_b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NotifyCpt(b_b, jj);
                    b_b.setImageResource(imageList.get(jj));
                }
            });

        }

        return view;
    }

    private void NotifyCpt(ImageButton b, Integer m) {

        triesT.setText(score.toString());

        if (cpt == 0) {
            first = b;
            mark1 = m;
            cpt++;
        } else if (cpt == 1) {
            second = b;
            mark2 = m;
            cpt++;
            if (!mark1.equals(mark2)) {
                tries--;

            } else {
                score++;
                first = null;
                second = null;
            }
        } else if (cpt == 2) {
            if (first != null && second != null) {
                first.setImageResource(R.drawable.ic_launcher_foreground);
                second.setImageResource(R.drawable.ic_launcher_foreground);
                first = null;
                second = null;
            }
            cpt = 1;
            first = b;
            mark1 = m;
        }

        if (tries <= 0 || score == 4) {
            FirstFragInteractionListener context = (FirstFragInteractionListener) getActivity();
            String date = new Date().toString();
            if (tries < 0)
                context.ShowScore(score, false, "TestNameLooser", date);
            else
                context.ShowScore(score, true, "TestNameWinner", date);
        }
        triesT.setText(score.toString());
    }
}