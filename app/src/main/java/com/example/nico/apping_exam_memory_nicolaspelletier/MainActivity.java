package com.example.nico.apping_exam_memory_nicolaspelletier;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements FirstFragInteractionListener{

    final FragmentManager fragmentManager = getSupportFragmentManager();
    public static Integer newScore = null;
    public static String namee = null;
    public static String datee = null;
    public static Boolean win = null;

    public static Boolean isBundleSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);

        // 1 : On Recupere le composant XML qui va gerer l'enchainement des vues
        ViewPager viewPager = findViewById(R.id.main_viewpager);
        // 2 : Création de l'Adapter
        CustomViewpagerAdapter viewpagerAdapter = new CustomViewpagerAdapter(fragmentManager);
        // 3 : liaison de l'adapter au composant XML
        viewPager.setAdapter(viewpagerAdapter);

        viewPager.setCurrentItem(0);
    }

    @Override
    public void ButtonClickG() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Memory_Game"));//valeur est l'url à accéder
        startActivity(intent);
    }

    @Override
    public void ButtonClickStart() {
        ViewPager viewPager = findViewById(R.id.main_viewpager);
        viewPager.setCurrentItem(2);
    }

    public void ShowScore(Integer score, Boolean b, String nameWinner, String date) {
        ViewPager viewPager = findViewById(R.id.main_viewpager);

        isBundleSet = true;
        newScore = score;
        win = b;
        namee = nameWinner;
        datee = date;

        viewPager.setCurrentItem(1);
    }

    /**
     * Created by nico on 05/12/2017.
     */

    static class CustomViewpagerAdapter extends FragmentPagerAdapter {

        public CustomViewpagerAdapter(FragmentManager fm)
        {
            super(fm);
        }
        private static final int NB_PAGES = 3;

        @Override
        public Fragment getItem(int position)
        {
            Fragment f;
            switch (position)
            {
                case 1 :
                    f = new ScoresFragment();
                    Bundle bundle = new Bundle();
                    if (isBundleSet) {
                        bundle.putString("score", String.valueOf(newScore));//need to know how to set the bundle before changing fragment
                        bundle.putBoolean("win", Boolean.valueOf(win));
                        bundle.putString("date", String.valueOf(namee));
                        bundle.putString("name", String.valueOf(datee));
                    }
                    f.setArguments(bundle);
                    break;
                case 2 :
                    f = new GameFragment();
                    break;
                default:
                    f = new HelloFragment();
                    break;
            }
            return f;
        }

        @Override
        public int getCount()
        {
            return NB_PAGES;
        }

    }
}