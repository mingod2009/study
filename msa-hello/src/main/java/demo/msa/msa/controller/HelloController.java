package demo.msa.msa.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public class HelloController {

	@RequestMapping(method=RequestMethod.GET, path="/hello")
    public String hello() {
    	return "hello msa";
    }
}
