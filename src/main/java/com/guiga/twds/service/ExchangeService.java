package com.guiga.twds.service;

import com.guiga.twds.dto.ExchangeDTO;
import com.guiga.twds.dto.ItemDTO;
import com.guiga.twds.entity.Item;
import com.guiga.twds.entity.People;
import com.guiga.twds.enumeration.TypeItemEnum;
import com.guiga.twds.exception.ResultException;
import com.guiga.twds.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guilherme on 21/01/17.
 */
@Service
public class ExchangeService {


    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public void makeExchange(ExchangeDTO dto) {

        People people = peopleRepository.findOne(dto.getUserId());

        People recipient = peopleRepository.findByName(dto.getRecipientName());

        if (recipient.getInfected()) {
            throw new ResultException("Recipient is infected.");
        }

        Integer pointsWanted = 0;

        Integer pointsPayment = 0;

        for (ItemDTO wanted : dto.getItemsWanted()) {

            pointsWanted += TypeItemEnum.lookup(wanted.getTypeItem()).getPoints() * wanted.getQuantity();
        }

        for (ItemDTO payment : dto.getItemsWanted()) {

            pointsPayment += TypeItemEnum.lookup(payment.getTypeItem()).getPoints() * payment.getQuantity();
        }

        if ( !pointsWanted.equals(pointsPayment) ) {
            throw new ResultException("Items exchanged must have the same amount of points.");
        }

        //For people
        for (Item item : people.getItems()) {

            //add item inventory
            for (ItemDTO itemWanted : dto.getItemsWanted()) {

                if (item.getTypeItem().getId().equals(itemWanted.getTypeItem())) {

                    item.setQuantity(item.getQuantity() + itemWanted.getQuantity());
                }
            }

            //Subtract item inventory
            for (ItemDTO itemPayment : dto.getItemsForPayment()) {

                if (item.getTypeItem().getId().equals(itemPayment.getTypeItem())) {

                    item.setQuantity(item.getQuantity() - itemPayment.getQuantity());
                }
            }
        }

        //For recipient
        for (Item item : recipient.getItems()) {

            //subtract item inventory
            for (ItemDTO itemWanted : dto.getItemsWanted()) {

                if (item.getTypeItem().getId().equals(itemWanted.getTypeItem())) {

                    item.setQuantity(item.getQuantity() - itemWanted.getQuantity());
                }
            }

            //add item inventory
            for (ItemDTO itemPayment : dto.getItemsForPayment()) {

                if (item.getTypeItem().getId().equals(itemPayment.getTypeItem())) {

                    item.setQuantity(item.getQuantity() + itemPayment.getQuantity());
                }
            }
        }

        peopleRepository.save(people);

        peopleRepository.save(recipient);

    }

    private List<Item> fillListEntityItems(List<ItemDTO> lstItensDTO) {

        List<Item> lstItems = new ArrayList<>();

        lstItensDTO.stream().forEach(itemDTO -> {

            Item item = new Item();

            item.setTypeItem(TypeItemEnum.lookup(itemDTO.getTypeItem()));

            item.setQuantity(itemDTO.getQuantity());

            lstItems.add(item);
        });

        return lstItems;
    }


}
