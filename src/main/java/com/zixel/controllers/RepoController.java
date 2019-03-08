package com.zixel.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zixel.dao.Item;
import com.zixel.dao.Repository;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RepoController {

  final static Logger logger = Logger.getLogger(RepoController.class);

  @GetMapping("/greeting")
  public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
    model.addAttribute("name", name);
    return "greeting";
  }


  @GetMapping("/getrepos")
  public String getrepos(@RequestParam(name = "name") String name, Model model) {
    model.addAttribute("name", name);


    ObjectMapper objectMapper = new ObjectMapper();
    Repository repositoryInfoPhp = new Repository(1, new ArrayList<>());
    Repository repositoryInfoJavaScript = new Repository(1, new ArrayList<>());
    try {
      repositoryInfoPhp = objectMapper.readValue(new URL("https://api.github.com/search/repositories?q=language:php"), Repository.class);
      repositoryInfoJavaScript = objectMapper.readValue(new URL("https://api.github.com/search/repositories?q=language:JavaScript"), Repository.class);

    } catch (Exception e){
      e.printStackTrace();
    }

    ArrayList<ArrayList<String>> list = new ArrayList<>();

    for(Item i: repositoryInfoPhp.getItems()){
      ArrayList<String> temp = new ArrayList<>();
      String nameItem = i.getName();
      String fullNameItem = i.getFullName();
      String login = i.getOwner().getLogin();

      temp.add(nameItem);
      temp.add(fullNameItem);
      temp.add(login);

      if(nameItem.toLowerCase().contains(name.toLowerCase())){
        list.add(temp);
      }

    }

    for(Item i: repositoryInfoJavaScript.getItems()){
      ArrayList<String> temp = new ArrayList<>();
      String nameItem = i.getName();
      String fullNameItem = i.getFullName();
      String login = i.getOwner().getLogin();

      temp.add(nameItem);
      temp.add(fullNameItem);
      temp.add(login);

      if(nameItem.toLowerCase().contains(name.toLowerCase())){
        list.add(temp);
      }

    }
    model.addAttribute("list", list);

    return "repositories";
  }

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String getOrderPage(Model model) {
    return "index";
  }
}
