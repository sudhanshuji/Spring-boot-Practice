package com.luv2code.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	// annotate the class as an entity and map to db table

	// define the fields

	// annotate the fields with db column names

	// Create constructors

	// generate getters and setters

	// generate toString() method

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobby;
	
	
	//@OneToOne(mappedBy = "instrutorDetail", cascade = CascadeType.ALL)
	@OneToOne(mappedBy = "instrutorDetail",
			cascade = {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH})
	private Instructor instructor;
	
	/**
	 * @return the instructor
	 */
	public Instructor getInstructor() {
		return instructor;
	}

	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the youtubeChannel
	 */
	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	/**
	 * @param youtubeChannel the youtubeChannel to set
	 */
	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	/**
	 * @return the hobby
	 */
	public String getHobby() {
		return hobby;
	}

	/**
	 * @param hobby the hobby to set
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [Id=" + Id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

}
