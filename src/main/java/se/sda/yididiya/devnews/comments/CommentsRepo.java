package se.sda.yididiya.devnews.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long> {
}
