package ra.com.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class CloudinariService {
    @Autowired
    private Cloudinary cloudinary;

    public String upload(MultipartFile multipartFile){
        try {
            String originalname = multipartFile.getOriginalFilename();
            if(originalname != null && originalname.contains(".")){
                originalname = originalname.substring(0, originalname.lastIndexOf("."));
            }
                Long timeStamp = System.currentTimeMillis()/1000;
                Map<String , Object> map = ObjectUtils.asMap("public_id" , originalname , "timestamp" , timeStamp);
                String signature = cloudinary.apiSignRequest(map, cloudinary.config.apiSecret);
                map.put("signature" , signature);
                map.put("api_key" , cloudinary.config.apiKey);
                Map upload = cloudinary.uploader().upload(multipartFile.getBytes(), map);
                return upload.get("secure_url").toString();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
