package com.example.patel.recipe;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface{

    public static final String LIST_FRAGMENT = "list_fragment";
    private static final String GRID_FRAGMENT = "grid_fragment" ;
    public static final String VIEWPAGER_FRAGMENT = "viewpager_fragment";
    public static final String KEY_RECIPE_INDEX = "key_recipe_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean isTablet = getResources().getBoolean(R.bool.is_tablet);

        if(!isTablet){
            ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);

            if (savedFragment == null) {

                ListFragment listFragment = new ListFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeholder, listFragment, LIST_FRAGMENT);
                fragmentTransaction.commit();

            }
        }
        else {
            GridFragment savedFragment = (GridFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);

            if (savedFragment == null) {

                GridFragment gridFragment = new GridFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.placeholder, gridFragment, LIST_FRAGMENT);
                fragmentTransaction.commit();

            }
        }


    }


    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        viewPagerFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, viewPagerFragment, VIEWPAGER_FRAGMENT);
        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        GridFragment gridFragment = new GridFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        gridFragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, gridFragment, GRID_FRAGMENT);
        fragmentTransaction.commit();
    }
}
