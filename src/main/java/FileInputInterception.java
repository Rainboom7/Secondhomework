
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.jetbrains.annotations.NotNull;



 @SuppressWarnings("FinalOrAbstractClass")
 class FileInputInterception extends Interception implements MethodInterceptor {



    @NotNull
    @Override
    public Object invoke(@NotNull MethodInvocation invocation) throws Throwable {
        bufferedWriter.write( String.valueOf(count++ ));
        bufferedWriter.flush();
    return invocation.proceed();
    }
}
