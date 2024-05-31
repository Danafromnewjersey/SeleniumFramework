package org.selenium.pom.api.actions;

import org.selenium.pom.objects.User;
import org.selenium.pom.utils.FakerUtils;

public class DummyClass {

    public static void main (String[] arg) {
//        System.out.println(new SignUpApi().fetchRegisterNonceValueJsoup());
        String username = "testdana" + new FakerUtils().generateRandomName();
            User user = new User().
                setUsername(username).
                setPassword("newpswrd123").
                setEmail(username + "@gmail.com");
        SignUpApi signUpApi = new SignUpApi();
        signUpApi. register(user);
        System.out.println("REGISTER COOKIES: " + signUpApi.getCookies());
        CartApi cartApi = new CartApi();
        cartApi.addToCart(1215, 1);
        System.out.println("CART COOKIES: " + cartApi.getCookies());
    }
}
