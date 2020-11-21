package by.ereut.balanceservice.tariff;

import by.ereut.balanceservice.client.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tariffs")
@NoArgsConstructor
@EqualsAndHashCode(of={"title"})
@Getter
@Setter
@ToString(of = {"id", "title"})
public class Tariff implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "tariff", fetch = FetchType.EAGER)
    private List<Client> clientList;

}
