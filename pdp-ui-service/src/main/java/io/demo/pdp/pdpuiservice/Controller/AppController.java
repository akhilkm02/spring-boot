package io.demo.pdp.pdpuiservice.Controller;

import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

   @RequestMapping("/{productId}")
   public String index() {
      return "index";
   }
   
   @RequestMapping("/")
   @Produces("text/plain")
   public String error() {
      return "error";
   }
/*   @PostMapping("/hello")
   public String sayHello(@RequestParam("name") String name, Model model) {
      model.addAttribute("name", name);
      return "hello";
   }*/
}
