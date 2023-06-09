package com.sportyshoes.controller;

import com.sportyshoes.dto.ShoeRequestDTO;
import com.sportyshoes.dto.ShoeResponseDTO;
import com.sportyshoes.entity.Shoe;
import com.sportyshoes.service.ShoeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoes")
public class ShoeController {

    private final ShoeService ShoeService;

    @Autowired
    public ShoeController(ShoeService ShoeService) {
        this.ShoeService = ShoeService;
    }


    @PostMapping("/add")
    public ResponseEntity<Shoe> createShoe(@RequestBody Shoe Shoe, @RequestHeader String sessionId) {
        return ShoeService.createShoe(Shoe, sessionId);
    }

    @GetMapping("/fetch/{userId}")
    public ResponseEntity<ShoeResponseDTO> fetchShoes(@RequestHeader Long userId, @RequestHeader String sessionId) throws Exception {
        ResponseEntity<ShoeResponseDTO> response = ShoeService.getAllShoes(userId, sessionId);
        return response;
    }


}
