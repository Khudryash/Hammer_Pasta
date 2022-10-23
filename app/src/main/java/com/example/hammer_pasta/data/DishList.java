package com.example.hammer_pasta.data;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hammer_pasta.Menu;
import com.example.hammer_pasta.PastaMenu;
import com.example.hammer_pasta.adapter.FoodAdapter;
import com.example.hammer_pasta.model.FoodModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DishList extends AsyncTask<String, Void, List<FoodModel>> {

    String category;
    @SuppressLint("StaticFieldLeak")
    Context ctx;
    @SuppressLint("StaticFieldLeak")
    RecyclerView recyclerView;

    public DishList(String category, Context ctx, RecyclerView recyclerView) throws IOException, InterruptedException {
        this.category = category;
        this.ctx = ctx;
        this.recyclerView = recyclerView;
    }

    @Override
    protected List<FoodModel> doInBackground(String... strings) {
        List<FoodModel> foodModelList = new ArrayList<>();
        DishData dishData = null;
        try {
            dishData = new DishData(
                    "https://www.themealdb.com/api/json/v1/1/filter.php?c="+category,
                    "meals",
                    "idMeal"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert dishData != null;
        List<String> names = dishData.getNames();

        for (int i = 0; i < names.size(); i++) {

            List<String> data = null;
            try {
                data = new DishData(
                        "https://www.themealdb.com/api/json/v1/1/lookup.php?i="+names.get(i),
                        "meals",
                        "strMeal", "strArea", "strMealThumb"
                ).getNames();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert data != null;
            foodModelList.add(new FoodModel(
                    data.get(0),
                    data.get(1),
                    data.get(2)
            ));
        }
        return foodModelList;
    }

    @Override
    protected void onPostExecute(List<FoodModel> s) {
        super.onPostExecute(s);
        FoodAdapter foodAdapter;

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.ctx, RecyclerView.VERTICAL, false);
        this.recyclerView.setLayoutManager(layoutManager);
        foodAdapter = new FoodAdapter(this.ctx, s);
        this.recyclerView.setAdapter(foodAdapter);
    }
}
