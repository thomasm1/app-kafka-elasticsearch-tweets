package app.mapl.util.methods.restTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
public class LoanApplication
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int principal; // amount borrowed
	private int termInMonths;
	private BigDecimal repayment;
	private Boolean approved;


	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public BigDecimal getInterestRate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://loans.cryptomaven.xyz/getInterestRate", BigDecimal.class);
	}


}
