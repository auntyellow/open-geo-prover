package a.c.e;

import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ogprover.pp.GeoGebraOGPOutputProverProtocol;

public class b extends d {
	private static final String CLASS = "com.ogprover.pp.GeoGebraOGPOutputProverProtocol";
	private static final Logger log = LoggerFactory.getLogger(b.class);

	public GeoGebraOGPOutputProverProtocol proxy;

	public Vector<String> a() {
		log.info(CLASS + ".getNdgList()");
		return proxy.getNdgList();
	}

	public String a(String resName) {
		log.info(CLASS + ".getOutputResult(\"{}\")", resName);
		return proxy.getOutputResult(resName);
	}
}