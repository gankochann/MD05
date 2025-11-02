package ra.com.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class BusDto {
    @NotNull(message = "vui long khong de trong")
    private String busName;
    @NotNull(message = "vui long khong de trong")
    private String registrationNumber;
    @NotNull(message = "vui long khong de trong")
    private int totalSeat;
    private MultipartFile imageBus;
    private Byte status = 1;
}
