package com.Stephanie.EjemploSesionHeroe.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.Stephanie.EjemploSesionHeroe.Model.Heroe;

@Controller
@SessionAttributes("heroesFavoritos")
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView formularioGet(Model model){
		
		if (!model.containsAttribute("heroesFavoritos")){
		model.addAttribute("heroesFavoritos", new ArrayList <Heroe>());
	} 
		model.addAttribute("heroe", new Heroe());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("formulario");
		return modelAndView;
	}
	
	@RequestMapping(value = "/formulario",
	method = RequestMethod.POST)
	public ModelAndView formularioPost(@ModelAttribute Heroe heroe,
			@ModelAttribute ("heroesFavoritos") ArrayList <Heroe> listaHeroes){
	
		ModelAndView modelAndView = new ModelAndView();
		listaHeroes.add(heroe);
		modelAndView.addObject("heroe", new Heroe ());
		modelAndView.addObject("heroesFavoritos", listaHeroes);
		modelAndView.setViewName("formulario");
		return modelAndView;

	
}	

}
