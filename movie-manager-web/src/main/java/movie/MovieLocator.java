package movie;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;

import movie.j2ee.interfaces.RemoteMovieManager;

public class MovieLocator {
	public RemoteMovieManager lookup() {
		final Hashtable<String, Object> props = new Hashtable<String, Object>();
        props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        Context context = null;
		try {
			context = new javax.naming.InitialContext(props);
			return (RemoteMovieManager) context.lookup("ejb:" + "slave" + "/" + "movie-manager-ejb-1.0.0-SNAPSHOT" + "/" + "" + "/" +
					"MovieManagerSessionBean" + "!" + "movie.j2ee.interfaces.RemoteMovieManager");
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			try {
				if (context != null) {
					context.close();
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
