package io.dobtech.springwebdb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Controller
public class IndexController {

    private static final String[] ENV_DB_URL = new String[]{"OPENSHIFT_MONGODB_DB_URL", "MONGO_URL"};

    @RequestMapping("/")
    public String index(Model model) throws UnknownHostException {

        // Server IP
        InetAddress ip = InetAddress.getLocalHost();
        model.addAttribute("server_ip", ip.getHostAddress());

        String dbUrl = null;
        for (String v: ENV_DB_URL) {
            if (System.getenv().containsKey(v)) {
                dbUrl = System.getenv(v);
            }
        }
        model.addAttribute("db_url", dbUrl);

        // Forward to the index view
        return "index";
    }

}
