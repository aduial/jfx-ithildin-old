package aduial.ithildin;

import aduial.ithildin.application.IthildinApplication;
import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * IthildinFxWeaverBootApplication.
 *
 * @author Lúthien
 */
@SpringBootApplication
public class IthildinFxWeaverBootApplication{

    public static void main(String[] args) {
        Application.launch(IthildinApplication.class, args);
    }

}
