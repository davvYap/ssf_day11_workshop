package sg.edu.nus.iss.workshop11;

import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Workshop11Application {

    private static String DEFAULT_PORT = "8888";
    private static String port = null;

	public static void main(String[] args) {
        
        // for(String argVal: args){
        //     System.out.printf("Argument values: %s\n",argVal);
        //     if(argVal.contains("--port=")){
        //         port = argVal.substring(argVal.length() - 4, argVal.length());
        //         System.out.printf("Port number: %s\n",port);
        //     }
        // }

        // USE EXISTING CLASS TO CONDUCT THE SAME LOGIC AS ABOVE
        ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
        // check if command line contains port number
        if(cliOpts.containsOption("port")){
            port = cliOpts.getOptionValues("port").get(0);
        }

        // IF WE ARE SETTING THE ENVIRONMENT VARIABLES USING CMD: set SERVER_PORT =3000
        if(port == null){
            port = System.getenv("SERVER_PORT");
        }
        
        if(port == null || port.isBlank()){
            port = DEFAULT_PORT;
        }
        System.out.printf("Port number: %s\n",port);

        SpringApplication app = new SpringApplication(Workshop11Application.class);

        app.setDefaultProperties(Collections.singletonMap("server.port", port));

        System.out.println("Application is started on port >>> " + port);

        app.run(args);
	}

}
