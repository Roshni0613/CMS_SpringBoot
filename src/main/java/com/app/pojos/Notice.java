package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="notice_table")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Notice extends BaseEntity {

	//id : inherited
	//title of the file 
	private String title;
	
	private String fileName;
	
	private String type;

    @Lob
    private byte[] data;
    
    private LocalDate uploadTime=LocalDate.now();
    
    private LocalDate noticeExpiryDate;
    
    @Transient
    private Boolean flag=false;

    
}
