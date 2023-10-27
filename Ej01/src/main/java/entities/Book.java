package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long isbn;
    private String title;
    private int year;
    private int copies;
    private int borrowedCopies;
    private int availableCopies;
    private boolean active;
    @OneToOne
    @JoinColumn (name = "authors")
    private Author author;
    @OneToOne
    @JoinColumn (name = "publishing_house")
    private PublishingHouse editorial;
}
