package ra.com.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "busRoute")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BusRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int busRouteId;
    @Column(name = "start_point" , length = 255 , nullable = false)
    private String startPoint;
    @Column(name = "end_point" , length = 255 , nullable = false)
    private String endPoint;
    @Column(name = "trip_information" , length = 255, nullable = false)
    private String tripInformation;
    @Column(name = "drive_name" , length = 70 , nullable = false)
    private String driveName;
    @Column(name = "status" , nullable = false)
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
}
