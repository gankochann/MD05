package ra.com.model.respon;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ApiResp<T>{
    private String success;
    private String message;
    private T data;
    private int httpStatus;
}
