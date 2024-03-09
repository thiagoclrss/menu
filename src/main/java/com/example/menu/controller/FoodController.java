package com.example.menu.controller;

import com.example.menu.food.Food;
import com.example.menu.food.FoodRepository;
import com.example.menu.food.FoodRequestDTO;
import com.example.menu.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping
    public void saveFood(@RequestBody FoodRequestDTO data){
        Food dataFood = new Food(data);
        repository.save(dataFood);
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")//essa anotação serve para definir quem pode ter acesso a esses metodos, nesse caso fazer a requisição
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
