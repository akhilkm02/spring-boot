package io.demo.pdp.pdpuiservice.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
	
	
    @GetMapping("/{productId}")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);  
        return "index";
    }	
	
  /* 
   @RequestMapping("/{productId}")
   public String index() {
      return "index";
   }
   
   @RequestMapping("/")
   @Produces("text/plain")
   public String error() {
      return "error";
   }
  @PostMapping("/hello")
   public String sayHello(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hello";
   }*/
}
