package org.selenium.pom.api.actions;

import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.selenium.pom.api.ApiRequest;
import org.selenium.pom.constants.EndPoint;
import org.selenium.pom.utils.ConfigLoader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CartApi {
    private Cookies cookies;
    public CartApi(){}

    public CartApi(Cookies cookies){
        this.cookies = cookies;
    }
    public Cookies getCookies(){
        return cookies;
    }

    public Response addToCart(int productId, int quantity) {
         Header header = new Header("content-type", "application/x-www-form-urlencoded");
        Headers headers = new Headers();
        HashMap<String,Object> formParams = new HashMap<>();
        formParams.put("product_sku","");
        formParams.put("product_id", productId);
        formParams.put("quantity", quantity);

//        if (cookies == null){
//            cookies = new Cookies();
//        }
//        Response response = given().
//                baseUri(ConfigLoader.getInstance().getBaseURL()).
//                headers(headers).
//                formParams(formParams).
//                cookies(cookies).
//                log().all().
//        when().
//                post("/?wc-ajax=add_to_cart").
//        then().
//                log().all().
//                extract().
//                response();
        Response response = ApiRequest.post(EndPoint.ADD_TO_CART.url, headers, formParams, cookies);

        if (response.getStatusCode() !=200){
            throw new RuntimeException("Failed to add product"+ productId + " to the cart" + ", HTTP Status Code: " + response.getStatusCode());
        }
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
