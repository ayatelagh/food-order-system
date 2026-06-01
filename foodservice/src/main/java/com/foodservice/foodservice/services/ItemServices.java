
package com.foodservice.foodservice.services;

import com.foodservice.foodservice.ItemRepository.ItemRepository;
import com.foodservice.foodservice.models.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServices {
    
   @Autowired
   private ItemRepository itemRepository;
   
   public List<Item> getAllItems () {
    return this.itemRepository. findAll () ;
   }
    public Item getItemById(Long id) {
        return this.itemRepository.findById(id).get ();
    }
    public Item addItem(Item item) {
        return this. itemRepository.save(item) ;
    }
}
