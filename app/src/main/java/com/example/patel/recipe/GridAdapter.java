package com.example.patel.recipe;

import android.widget.Toast;

class GridAdapter extends RecyclerAdapter{


    private final GridFragment.OnRecipeSelectedInterface listener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        this.listener = listener;
    }


    @Override
    public int getLayoutID() {
        return R.layout.list_item;
    }


    @Override
    protected void onRecipeSelected(int index) {
        listener.onGridRecipeSelected(index);
    }

}
