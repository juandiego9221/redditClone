package pe.com.jdmm21.reddit.app.redditclone.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("springit")
public class SpringitProperties {
    private String welcomeMsg = "hola mundo";

    /**
     * @return String return the welcomeMsg
     */
    public String getWelcomeMsg() {
        return welcomeMsg;
    }

    /**
     * @param welcomeMsg the welcomeMsg to set
     */
    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }

}