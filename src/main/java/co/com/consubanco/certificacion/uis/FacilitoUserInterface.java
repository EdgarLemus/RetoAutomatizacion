package co.com.consubanco.certificacion.uis;

import net.serenitybdd.screenplay.targets.Target;

public class FacilitoUserInterface {

    public static final Target TXT_VALIDACION = Target.the("").locatedBy("//*[contains(@text,'{0}')]");
    public static final Target BTN_LOGIN_SCREEN = Target.the("").locatedBy("//android.widget.FrameLayout/android.widget.TextView[contains(@text,'Login')]");
    public static final Target BTN_CLIPBOARD_DEMO = Target.the("").locatedBy("//*[contains(@text,'Clipboard Demo')]");
    public static final Target TXT_CLIPBOARD = Target.the("").locatedBy("//android.widget.EditText[@content-desc='messageInput']");
    public static final Target BTN_SET_CLIPBOARD = Target.the("").locatedBy("//android.view.ViewGroup[@content-desc='setClipboardText']/android.widget.TextView");
    public static final Target BTN_REFRESH_CLIPBOARD = Target.the("").locatedBy("//android.view.ViewGroup[@content-desc=\"refreshClipboardText\"]/android.widget.TextView");


}
