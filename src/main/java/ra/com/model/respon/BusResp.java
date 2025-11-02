package ra.com.model.respon;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BusResp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "bus_name", length = 100 , nullable = false, unique = true)
    private String busName;
    @Column(name = "registration_number" , length = 30 , nullable = false, unique = true)
    private String registrationNumber;
    @Column(name = "total_seats" , nullable = false)
    private int totalSeat;
    @Column(name = "image_bus")
    private String imageBus;
    @Column(columnDefinition = "bit default 1" )
    private String status;
}
