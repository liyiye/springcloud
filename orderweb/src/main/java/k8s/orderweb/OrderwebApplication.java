package k8s.orderweb;

import k8s.util.IpUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@SpringBootApplication
public class OrderwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderwebApplication.class, args);
	}

	@GetMapping("/order")
	public String order(HttpServletRequest request) {
		return IpUtil.getIpAddr(request);
	}
}
