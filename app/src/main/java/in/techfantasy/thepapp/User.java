package in.techfantasy.thepapp;

/**
 * Created by campusiq on 09/02/18.
 */

public class User
{
    String token;
    String model;

    public User(String token,String model)
    {
        this.model=model;
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
