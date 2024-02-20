import java.io.IOException;
import javax.servlet.annotation.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@WebFilter(filterName = "LogFilter", urlPatterns = { "/hello" })
public class LogFilter implements Filter
{

	public void init(FilterConfig config) throws ServletException
	{
		System.out
		        .println("------------------------------------------------------");
		System.out.println(" init method is called in "
		        + this.getClass().getName());
		System.out
		        .println("------------------------------------------------------");
	}

	public void doFilter(ServletRequest req, ServletResponse res,
	        FilterChain chain) throws IOException, ServletException
	{

		 // Logguer la requ�te
        System.out.println("LoggingFilter - Requ�te intercept�e.");

        // Passer la requ�te au filtre suivant dans la cha�ne
        chain.doFilter(req, res);

        // Logguer la r�ponse
        System.out.println("LoggingFilter - R�ponse intercept�e.");

	}

	public void destroy()
	{
		// add code to release any resource
		System.out
		        .println("------------------------------------------------------");
		System.out.println(" destroy method is called in "
		        + this.getClass().getName());
		System.out
		        .println("------------------------------------------------------");
	}
}