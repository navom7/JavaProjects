package com.sportyshoes.dto;

import com.sportyshoes.entity.Shoe;
import com.sportyshoes.utils.BaseResponse;

import java.util.List;

public class ShoeResponseDTO extends BaseResponse {
    private Shoe shoe;
    private List<Shoe> shoes;

    public ShoeResponseDTO(Shoe Shoe, List<Shoe> Shoes, String message, boolean isSuccess) {
        super(message, isSuccess);
        this.shoe = Shoe;
        this.shoes = Shoes;
    }

    public ShoeResponseDTO() {
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void setShoes(List<Shoe> shoes) {
        this.shoes = shoes;
    }

    public Shoe getShoe() {
        return shoe;
    }
    public void setShoe(Shoe shoe) {
        this.shoe = shoe;
    }

}
