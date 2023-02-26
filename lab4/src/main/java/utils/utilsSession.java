package utils;
import javax.servlet.http.HttpServletRequest;
public class utilsSession {
	private static utilsSession sessionUtil = null;

    public static utilsSession getInstance() {
        if (sessionUtil == null) {
            sessionUtil = new utilsSession();
        }
        return sessionUtil;
    }

    public void putValue(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public void removeValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
}
