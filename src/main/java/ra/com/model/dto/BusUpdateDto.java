package ra.com.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BusUpdateDto {
    @NotNull(message = "vui long khong de trong")
    private String busName;
    @NotNull(message = "vui long khong de trong")
    private String registrationNumber;
    @NotNull(message = "vui long khong de trong")
    private int totalSeat;
    private String oldImage;
    private MultipartFile imageBus;
    private Byte status;
}
