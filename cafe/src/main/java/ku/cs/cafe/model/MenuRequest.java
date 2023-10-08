package ku.cs.cafe.model;
// 6410406878
// Sarunpawat Phosoi
import lombok.Data;

import java.util.UUID;

@Data
public class MenuRequest {
    private String name;
    private UUID categoryId;
    private double price;
}
