package IPL.helper;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Dispatcher_servlet extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] arr={Myconfig.class};		
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String[] arr= {"/"};
		return arr;
	}

}
