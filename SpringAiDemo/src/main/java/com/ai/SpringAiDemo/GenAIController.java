package com.ai.SpringAiDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenAIController {

    private final ChatService chatService;
    private final RecipeService recipeService;


    public GenAIController(ChatService chatService, RecipeService recipeService) {
        this.chatService = chatService;
        this.recipeService = recipeService;
    }

    @GetMapping("ask-ai")
    public String getResponse(@RequestParam String prompt){
        return chatService.getResponse(prompt);
    }

    @GetMapping("recipe-creator")
    public String recipeCreator(@RequestParam String ingredients,@RequestParam(defaultValue = "any") String cuisine,@RequestParam(defaultValue = "") String dietaryRestrictions){
        return recipeService.createRecipe(ingredients,cuisine,dietaryRestrictions);
    }

}
