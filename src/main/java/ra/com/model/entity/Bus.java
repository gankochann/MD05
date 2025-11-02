package ra.com.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bus")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bus {
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
    private Byte status;
}
