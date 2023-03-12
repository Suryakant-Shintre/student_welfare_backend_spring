 package com.app.pojos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Amenities_tbl")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AmenitiesPojo extends BaseEntityPojo{
		
		
		@Column(name="Washing_machine")
		private Boolean washingMachine;
		
		@Column(name="Internet")
		private Boolean internet;
		
		@Column(name="Furniture")
		private Boolean furniture;
		
		@Column(name="Water_Filter")
		private Boolean waterFilter;
		
		@OneToOne
		@JoinColumn(name="RoomID",nullable=false)
		private RoomPojo room;
		
		public AmenitiesPojo(Boolean washingMachine, Boolean internet, Boolean furniture, Boolean waterFilter) {
			super();
			this.washingMachine = washingMachine;
			this.internet = internet;
			this.furniture = furniture;
			this.waterFilter = waterFilter;
		}
		
}
