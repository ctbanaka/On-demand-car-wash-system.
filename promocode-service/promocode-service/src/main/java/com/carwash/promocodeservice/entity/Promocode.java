package com.carwash.promocodeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "promocode")
public class Promocode {
	@Id
	private int promocodeId;
	private String promocode;
	private String promocodeDescription;
	private int discount;

}
