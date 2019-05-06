package io.demo.pdp.pdpuiservice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

	@GetMapping("/{productId}")
	public String getProduct(@PathVariable("productId") String productId, Model model) {
		model.addAttribute("name", productId);
		return "index";
	}

	@GetMapping("/")
	public String error(Model model) {
		model.addAttribute("error", "Empty Product Id");
		return "error";
	}
}