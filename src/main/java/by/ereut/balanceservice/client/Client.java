package by.ereut.balanceservice.client;

import by.ereut.balanceservice.tariff.Tariff;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "clients")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"telephoneNumber", "balance", "tariff"})
@ToString
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "telephone_number", unique = true, length = 32, nullable = false)
    private String telephoneNumber;

    @Column(precision = 7, scale = 2, nullable = false)
    private BigDecimal balance;

    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "tariff_id")
    private Tariff tariff;

}
