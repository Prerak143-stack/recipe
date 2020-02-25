package com.example.patel.recipe;

public class ListAdapter extends RecyclerAdapter {


    private final ListFragment.OnRecipeSelectedInterface listener;

    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        this.listener = listener;
    }


    @Override
    public int getLayoutID() {
        return R.layout.list_item;
    }


    @Override
    protected void onRecipeSelected(int index) {
        listener.onListRecipeSelected(index);
    }

}
