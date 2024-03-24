package app.mapl.models;

import app.mapl.util.Shareable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

	@Setter
	@Getter
	@Entity
	@Table(name = "bookmarks")
	public class  Bookmark implements Shareable {
		private static final long serialVersionUID = 1L;
		@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BOOK_SEQUENCE" )
//	@SequenceGenerator(name = "BOOK_SEQUENCE", sequenceName = "BOOK_SEQUENCE", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private long id;

		private String title;

	@Column(name="profileurl")
	private String profileUrl;
//		@JoinColumn(name = "shared_by_userid")
		private User sharedBy;

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
