import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@FIleIntercept
 interface InputLogging {
    @NotNull
    @FIleIntercept
     String getInput(@NotNull String input) throws IOException;
    void EndOfInput() throws IOException;


}
