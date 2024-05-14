package kr.co.rland.api.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Menu {
	@Id
    private Long id;
	private String korName;
	private String engName;
	private Integer price;
	private String img;
	private Date regDate;
	private Long categoryId;
	private Long regMemberId;
}
