package br.com.formandoideias.apresentacao.helper;

import br.com.formandoideias.vo.UsuarioFBVO;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class FacebookAuthHelper {

	private static final String API_KEY = "1412333662348403";
	private static final String SECRET = "3de3485b6ac82fc89d003be2e751c66b";
	private static final String CLIENT_ID = "1412333662348403";

	private static final String REDIRECT_URI = "http://localhost:8080/formandoideias/home/home.jsf";

	private static final String[] PERM = new String[] { "email" };

	public static String getAPIKey() {
		return API_KEY;
	}

	public static String getSecret() {
		return SECRET;
	}

	public static String getLoginRedirectURL() {
		return "https://graph.facebook.com/oauth/authorize?client_id="
				+ CLIENT_ID + "&display=page&redirect_uri=" + REDIRECT_URI
				+ "&scope=" + delimitObjectsToString(",", PERM);
	}

	public static String getAuthURL(String authCode) {
		return "https://graph.facebook.com/oauth/access_token?client_id="
				+ CLIENT_ID + "&redirect_uri=" + REDIRECT_URI
				+ "&client_secret=" + SECRET + "&code=" + authCode;
	}
	
    public void authFacebookLogin(String accessToken, int expires) {
        try {
        	FacebookClient fb = new DefaultFacebookClient(accessToken);
            
            UsuarioFBVO user = fb.fetchObject("me", UsuarioFBVO.class);

            System.out.println(user);

        } catch (Throwable ex) {
            throw new RuntimeException("failed login", ex);
        }
    }

	private static String delimitObjectsToString(String delimiter, String[] list) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.length - 1; i++) {
			buffer.append(list[i]);
			buffer.append(delimiter);
		}

		buffer.append(list[list.length - 1]);

		return buffer.toString();
	}
}
