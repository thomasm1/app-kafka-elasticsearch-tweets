package app.mapl.models;

import app.mapl.models.auth.UserResponse;
import app.mapl.util.Shareable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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
		private UserResponse sharedBy;

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
