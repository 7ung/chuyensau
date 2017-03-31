/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.controller;

import com.google.common.collect.Lists;
import com.se214h12.nhom4.model.RoomType;
import com.se214h12.nhom4.repositories.TestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Stevie
 */
@Controller
@Service
public class TestController {
    
    @Autowired(required = false)
    TestRepository repo;
    
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String index(ModelMap model){
        List<RoomType> pokemons = Lists.newArrayList(repo.findAll().iterator());
//        List<Pokemon> pokemons = dao.getAll();
        model.addAttribute("name", pokemons.get(0).getName());
        model.addAttribute("count", pokemons.size());
        return "test";
    }
}
