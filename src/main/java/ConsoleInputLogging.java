import org.jetbrains.annotations.NotNull;



   @SuppressWarnings("FinalOrAbstractClass")
   class ConsoleInputLogging implements  InputLogging {
    @NotNull
    @Override
    @ConsoleIntercept
    public String getInput(@NotNull String input) {
        System.out.println(input );
        return input;
    }

    @Override
    public void EndOfInput()  {
        System.out.println("End of input" );
    }
}
