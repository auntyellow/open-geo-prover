package a.c.e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ogprover.pp.GeoGebraOGPInputProverProtocol;

public class a extends c {
	private static final String CLASS = "com.ogprover.pp.GeoGebraOGPInputProverProtocol";
	private static final Logger log = LoggerFactory.getLogger(a.class);

	public GeoGebraOGPInputProverProtocol proxy = new GeoGebraOGPInputProverProtocol();

	public void a(String geometryTheoremText) {
		log.info(CLASS + ".setGeometryTheoremText(\"{}\")", geometryTheoremText);
		proxy.setGeometryTheoremText(geometryTheoremText);
	}

	public void b(String method) {
		log.info(CLASS + ".setMethod(\"{}\")", method);
		proxy.setMethod(method);
	}

	public void a(double timeout) {
		log.info(CLASS + ".setTimeOut({})", "" + timeout);
		proxy.setTimeOut(timeout);
	}

	public void a(int maxterms) {
		log.info(CLASS + ".setMaxTerms({})", "" + maxterms);
		proxy.setMaxTerms(maxterms);
	}

	public void c(String reportFormat) {
		log.info(CLASS + ".setReportFormat({})", "" + reportFormat);
		proxy.setReportFormat(reportFormat);
	}
}