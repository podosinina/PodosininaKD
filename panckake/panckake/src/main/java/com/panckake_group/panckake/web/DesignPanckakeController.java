package com.panckake_group.panckake.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

import com.panckake_group.panckake.Ingredient;
import com.panckake_group.panckake.Panckake;
import com.panckake_group.panckake.PanckakeOrder;
import com.panckake_group.panckake.Ingredient.Type;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.validation.Errors;

@Slf4j
@Controller
@SessionAttributes("panckakeOrder")
@RequestMapping("/design")
public class DesignPanckakeController {

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("CLDO", "Classic Dough", Type.DOUGH),
                new Ingredient("LEDO", "Lean Dough", Type.DOUGH),

                new Ingredient("CHICK", "Chicken", Type.MEAT),
                new Ingredient("PORK", "Pork", Type.MEAT),
                new Ingredient("BE", "Beef", Type.MEAT),
                new Ingredient("SAL", "Salmon", Type.MEAT),

                new Ingredient("CHEE", "Cheese", Type.VEGGIES),
                new Ingredient("DRTO", "Dried Tomatoes", Type.VEGGIES),
                new Ingredient("POT", "Potatoes", Type.VEGGIES),
                new Ingredient("CAE", "Cabbage And Egg", Type.VEGGIES),
                new Ingredient("MUSH", "Mushrooms", Type.VEGGIES),
                new Ingredient("FRFR", "French Fries", Type.VEGGIES),
                new Ingredient("ONION", "Onion", Type.VEGGIES),
                new Ingredient("LELE", "Lettuce Leaves", Type.VEGGIES),
                new Ingredient("PICU", "Pickled Cucumbers", Type.VEGGIES),
                new Ingredient("MOZZ", "Mozzarella", Type.VEGGIES),

                new Ingredient("CH", "Сheese", Type.SAUCES),
                new Ingredient("TO", "Tomato", Type.SAUCES),
                new Ingredient("CWHOR", "Cream with horseradish", Type.SAUCES),
                new Ingredient("MUS", "Mustard", Type.SAUCES)

        );
        Type[] types = Ingredient.Type.values();
        for(Type type: types){
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name="panckakeOrder")
    public PanckakeOrder order(){
        return new PanckakeOrder();
    }

    @ModelAttribute(name="panckake")
    public Panckake panckake(){
        return new Panckake();
    }

    private Iterable<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type
    ){
        return ingredients.stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

    @PostMapping
    public String processTaco(
            @Valid Panckake panckake, Errors errors, @ModelAttribute PanckakeOrder panckakeOrder
    ){
        if (errors.hasErrors()){
            return "design";
        }
        panckakeOrder.addPanckake(panckake);
        log.info("Processing panckake: {}", panckake);
        return "redirect:/orders/current";
    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }
}

