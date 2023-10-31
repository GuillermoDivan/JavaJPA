package entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime borrowDate;
    private LocalDateTime devolutionDate;
    private boolean active;
    @ManyToOne
    @JoinColumn (name = "books")
    private Book book;
    @ManyToOne
    @JoinColumn (name = "clients")
    private Client client;

}
