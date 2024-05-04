package app.mapl.models.auth;

import app.mapl.models.BaseModel;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Token extends BaseModel {
    private String token;
    private String access;
    private String refresh;
    private TokenType tokenType;


}
