package k8s.liyiye.web;

import k8s.liyiye.util.IpUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
@RestController
@SpringBootApplication
public class WebApplication {
    private ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"));

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

    @GetMapping("/")
    public String retrieveTime() {
        return threadLocal.get().format(new Date());
    }
    @GetMapping("/user")
    public String user(HttpServletRequest request) {
        return IpUtil.getIpAddr(request);
    }
}
