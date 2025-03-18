package xyz.cryptomaven.rest.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Dto for {@link xyz.cryptomaven.rest.models.RawToken}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawTokenDto implements Serializable {

    private Integer id;
    private String rawToken;
  private HashMap<Integer, HashMap<Double, String>> mapToken = new HashMap<>();

  public RawTokenDto(Integer id, String rawToken) {
    this.id = id;
    this.rawToken =  rawToken;
    this.mapToken = parseRawToken(id, rawToken);
  }
  private HashMap<Integer, HashMap<Double, String>> parseRawToken(Integer id, String rawToken ) {
    HashMap<Integer, HashMap<Double, String>> parsedMap = new HashMap<>();
    HashMap<Double, String> tokenData = new HashMap<>();

    if (rawToken != null && !rawToken.isEmpty()) {
      String[] parts = rawToken.split(""); //    ["0.000034", "ETH"]
      if (parts.length == 2) {
        try {
          double amount = Double.parseDouble(parts[0]);
          String currency = parts[1];

          tokenData.put(amount, currency);
          parsedMap.put(id, tokenData);
        } catch (NumberFormatException e) {
          System.err.println("Invalid NUMBER FORMAT"+ parts[0]);
        }
      }
    }
    return parsedMap;
  }
}
