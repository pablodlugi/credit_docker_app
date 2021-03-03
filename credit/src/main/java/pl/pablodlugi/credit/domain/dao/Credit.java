package pl.pablodlugi.credit.domain.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String creditName;
    private String creditNumber;

}
