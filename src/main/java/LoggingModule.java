import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Names;

final class LoggingModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<InputLogging> consoleBinder= Multibinder.newSetBinder( binder(),InputLogging.class,Names.named( "Console" ) );
        consoleBinder.addBinding().to( ConsoleInputLogging.class );
        Multibinder<InputLogging> fileBinder= Multibinder.newSetBinder( binder(),InputLogging.class,Names.named( "File" ) );
        fileBinder.addBinding().to(FileInputLogging.class );
        Multibinder<InputLogging> bothBinder= Multibinder.newSetBinder( binder(),InputLogging.class,Names.named( "File and console" ) );
        bothBinder.addBinding().to( ConsoleInputLogging.class );
        bothBinder.addBinding().to( FileInputLogging.class );
        bindInterceptor( Matchers.any(),Matchers.annotatedWith( FIleIntercept.class ),new FileInputInterception());
        bindInterceptor( Matchers.any(),Matchers.annotatedWith( ConsoleIntercept.class ),new ConsoleInputInterception() );

    }
}
