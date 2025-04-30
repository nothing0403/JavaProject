package model.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private String item;
	private Integer price;
}
