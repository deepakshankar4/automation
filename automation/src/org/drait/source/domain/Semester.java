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
@Table(name = "SEMESTER")
public enum Semester {

	SEMISTER_1("1st SEMESTER", 1), SEMISTER_2("2nd SEMESTER", 2), SEMISTER_3(
			"3rd SEMESTER", 3), SEMISTER_4("4th SEMESTER", 4), SEMISTER_5(
			"5th SEMESTER", 5), SEMISTER_6("6th SEMESTER", 6), SEMISTER_7(
			"7th SEMESTER", 7), SEMISTER_8("8th SEMESTER", 8), SEMISTER_9(
			"9th SEMESTER", 9), SEMISTER_10("10th SEMESTER", 10);

	@Column(name = "SEMESTER")
	private String displayName;

	@Id
	private int id;

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName
	 * @param id
	 */
	private Semester(String displayName, int id) {
		this.displayName = displayName;
		this.id = id;
	}

	/**
	 * @param displayName
	 *            the displayName to set
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
