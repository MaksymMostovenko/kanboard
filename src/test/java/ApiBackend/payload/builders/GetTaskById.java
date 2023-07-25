package ApiBackend.payload.builders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetTaskById {
    private String jsonrpc;
    private String method;
    private int id;
    private Params params;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Params{
        private int task_id;
    }
}
