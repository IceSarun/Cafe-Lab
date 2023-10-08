package ku.cs.cafe.config;
// 6410406878
// Sarunpawat Phosoi
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentConfig {
    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

}
