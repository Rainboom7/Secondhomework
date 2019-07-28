import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

   final class Application {

       @NotNull
       private final Set<InputLogging> inputLogging;
       @Inject
       Application(@NotNull @Named( "File and console" )Set<InputLogging> inputLoggingSet) {

           this.inputLogging = inputLoggingSet;

       }


       public static void main(@NotNull String[] args) {

        final Injector injector = Guice.createInjector( new LoggingModule());
        injector.getInstance( Application.class ).waitForInput();

    }

     private void waitForInput(){
         try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            String inputLine;
            while (true) {
                inputLine=scanner.nextLine();
                for (InputLogging input:inputLogging
                     ) {
                input.getInput( inputLine);}

            }
        } catch (IllegalStateException | NoSuchElementException ignored ) {

        } catch ( IOException e ) {
             e.printStackTrace( );
         }

       }

}
