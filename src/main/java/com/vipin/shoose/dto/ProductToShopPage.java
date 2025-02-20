package com.vipin.shoose.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductToShopPage {
    private Long productId;
    private String productName;
    private String Brand;

    private String price;

    private String productImage;

}
