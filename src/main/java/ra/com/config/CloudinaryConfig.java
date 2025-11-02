package ra.com.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    public static final String CLOUND_NAME = "dsje46wca";
    public static final String API_KEY = "158236297683945";
    public static final String API_SECRET = "ZCPXbcy_nViv5aH0lng3sp2VT64";
    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap("cloud_name" , CLOUND_NAME,
                "api_key" , API_KEY , "api_secret" , API_SECRET));
    }
}
