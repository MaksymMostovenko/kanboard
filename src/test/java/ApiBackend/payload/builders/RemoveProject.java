package ApiBackend.payload.builders;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RemoveProject {
    private String jsonrpc;
    private String method;
    private long id;
    private Params params;

    @Data
    @Builder
    public static class Params {
        private Integer project_id;
    }
}

