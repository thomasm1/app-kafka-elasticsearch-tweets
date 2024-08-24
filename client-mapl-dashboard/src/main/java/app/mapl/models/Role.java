package app.mapl.models;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "ROLES")
public class Role extends AbstractDomainClass  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
private String name;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "USERS_ROLE", joinColumns = @JoinColumn(name = "role_id"),    inverseJoinColumns = @JoinColumn(name = "userid"))
//    private List<User> users = new ArrayList<>();
}
