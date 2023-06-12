package com.sportyshoes.dto;

import com.sportyshoes.utils.BaseResponse;

import java.util.List;

public class ShoeResponseDTO extends BaseResponse {
    private ShoeDTO ShoeDTO;
    private List<ShoeDTO> ShoeDTOs;

    public ShoeResponseDTO(ShoeDTO ShoeDTO, List<ShoeDTO> ShoeDTOs, String message, boolean isSuccess) {
        super(message, isSuccess);
        this.ShoeDTO = ShoeDTO;
        this.ShoeDTOs = ShoeDTOs;
    }

    public ShoeResponseDTO() {
    }

    public List<ShoeDTO> getShoeDTOs() {
        return ShoeDTOs;
    }

    public void setShoeDTOs(List<ShoeDTO> ShoeDTOs) {
        this.ShoeDTOs = ShoeDTOs;
    }

    public ShoeDTO getShoeDTO() {
        return ShoeDTO;
    }
    public void setShoeDTO(ShoeDTO ShoeDTO) {
        this.ShoeDTO = ShoeDTO;
    }

}
