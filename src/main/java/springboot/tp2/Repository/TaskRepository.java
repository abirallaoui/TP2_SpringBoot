package springboot.tp2.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.tp2.Entity.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
