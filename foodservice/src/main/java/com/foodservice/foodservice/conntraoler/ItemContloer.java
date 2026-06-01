
package com.foodservice.foodservice.conntraoler;

import com.foodservice.foodservice.models.Item;
import com.foodservice.foodservice.services.ItemServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemContloer {
    @Autowired
    private ItemServices itemService;
    @GetMapping("/")
    public ResponseEntity<List<Item>> ShowAllItems(){
    List<Item> items = this.itemService.getAllItems ();
    return new ResponseEntity(items, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item retrievedItem = this.itemService.getItemById(id);
        return new ResponseEntity<>(retrievedItem, HttpStatus. OK) ;
    
    }
    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {   
        Item newItem = this.itemService.addItem(item) ;
        return new ResponseEntity<>(newItem, HttpStatus. CREATED) ;

    }
}