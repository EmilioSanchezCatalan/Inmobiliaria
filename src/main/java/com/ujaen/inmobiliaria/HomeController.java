package com.ujaen.inmobiliaria;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ujaen.dao.DaoPiso;
import com.ujaen.dto.DtoPiso;


@Controller
public class HomeController {

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/Jpisos", method = RequestMethod.GET)
	public String jpisos(Model model){
		DaoPiso dao = new DaoPiso();
		ArrayList<DtoPiso> lpisos = dao.listar();
		model.addAttribute("lpisos", lpisos);
		return "jpisos";
	}
	
}
