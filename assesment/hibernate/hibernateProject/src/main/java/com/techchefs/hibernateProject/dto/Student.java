package com.techchefs.hibernateProject.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@NamedQueries({ 
	@NamedQuery(
		name = "studentnamedquery", 
		query = "from Student where rollNum=:rn and subject=:sub")
})

@Table(name = "student")
@Entity
@Data
public class Student {
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private StudentOtherInfo otherInfo;

	@Id
	@Column(name = "roll_num")
	private Integer rollNum;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "subject")
	private String subject;

	@Column(name = "total_marks")
	private Double totalMarks;
}
