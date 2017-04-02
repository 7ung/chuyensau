/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se214h12.nhom4.controller;

import com.google.common.collect.Lists;
import com.se214h12.nhom4.model.RoomType;
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
    
    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String index(ModelMap model){
        return "test";
    }
}
