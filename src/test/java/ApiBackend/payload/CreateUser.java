package ApiBackend.payload;

import lombok.*;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class CreateUser {
         private String jsonrpc;
         private String method;
         private int id;
         private Credentials credentials;

        @Getter
        @Setter
        @AllArgsConstructor
        @NoArgsConstructor
        @Builder
        public static class Credentials {
            private String username;
            private String password;
        }
    }