package peddle.dto;

import lombok.Data;

@Data
public class JwtAuthenticationRs {

  private String accessToken;
  private final String tokenType = "Bearer";

  public JwtAuthenticationRs(String accessToken) {
    this.accessToken = accessToken;
  }
}
