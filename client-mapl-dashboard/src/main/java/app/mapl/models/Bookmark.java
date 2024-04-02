package app.mapl.models;

import app.mapl.dto.UserDto;
import app.mapl.exception.ApiException;
import app.mapl.util.Shareable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
	@Getter
	@MappedSuperclass
	@RequiredArgsConstructor
	public abstract class Bookmark extends BaseModel implements Shareable {

	private static final long serialVersionUID = 1L;


		private String title;

		@Column(name="profileurl")
		private String profileUrl;
    	@JoinColumn(name = "shared_by_userid")
		private UserDto sharedBy;

		/**
		 * @return
		 */
		@Override
		public String getItemData() {
			return null;
		}

		/**
		 * @return
		 */
		@Override
		public boolean isWeb3Link() {
			return false;
		}

	}
