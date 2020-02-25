package com.example.patel.recipe;

public class IngredientsFragment extends ContentFragment {


    @Override
    public String[] getContent(int index) {
        return Recipes.ingredients[index].split("`");
    }

}
