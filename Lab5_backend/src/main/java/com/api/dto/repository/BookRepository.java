//package com.pavelchak.repository;
//
//import com.pavelchak.domain.Book;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface BookRepository extends JpaRepository<Book, Integer> {
//    List<Book> findByAuthor(String author);
//
//    // ------------------------------------------------------------------
//    Book findByAuthorAndBookName(String author, String bookName);
//
//    @Query("SELECT b FROM Book b WHERE b.author=?1 AND b.bookName=?2")
//    Book findByAuthorAndBookName2(String author, String bookName);
//
//    @Query("SELECT b FROM Book b WHERE b.author=:author AND b.bookName=:book_name")
//    Book findByAuthorAndBookName3(@Param("author") String author, @Param("book_name") String bookName);
//
//    // ------------------------------------------------------------------
//    @Modifying()  // for updating or deleting
//    @Query("DELETE FROM Book b WHERE b.id=?1")
//    void deleteById(Integer id);
//
//    // ------------------------------------------------------------------
//    @Query(value = "SELECT * FROM book ORDER BY book_name LIMIT :topNumber", nativeQuery = true)
//    List<Book> findTopN(@Param("topNumber") String topNumber);
//}
