
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;



public final class ConsoleInputInterception extends Interception implements MethodInterceptor  {
    private int consoleCount=1;
    @NotNull
    @Override
    public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {

        System.out.println(count++);
        if ( (consoleCount % 3) == 0 ){
            System.out.println("3-fold input" );
        }
        consoleCount++;
        return invocation.proceed();
    }



    }

