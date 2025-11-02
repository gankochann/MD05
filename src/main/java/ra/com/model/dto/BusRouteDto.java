package ra.com.model.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.com.model.entity.Bus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BusRouteDto {
    @NotNull(message = "vui long khong de trong")
    private String startPoint;
    @NotNull(message = "vui long khong de trong")
    private String endPoint;
    @NotNull(message = "vui long khong de trong")
    private String tripInformation;
    @NotNull(message = "vui long khong de trong")
    private String driveName;
    @NotNull(message = "vui long khong de trong")
    private Boolean status;
}
