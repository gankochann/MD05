package ra.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.model.dto.BusDto;
import ra.com.model.dto.BusUpdateDto;
import ra.com.model.entity.Bus;
import ra.com.model.respon.BusResp;
import ra.com.repository.Ibus;

import java.util.List;

@Service
public class BusService {
    @Autowired
    private Ibus ibus;
    @Autowired
    private CloudinariService cloudinariService;

    //lay danh sach
    public List<BusResp> findAll(){
        return ibus.findAll().stream().map(e -> BusResp.builder()
                .id(e.getId())
                .busName(e.getBusName())
                .registrationNumber(e.getRegistrationNumber())
                .imageBus(e.getImageBus())
                .totalSeat(e.getTotalSeat())
                .status(e.getStatus() == 1?"dang hoat dong":
                        e.getStatus() == 0 ?"ngung hoat dong":"khac")
                .build()).toList();
    }

    //them
    public BusResp save(BusDto busDto){
        if(ibus.existsByBusName(busDto.getBusName()) || ibus.existsByRegistrationNumber(busDto.getRegistrationNumber())){
            throw new RuntimeException("ten xe bus hoac bien xe bus da ton tai, vui long xem lai!");
        }else {
            String image = cloudinariService.upload(busDto.getImageBus());
            Bus bus = Bus.builder()
                    .busName(busDto.getBusName())
                    .registrationNumber(busDto.getRegistrationNumber())
                    .imageBus(image)
                    .totalSeat(busDto.getTotalSeat())
                    .status(busDto.getStatus())
                    .build();
            Bus newBus = ibus.save(bus);
            return BusResp.builder()
                    .id(newBus.getId())
                    .busName(newBus.getBusName())
                    .registrationNumber(newBus.getRegistrationNumber())
                    .imageBus(newBus.getImageBus())
                    .totalSeat(newBus.getTotalSeat())
                    .status(newBus.getStatus() ==1 ? "dang hoat dong" : newBus.getStatus() == 2 ? "ngung hoat dong" : "khac")
                    .build();
        }

    }

    //cap nhat

    public BusResp update(BusUpdateDto busUpdateDto, int id){
        Bus bus = ibus.findById(id).orElseThrow(() -> new RuntimeException("khong ton tai xe bus ban dang tim"));
        if(ibus.existsByBusName(busUpdateDto.getBusName()) || ibus.existsByRegistrationNumber(busUpdateDto.getRegistrationNumber())){
            throw new RuntimeException("ten xe bus hoac ma xe da bi trung, vui long nhap lai!");
        }else {
            String newImage;
            if(busUpdateDto.getImageBus() != null){
                newImage = cloudinariService.upload(busUpdateDto.getImageBus());
            }else {
                newImage = busUpdateDto.getOldImage();
            }
            bus.setId(id);
            bus.setBusName(busUpdateDto.getBusName());
            bus.setImageBus(newImage);
            bus.setTotalSeat(busUpdateDto.getTotalSeat());
            bus.setRegistrationNumber(busUpdateDto.getRegistrationNumber());
            bus.setStatus(busUpdateDto.getStatus());
            Bus newBus = ibus.save(bus);
            return BusResp.builder()
                    .id(newBus.getId())
                    .busName(newBus.getBusName())
                    .registrationNumber(newBus.getRegistrationNumber())
                    .imageBus(newBus.getImageBus())
                    .totalSeat(newBus.getTotalSeat())
                    .status(newBus.getStatus() ==1 ? "dang hoat dong" : newBus.getStatus() == 2 ? "ngung hoat dong" : "khac")
                    .build();
        }

    }

    //xoa

    public BusResp delete(int id,int newStatus){
        Bus bus = ibus.findById(id).orElseThrow(() -> new RuntimeException("khong ton tai xe bus ban dang tim"));
        if(newStatus == 0 || newStatus == 1 || newStatus == 2) {
            bus.setStatus((byte) newStatus);
        }else {
            throw new RuntimeException("trang thai laf 1 or 2 or 0");
        }
       Bus newBus =  ibus.save(bus);
        return BusResp.builder()
                .id(newBus.getId())
                .busName(newBus.getBusName())
                .registrationNumber(newBus.getRegistrationNumber())
                .imageBus(newBus.getImageBus())
                .totalSeat(newBus.getTotalSeat())
                .status(newBus.getStatus() ==1 ? "dang hoat dong" : newBus.getStatus() == 2 ? "ngung hoat dong" : "khac")
                .build();
    }
}
