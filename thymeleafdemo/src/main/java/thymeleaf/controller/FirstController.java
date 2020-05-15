package thymeleaf.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import thymeleaf.entity.Color;
import thymeleaf.entity.Hardware;

@Controller
public class FirstController {
	
	public List<Hardware> getHardwares() {
		List<Hardware> list = new ArrayList<>();
		Hardware h1 = new Hardware();
		h1.setName("Keyboard");
		h1.setDescription("101 keys");
		list.add(h1);
		
		Hardware h2 = new Hardware();
		h2.setName("Mouse");
		h2.setDescription("with laser technology");
		list.add(h2);
		return list;
	}
	
	@RequestMapping(value = "/home", method = {RequestMethod.GET})
	public String home() {
		return "countries"; // normal jsp
	}
	
	@RequestMapping(value = {"/colors", "/"}, method = {RequestMethod.GET})
	public String leaf(Model model) {
		List<String> colorNames = new ArrayList<>();
		colorNames.add("Violet");
		colorNames.add("Indigo");
		colorNames.add("Blue");
		colorNames.add("Green");
		colorNames.add("Yellow");
		colorNames.add("Orange");
		colorNames.add("Red");
		model.addAttribute("colorNames", colorNames);
		
		List<Color> colors = new ArrayList<>();
		colors.add(new Color("#CD5C5C", "INDIANRED"));
		colors.add(new Color("#F08080", "LIGHTCORAL"));
		colors.add(new Color("#FA8072", "SALMON"));
		colors.add(new Color("#E9967A", "LIGHTSALMON"));
		colors.add(new Color("#FFFA07A", "DARKSALMON"));
		model.addAttribute("colors", colors);
		model.addAttribute("localtime", LocalDateTime.now());
		return "color";
	}

}
