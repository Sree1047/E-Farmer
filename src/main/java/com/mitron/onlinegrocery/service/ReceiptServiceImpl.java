package com.mitron.onlinegrocery.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mitron.onlinegrocery.domain.entities.Order;
import com.mitron.onlinegrocery.domain.entities.Receipt;
import com.mitron.onlinegrocery.domain.entities.User;
import com.mitron.onlinegrocery.domain.models.service.ReceiptServiceModel;
import com.mitron.onlinegrocery.repository.OrderRepository;
import com.mitron.onlinegrocery.repository.ReceiptRepository;
import com.mitron.onlinegrocery.repository.UserRepository;
import com.mitron.onlinegrocery.util.error.OrderNotFoundException;
import com.mitron.onlinegrocery.util.error.ReceiptNotFoundException;
import com.mitron.onlinegrocery.validation.ReceiptValidationService;

import static com.mitron.onlinegrocery.util.constants.ExceptionMessages.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final UserRepository userRepository;
    private final ReceiptValidationService receiptValidationService;
    private final ModelMapper modelMapper;

    @Autowired
    public ReceiptServiceImpl(ReceiptRepository receiptRepository, OrderRepository orderRepository,
                              OrderService orderService, UserRepository userRepository,
                              ReceiptValidationService receiptValidationService, ModelMapper modelMapper) {
        this.receiptRepository = receiptRepository;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.userRepository = userRepository;
        this.receiptValidationService = receiptValidationService;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<ReceiptServiceModel> findAllReceiptsByUsername(String username) {
        return this.receiptRepository
                .findAllReceiptsByRecipient_UsernameOrderByIssuedOn(username)
                .stream()
                .map(r -> this.modelMapper.map(r, ReceiptServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ReceiptServiceModel> findAllReceipts() {
        return this.receiptRepository
                .findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, ReceiptServiceModel.class))
                .collect(Collectors.toList());
    }
    @Override
    public void receiptRegister(ReceiptServiceModel receiptServiceModel) {
        if (!receiptValidationService.isValid(receiptServiceModel)){
            throw new IllegalArgumentException();
        }
        Receipt receipt = this.modelMapper.map(receiptServiceModel, Receipt.class);
        this.receiptRepository.save(receipt);
    }

    @Override
    public ReceiptServiceModel getReceiptById(String id) {
        Receipt receipt = this.receiptRepository.findById(id)
                .orElseThrow(ReceiptNotFoundException::new);
        return modelMapper.map(receipt, ReceiptServiceModel.class);
    }

    @Override
    public void createReceipt(String orderId, String name) {
        Order order = this.orderRepository.findById(orderId)
                .orElseThrow(OrderNotFoundException::new);
        User recipient = this.userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_EX_MSG));

        Receipt receipt = new Receipt();

        receipt.setFee(order.getTotalPrice());
        receipt.setIssuedOn(LocalDateTime.now());
        receipt.setOrder(order);
        receipt.setRecipient(recipient);

        this.receiptRepository.save(receipt);

        this.orderService.changeOrderStatus(orderId);
    }

    @Override
    public ReceiptServiceModel findReceiptById(String receiptId) {

        Receipt receipt = this.receiptRepository.findById(receiptId)
                .orElseThrow(ReceiptNotFoundException::new);

        return modelMapper.map(receipt, ReceiptServiceModel.class);
    }
}
