package a.c.a;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ogprover.api.GeoGebraOGPInterface;
import com.ogprover.pp.GeoGebraOGPOutputProverProtocol;

import a.c.Proxy;
import a.c.e.b;
import a.c.e.c;
import a.c.e.d;

public class a {
	private static final String CLASS = "com.ogprover.api.GeoGebraOGPInterface";
	private static final Logger log = LoggerFactory.getLogger(a.class);

	private GeoGebraOGPInterface proxy = new GeoGebraOGPInterface();

	public d a(c proverInput) {
		log.info(CLASS + ".prove(OGPInputProverProtocol)");
		b b = new b();
		b.proxy = (GeoGebraOGPOutputProverProtocol)
				proxy.prove(Proxy.getGeoGebraOGPInputProverProtocol(proverInput));
		return b;
	}
}