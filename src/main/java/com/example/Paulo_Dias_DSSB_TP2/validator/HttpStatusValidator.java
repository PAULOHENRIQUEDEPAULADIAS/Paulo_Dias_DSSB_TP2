package com.example.Paulo_Dias_DSSB_TP2.validator;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

public class HttpStatusValidator {

    public static void validate(HttpMethod method, int status, Object body, HttpHeaders headers)
    {
        switch (status){
            case 200:
                if ((body == null && method == HttpMethod.GET) ||
                    (body == null && method == HttpMethod.PUT) ||
                    (body == null && method == HttpMethod.PATCH))
                {
                    throw new IllegalStateException(
                            String.format("Status '200 OK' %s deve conter body.", method)
                    );
                }
                break;
            case 201:
                if ((method == HttpMethod.POST || method == HttpMethod.PUT) && body == null) {
                    throw new IllegalStateException(
                            String.format("Status '201 CREATED' %s deve conter body.", method)
                    );
                }
                if (method == HttpMethod.POST || method == HttpMethod.PUT) {
                    if (!headers.containsKey(HttpHeaders.LOCATION)) {
                        throw new IllegalStateException(
                                String.format("Status '201 CREATED' %s deve conter header Location.", method)
                        );
                    }
                }
                break;
            case 204:
                if (body != null) {
                    throw new IllegalStateException("Status '204 No Content' não deve conter body.");
                }
                break;
            case 400:
                if (body == null){
                    throw new IllegalStateException("'400 Bad Request' deve retornar corpo com detalhes do erro.");
                }
            case 404:
                if (body == null) {
                    throw new IllegalStateException("'404 Not Found' Id não encontrado");
                }
                break;
            case 500:
                if (body == null){
                    throw new IllegalStateException("'500 Internal Server Error' deve retornar corpo com detalhes do erro.");
                }
            default:
                throw new IllegalStateException("Status não permitido!" + status);
        }
    }
}
