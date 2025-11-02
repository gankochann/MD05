package ra.com.controller;

import com.cloudinary.api.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.com.model.dto.BusDto;
import ra.com.model.dto.BusUpdateDto;
import ra.com.model.respon.ApiResp;
import ra.com.service.BusService;



@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusService busService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(ApiResp.builder()
                .message("lay danh sach thanh cong")
                .success("true")
                .data(busService.findAll())
                .httpStatus(200)
                .build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@ModelAttribute BusDto busDto){
        return new ResponseEntity<>(ApiResp.builder()
                .message("them xe bus thanh cong")
                .success("true")
                .data(busService.save(busDto))
                .httpStatus(200)
                .build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @ModelAttribute BusUpdateDto busUpdateDto , @PathVariable int id){
        return new ResponseEntity<>(ApiResp.builder()
                .message("cap nhat xe bus thanh cong")
                .success("true")
                .data(busService.update(busUpdateDto,id))
                .httpStatus(200)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return new ResponseEntity<>(ApiResp.builder()
                .message("xoa xe bus thanh cong")
                .success("true")
                .data(busService.delete(id))
                .httpStatus(200)
                .build(), HttpStatus.OK);
    }
}
