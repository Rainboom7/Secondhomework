import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Singleton
abstract  class Interception {

   static int count=0;
    @NotNull
   static BufferedWriter bufferedWriter;
    {
        try {
            bufferedWriter = new  BufferedWriter( new FileWriter( "text.txt" ));
        } catch ( IOException e ) {
            e.printStackTrace( );
        }
    }


}
