package br.com.itau.validToken.dataFiller;

import br.com.itau.validToken.domain.models.Claims;
import br.com.itau.validToken.domain.models.TokenRequest;
import br.com.itau.validToken.domain.models.TokenResponse;

public class DataFiller {

    public static TokenRequest tokenRequestItsValid(){
        return TokenRequest.builder().token("eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiQWRtaW4iLCJTZWVkIjoiNzg0MSIsIk5hbWUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05sIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg").build();
    }

    public static TokenRequest tokenRequestClaimInvalid(){
        return TokenRequest.builder().token("eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiTWVtYmVyIiwiT3JnIjoiQlIiLCJTZWVkIjoiMTQ2MjciLCJOYW1lIjoiVmFsZGlyIEFyYW5oYSJ9.cmrXV_Flm5mfdpfNUVopY_I2zeJUy4EZ4i3Fea98zvY").build();
    }
    public static TokenRequest tokenRequestJsonInvalid(){
        return TokenRequest.builder().token("eyJhbGciOiJzI1NiJ9.dfsdfsfryJSr2xrIjoiQWRtaW4iLCJTZrkIjoiNzg0MSIsIk5hbrUiOiJUb25pbmhvIEFyYXVqbyJ9.QY05fsdfsIjtrcJnP533kQNk8QXcaleJ1Q01jWY_ZzIZuAg").build();
    }

    public static TokenRequest tokenRequestClaimValuesInvalid(){
        return TokenRequest.builder().token("eyJhbGciOiJIUzI1NiJ9.eyJSb2xlIjoiRXh0ZXJuYWwiLCJTZWVkIjoiODgwMzciLCJOYW1lIjoiTTRyaWEgT2xpdmlhIn0.6YD73XWZYQSSMDf6H0i3-kylz1-TY_Yt6h1cV2Ku-Qs").build();
    }
    public static String bodyClaimInvalid(){
        return "{  \"Role\": \"Member\",  \"Org\": \"BR\",  \"Seed\": \"14627\",  \"Name\": \"Valdir Aranha\"}";
    }

    public static Claims claimsValid(){
        return Claims.builder().Name("Toninho Araujo").Role("Admin").Seed(7841).build();
    }

    public static Claims claimsInvalid(){
        return Claims.builder().Name("Toni98nho Araujo").Role("Admin").Seed(7841).build();
    }

    public static TokenResponse tokenResponseTrue(){
        return TokenResponse.builder().valid(Boolean.TRUE).build();
    }

}
