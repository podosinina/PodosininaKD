package com.panckake_group.panckake.web;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;
import com.panckake_group.panckake.Ingredient;
import com.panckake_group.panckake.Ingredient.Type;;


@Component
public class IngredientConverter {
    private final Map<String, Ingredient> ingredientMap;

    public IngredientConverter() {
        ingredientMap = new HashMap<>();
        ingredientMap.put("CLDO", new Ingredient("CLDO", "Classic Dough", Type.DOUGH));
        ingredientMap.put("LEDO", new Ingredient("LEDO", "Lean Dough", Type.DOUGH));

        ingredientMap.put("CHICK", new Ingredient("CHICK", "Chicken", Type.MEAT));
        ingredientMap.put("PORK", new Ingredient("PORK", "Pork", Type.MEAT));
        ingredientMap.put("BE", new Ingredient("BE", "Beef", Type.MEAT));
        ingredientMap.put("SAL", new Ingredient("SAL", "Salmon", Type.MEAT));

        ingredientMap.put("CHEE", new Ingredient("CHEE", "Cheese", Type.VEGGIES));
        ingredientMap.put("DRTO", new Ingredient("DRTO", "Dried Tomatoes", Type.VEGGIES));
        ingredientMap.put("POT", new Ingredient("POT", "Potatoes", Type.VEGGIES));
        ingredientMap.put("CAE", new Ingredient("CAE", "Cabbage And Egg", Type.VEGGIES));
        ingredientMap.put("MUSH", new Ingredient("MUSH", "Mushrooms", Type.VEGGIES));
        ingredientMap.put("FRFR", new Ingredient("FRFR", "French Fries", Type.VEGGIES));
        ingredientMap.put("ONION", new Ingredient("ONION", "Onion", Type.VEGGIES));
        ingredientMap.put("LELE", new Ingredient("LELE", "Lettuce Leaves", Type.VEGGIES));
        ingredientMap.put("PICU", new Ingredient("PICU", "Pickled Cucumbers", Type.VEGGIES));
        ingredientMap.put("MOZZ", new Ingredient("MOZZ", "Mozzarella", Type.VEGGIES));

        ingredientMap.put("CH", new Ingredient("CH", "Сheese", Type.SAUCES));
        ingredientMap.put("TO", new Ingredient("TO", "Tomato", Type.SAUCES));
        ingredientMap.put("CWHOR", new Ingredient("CWHOR", "Cream with horseradish", Type.SAUCES));
        ingredientMap.put("MUS", new Ingredient("MUS", "Mustard", Type.SAUCES));

    }

}

