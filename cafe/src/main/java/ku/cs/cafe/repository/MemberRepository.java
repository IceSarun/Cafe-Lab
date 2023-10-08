package ku.cs.cafe.repository;
// 6410406878
// Sarunpawat Phosoi
import ku.cs.cafe.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    // SELECT * FROM Member
    Member findByUsername(String username);
}
