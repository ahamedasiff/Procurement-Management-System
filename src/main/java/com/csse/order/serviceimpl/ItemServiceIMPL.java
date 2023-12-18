package com.csse.order.serviceimpl;

import com.csse.order.common.StatusCode;
import com.csse.order.dto.ItemDTO;
import com.csse.order.dto.ItemResponseDTO;
import com.csse.order.entity.Item;
import com.csse.order.repository.ItemRepository;
import com.csse.order.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceIMPL.class);

    @Autowired
    ItemRepository itemRepository;

    /**
     * Create order request
     *
     * @param itemDTO - required dto to create an item
     * @return success or failed response from item creation and item details
     * @author Asiff
     */

    @Override
    public ItemResponseDTO createItem(ItemDTO itemDTO) {
        try{
            logger.error("ItemServiceIMPL -> createItem() => started!");
            Item item = new Item(
                    itemDTO.getItemId(),
                    itemDTO.getItemName(),
                    itemDTO.getQty(),
                    itemDTO.getPrice()
            );

            itemRepository.save(item);
            logger.error("ItemServiceIMPL -> createItem() => success!");
            return new ItemResponseDTO(StatusCode.OK, item, "Item Creation successfully", new Date());
        }catch (Exception e){
            logger.error("ItemServiceIMPL -> createItem() => error: {}", e.getMessage());
            return new ItemResponseDTO(StatusCode.INTERNAL_SERVER_ERROR, null, "Item Creation failed", new Date());
        }
    }

    /**
     * Get item request
     *
     * @return success or failed response from order and all Items details
     * @author Asiff
     */
    @Override
    public ResponseEntity<List<Item>> getItems() {
        try {
            logger.error("ItemServiceIMPL -> getItems() => started!");
            List<Item> itemList = new ArrayList<>(itemRepository.findAll());

            if (itemList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("ItemServiceIMPL -> getItems() => success!");
            return new ResponseEntity<>(itemList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("ItemServiceIMPL -> getItems() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
