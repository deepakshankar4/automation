/**
 * 
 */
package org.drait.source.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author DEEPAK
 * 
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Entity
@Table(name = "DEPARTMENT")
public enum Department {

	/**
	 * 
	 */
	CIVIL_ENGINEERING("CIVIL ENGINEERING", 1),

	/**
	 * 
	 */
	MECHANICAL_ENGINEERING("MECHANICAL ENGINEERING", 2),
	/**
	 * 
	 */
	ELICTRCAL_AND_ELECTRONICS_ENGINEERING(
			"ELELCTRICAL & ELECTRONICS ENGINEERING", 3),
	/**
	 * 
	 */
	ELECTRONICS_AND_COMMUNICATIONS_ENGINEERING(
			"ELECTRONICS AND COMMUNICATIONS ENGINEERING", 4),
	/**
	 * 
	 */
	INDUSTRIAL_ENGINEERING_AND_MANAGEMENT(
			"INDUSTRIAL ENGINEERING & MANAGEMENT", 5),
	/**
	 * 
	 */
	INSTRUMENTATION_TECHNOLOGY("INSTRUMENTATION TECHNOLOGY", 6),
	/**
	 * 
	 */
	TELECOMMUNICATION_ENGINEERING("TELECOMMUNICATION ENGINEERING", 7),
	/**
	 * 
	 */
	COMPUTER_SCIENCE_AND_ENGINEERING("COMPUTER SCIENCE AND ENGINEERING", 8),
	/**
	 * 
	 */
	INFORMATION_SCIENCE_AND_ENGINEERING("INFORMATION SCIENCE AND ENGINEERING",
			9),
	/**
	 * 
	 */
	MEDICAL_ELECTRONICS("MEDICAL ELECTRONICS", 10),
	/**
	 * 
	 */
	PHYSICS("PHYSICS", 11),
	/**
	 * 
	 */
	CHEMISTRY("CHEMISTRY", 12),
	/**
	 * 
	 */
	MATHEMATICS("MATHEMATICS", 13),
	/**
	 * 
	 */
	HUMANITIES("HUMANITIES", 14),
	/**
	 * 
	 */
	M_TECH("M TECH", 15),
	/**
	 * 
	 */
	MBA("MBA", 16),
	/**
	 * 
	 */
	MCA("MCA", 17);

	@Column(name = "DEPARTMENT")
	private String displayName;

	@Id
	private int id;

	private Department(final String displayName, final int id) {
		this.displayName = displayName;
		this.id = id;

	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return Department name
	 */
	public String getName() {
		return this.name();
	}
}
