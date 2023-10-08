package ku.cs.cafe.repository;
// 6410406878
// Sarunpawat Phosoi
import org.springframework.stereotype.Repository;
import ku.cs.cafe.entity.OrderItem;
import ku.cs.cafe.entity.OrderItemKey;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemKey>{
}
