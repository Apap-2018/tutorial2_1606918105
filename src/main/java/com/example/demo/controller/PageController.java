package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
  @RequestMapping("/viral")
  public String index() {
   return "viral";
  }
 
 /* @RequestMapping("/challenge")
  public String Challenge(@RequestParam(value = "name" , required = false , defaultValue = "KIKI" ) String name, Model model) { //value is parameter name when you render the website
	  model.addAttribute("name", name);
	  return "challenge";
	  
  }*/
  
  @RequestMapping(value = {"/challenge","challenge/{name}"})
  public String ChallengePath(@PathVariable Optional<String> name, Model model) {
	  if (name.isPresent()) {
		  model.addAttribute("name",name.get());
	  }
	  else {
		  model.addAttribute("name", "KB");
	  }
	  return "challenge";
  }
  //system dapat menghitung jumlah b
  //system dapat mengconvert jumlah b ke huruf hm yang ditampilkan
  //system dapat mengidentifikasikan a menunjukkan m yang ditampilkan pada satu hm
  //system dapat mengassign jika a = 0 atau a=1 atau b = 0 atau b = 1 untuk menampilkan hm 
  @RequestMapping(value="/generator")
  public String Latihanhm(@RequestParam(value="a",required = false) Integer a, @RequestParam(value="b",required = false) Integer b, Model model) {
	  if (a == null) {
		  a = 0;
	  }if (b == null) {
		  b = 0;
	  }
	  
	  String hm = "";
	  String hmtemp = "h";
	  if (a < 2) {
		  hmtemp = "hm"; 
	  }else {
		  for (int i = 0 ; i<a ; i++){
			  hmtemp +="m";
		  }
	  }
	  if (b<2) {
		  hm = hmtemp;
	  }else {
		  for (int i = 0 ; i<b ; b++) {
			  hm += hmtemp + " "; 
		  }
	  }
	  model.addAttribute("counta",a);
	  model.addAttribute("countb",b);
	  model.addAttribute("hmtemplate",hm);
	  return "latihanhm";
  }
  

}
