package ku.cs.cafe.repository;
// 6410406878
// Sarunpawat Phosoi
import ku.cs.cafe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

}
