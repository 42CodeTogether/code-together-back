package com.codetogether.CodeTogether.service;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthService {
    private static final String clientId = "eb88d5a0b6e3a6b91a8f3b27fc9f7defcba0f32151810c4965c04fab1dcde49a";
    private static final String clientSecret = "869ac1a133426de463e0f14143848778398c63ea64a02a3de558a9004fd8eabd";
    private static final String baseUrl = "https://api.intra.42.fr";
    public static String code2token(String code) {
        String queryUrl = baseUrl + "/oauth/token";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("code", code);
        params.add("redirect_uri", "http://localhost:8080/code2token");
        params.add("scope", "public");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                queryUrl,
                HttpMethod.POST,
                entity,
                String.class
        );
        String jsonString = response.getBody();

        // JSONObjet를 가져와서 key-value를 읽습니다.
        JSONObject jObject = new JSONObject(jsonString);
        String access_token = jObject.getString("access_token");
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setBearerAuth(access_token);
        headers2.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MultiValueMap<String, String>> entity2 = new HttpEntity<>(headers2);
        RestTemplate rt2 = new RestTemplate();
        ResponseEntity<String> response2 = rt2.exchange(
                baseUrl + "/v2/me",
                HttpMethod.GET,
                entity2,
                String.class
        );
        String jsonString2 = response2.getBody();
        JSONObject jObject2 = new JSONObject(jsonString2);
        return jObject2.getString("login");
    }
}
