import org.jetbrains.annotations.NotNull;

import java.io.IOException;

  @SuppressWarnings("FinalOrAbstractClass")
  class FileInputLogging extends Interception  implements InputLogging {





    @NotNull
    @Override
    @FIleIntercept
    public String getInput(@NotNull String input) throws IOException {
        bufferedWriter.write( "<a>" );
        bufferedWriter.write( input );
        bufferedWriter.write( "</a>" );
        bufferedWriter.write( "  " );
        bufferedWriter.flush();
        return input;
    }

    @Override
    public void EndOfInput() throws IOException {
        bufferedWriter.close();
    }
}
