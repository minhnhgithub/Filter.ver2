package filter.v2.main.dumbhead;

import java.net.URI;
import java.util.Arrays;

public class BareBonesBrowserLaunch {
	static final String[] browsers = { "google-chrome", "firefox", "opera",
			"epiphany", "konqueror", "conkeror", "midori", "kazehakase",
			"mozilla" };
	static final String errMsg = "Error attempting to launch web browser";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void openUrl(String url) {
		try {
			Class d = Class.forName("java.awt.Desktop");
			d.getDeclaredMethod("browse", new Class[] { URI.class }).invoke(
					d.getDeclaredMethod("getDesktop", new Class[0]).invoke(
							null, new Object[0]),
					new Object[] { URI.create(url) });
		} catch (Exception ignore) {
			String osName = System.getProperty("os.name");
			try {
				if (osName.startsWith("Mac OS")) {
					Class.forName("com.apple.eio.FileManager")
							.getDeclaredMethod("openURL",
									new Class[] { String.class })
							.invoke(null, new Object[] { url });
				} else if (osName.startsWith("Windows")) {
					Runtime.getRuntime().exec(
							"rundll32 url.dll,FileProtocolHandler " + url);
				} else {
					String browser = null;
					for (String b : browsers)
						if (browser == null) {
							if (Runtime.getRuntime()
									.exec(new String[] { "which", b })
									.getInputStream().read() == -1)
								continue;
							String[] tmp208_205 = new String[2];
							String tmp212_210 = b;
							browser = tmp212_210;
							tmp208_205[0] = tmp212_210;
							String[] tmp215_208 = tmp208_205;
							tmp215_208[1] = url;

							Runtime.getRuntime().exec(tmp215_208);
						}
					if (browser == null)
						throw new Exception(Arrays.toString(browsers));
				}
			} catch (Exception e) {
				System.out.println("Error attempting to launch web browser\n"
						+ e.toString());
			}
		}
	}
}
