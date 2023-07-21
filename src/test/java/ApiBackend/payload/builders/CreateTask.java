package ApiBackend.payload.builders;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTask {
    private String jsonrpc;
    private String method;
    private long id;
    private Params params;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Params {
        private int owner_id;
        private int creator_id;
        private String date_due;
        private String description;
        private int category_id;
        private int score;
        private String title;
        private int project_id;
        private String color_id;
        private int column_id;
        private int recurrence_status;
        private int recurrence_trigger;
        private int recurrence_factor;
        private int recurrence_timeframe;
        private int recurrence_basedate;
    }
}
