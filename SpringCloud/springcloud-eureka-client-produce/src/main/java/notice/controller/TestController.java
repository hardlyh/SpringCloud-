package notice.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@RequestMapping("/RibbonServiceParam")
	public HashMap<String,String> RibbonServiceParam(String name,String value) {
		HashMap map = new HashMap<String,String>();
		map.put(name, name);
		map.put(value, value);
		return map;
	}
	
	@RequestMapping("/RibbonServiceBody")
	public HashMap<String,String> RibbonServiceBody(@RequestBody String name) {
		HashMap map = new HashMap<String,String>();
		map.put(name, name);
		return map;
	}
}
