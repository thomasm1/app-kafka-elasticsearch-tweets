package app.mapl.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CHAIN")
public class Chain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, name = "CHAIN_ID", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "chain_seq")
    private Integer chainId;

//    @Version
//    private Integer version;

//    @NotBlank
    @Size(max = 250)
    @Column(length = 250)
    private String name;

    @Column(name = "symbol")
    private String symbol;

    private String description;
    @Column(name = "long_description")
    private String longDescription;
    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "chain_list_icon")
    private String chainListIcon;
    @Column(name = "rpc_url")
    private String rpcUrl;

    @Column(name = "block_explorer_url")
    private String blockExplorerUrl;
    private Integer id;

//    @Column(name = "DATE_CREATED")
//    private Date dateCreated;
//
////
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "CHAIN_USERS",
            joinColumns = @JoinColumn(name = "CHAIN_ID"),
            inverseJoinColumns = @JoinColumn(name = "userid")
    )
    @JsonIgnore
    private List<User> users;

//
//    @OneToMany(mappedBy = "chain")
//    private Set<ChainOrderLine> chainOrderLines;




}
