package nio.uri;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class TestUri {

	public static void main(String[] args) throws URISyntaxException {
		URI uri = new URI("file:///C:/Users/neo/Desktop/1.jpg");
		URI uri2 = URI.create("C:/Users/neo/Desktop/1.jpg");
		System.out.println(uri.isAbsolute());
		System.out.println(uri2.isAbsolute());
		System.out.println(uri.isOpaque());
		System.out.println(uri.getScheme());
		System.out.println(uri.getHost());
		System.out.println(uri.getPath());
		System.out.println(Paths.get("C:/Users/neo/Desktop/1.jpg").toString());
		System.out.println(uri.getUserInfo());
		System.out.println(uri.getQuery());
		System.out.println(uri.getAuthority());
		System.out.println(uri.getFragment());
		System.out.println(uri.getPort());
		System.out.println(uri.getRawQuery());
		System.out.println(uri.getRawSchemeSpecificPart());
		System.out.println(uri.getRawFragment());
		System.out.println(uri.getRawUserInfo());
	}
}
