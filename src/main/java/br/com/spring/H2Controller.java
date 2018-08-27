package br.com.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class H2Controller {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
