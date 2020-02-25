package com.example.patel.recipe;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;


public abstract class ContentFragment extends Fragment {

    private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
    CheckBox[] setCheckBoxes;
    boolean[] checkboxes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        int index = getArguments().getInt(MainActivity.KEY_RECIPE_INDEX);

        View view = inflater.inflate(R.layout.content_layout, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.contentLayout);


        //String[] content = Recipes.content[index].split("`");
        String[] contents = getContent(index);

        setCheckBoxes = new CheckBox[contents.length];
        checkboxes = new boolean[setCheckBoxes.length];

        if(savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null){
            checkboxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
        }

        setUpCheckBoxes(contents, linearLayout, checkboxes);

        return view;
    }

    public abstract String[] getContent(int index);


    private void setUpCheckBoxes(String[] contents, ViewGroup container, boolean[] checkboxes) {

        int i = 0;
        for (String content : contents){
            setCheckBoxes[i] = new CheckBox(getActivity());
            setCheckBoxes[i].setPadding(8, 16, 8 ,16);
            setCheckBoxes[i].setTextSize(20f);
            setCheckBoxes[i].setText(content);
            container.addView(setCheckBoxes[i]);

            if(checkboxes[i]){
                setCheckBoxes[i].toggle();
            }
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        boolean[] stateOfCheckedBoxes = new boolean[setCheckBoxes.length];

        int i = 0;
        for(CheckBox checkBox : setCheckBoxes) {
            stateOfCheckedBoxes[i] = checkBox.isChecked();
            i++;
        }

        outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckedBoxes);

        super.onSaveInstanceState(outState);
    }
}
