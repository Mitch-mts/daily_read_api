package mts.mtech.dailyread.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 8:45 PM
 */
@Entity
@Table
public class DailyRead implements Serializable {
  @Id
  @GeneratedValue(
      generator = "daily_read_sequence",
      strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column
  private String verse;
  @Column
  private String number;
  @Column
  private String chapter;
  @Column
  private String book;
  @Column
  private String testament;
  @Column
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dateCreated;

  public DailyRead() {
  }

  private DailyRead(String verse, String number, String chapter, String book,
      String testament, LocalDate dateCreated) {
    this.verse = verse;
    this.number = number;
    this.chapter = chapter;
    this.book = book;
    this.testament = testament;
    this.dateCreated = dateCreated;
  }

  public static DailyRead of(String verse, String number, String chapter, String book,
      String testament, LocalDate dateCreated) {
    return new DailyRead(verse, number, chapter, book, testament, dateCreated);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getVerse() {
    return verse;
  }

  public void setVerse(String verse) {
    this.verse = verse;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getChapter() {
    return chapter;
  }

  public void setChapter(String chapter) {
    this.chapter = chapter;
  }

  public String getBook() {
    return book;
  }

  public void setBook(String book) {
    this.book = book;
  }

  public String getTestament() {
    return testament;
  }

  public void setTestament(String testament) {
    this.testament = testament;
  }

  public LocalDate getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDate dateCreated) {
    this.dateCreated = dateCreated;
  }

  @Override
  public String toString() {
    return "DailyRead{" +
        "id=" + id +
        ", verse='" + verse + '\'' +
        ", number='" + number + '\'' +
        ", chapter='" + chapter + '\'' +
        ", book='" + book + '\'' +
        ", testament='" + testament + '\'' +
        ", dateCreated=" + dateCreated +
        '}';
  }
}
