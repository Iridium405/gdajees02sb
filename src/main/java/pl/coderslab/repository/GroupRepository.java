package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.StudentGroup;

@Repository
public interface GroupRepository extends JpaRepository<StudentGroup, Long> {
}
