package com.csse.order.controller;
import com.csse.order.common.StatusCode;
import com.csse.order.dto.PurchaseOrderDTO;
import com.csse.order.dto.PurchaseOrderResponseDTO;
import com.csse.order.entity.PurchaseOrder;
import com.csse.order.repository.PurchaseOrderRepository;
import com.csse.order.serviceimpl.PurchaseOrderServiceIMPL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.ArgumentMatchers;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseOrderControllerTest {

    @InjectMocks
    private PurchaseOrderServiceIMPL purchaseOrderService;

    @Mock
    private PurchaseOrderRepository purchaseOrderRepository;

    @Test
    public void testCreateOrderWithValidDetails_1() {
        // Initialize a PurchaseOrderDTO with necessary data
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setSupplierName("Ahamed");
        purchaseOrderDTO.setCompanyName("Mass Traders");
        purchaseOrderDTO.setContactNo("071247547");
        purchaseOrderDTO.setTotalQty("25");
        purchaseOrderDTO.setPrice(120000.0f);
        purchaseOrderDTO.setStatus("Pending");

        // Initialize a PurchaseOrder (entity) with necessary data
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setSupplierName("Ahamed");
        purchaseOrder.setCompanyName("Mass Traders");
        purchaseOrder.setContactNo("071247547");
        purchaseOrder.setTotalQty("25");
        purchaseOrder.setPrice(120000.0f);
        purchaseOrder.setStatus("Pending");

        // Mock the behavior of the repository with explicit type specification
        when(purchaseOrderRepository.save(ArgumentMatchers.<PurchaseOrder>any())).thenReturn(purchaseOrder);

        // Calling the service method
        PurchaseOrderResponseDTO response = purchaseOrderService.createOrder(purchaseOrderDTO);

        // Verifying that the repository save method was called once
        verify(purchaseOrderRepository, times(1)).save(ArgumentMatchers.<PurchaseOrder>any());

        // Assertions
        assertNotNull(response);
        assertEquals(StatusCode.OK, response.getStatusCode());
        assertEquals("Purchase Order Creation successfully", response.getDescription());
    }

    @Test
    public void testCreateOrderWithValidDetails_2() {
        // Initialize a PurchaseOrderDTO with necessary data
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setSupplierName("Asiff");
        purchaseOrderDTO.setCompanyName("Union Traders");
        purchaseOrderDTO.setContactNo("07475124587");
        purchaseOrderDTO.setTotalQty("50");
        purchaseOrderDTO.setPrice(14000.0f);
        purchaseOrderDTO.setStatus("Approved");

        // Initialize a PurchaseOrder (entity) with necessary data
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setSupplierName("Asiff");
        purchaseOrder.setCompanyName("Union Traders");
        purchaseOrder.setContactNo("07475124587");
        purchaseOrder.setTotalQty("50");
        purchaseOrder.setPrice(14000.0f);
        purchaseOrder.setStatus("Approved");

        // Mock the behavior of the repository with explicit type specification
        when(purchaseOrderRepository.save(ArgumentMatchers.<PurchaseOrder>any())).thenReturn(purchaseOrder);

        // Call the service method
        PurchaseOrderResponseDTO response = purchaseOrderService.createOrder(purchaseOrderDTO);

        // Verify that the repository save method was called once
        verify(purchaseOrderRepository, times(1)).save(ArgumentMatchers.<PurchaseOrder>any());

        // Assertions
        assertNotNull(response);
        assertEquals(StatusCode.OK, response.getStatusCode());
        assertEquals("Purchase Order Creation successfully", response.getDescription());
        // Add more assertions as needed
    }

    @Test
    public void testCreateOrderWithInvalidDetails() {
        // Initialize a PurchaseOrderDTO with necessary data
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setSupplierName("");
        purchaseOrderDTO.setCompanyName("Mass Traders");
        purchaseOrderDTO.setContactNo("071247547");
        purchaseOrderDTO.setTotalQty("25");
        purchaseOrderDTO.setPrice(120000);
        purchaseOrderDTO.setStatus("Pending");

        // Initialize a PurchaseOrder (entity) with necessary data
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setSupplierName("");
        purchaseOrder.setCompanyName("Mass Traders");
        purchaseOrder.setContactNo("071247547");
        purchaseOrder.setTotalQty("25");
        purchaseOrder.setPrice(120000);
        purchaseOrder.setStatus("Pending");

        // Mock the behavior of the repository with explicit type specification
        when(purchaseOrderRepository.save(ArgumentMatchers.<PurchaseOrder>any())).thenReturn(purchaseOrder);

        // Call the service method
        PurchaseOrderResponseDTO response = purchaseOrderService.createOrder(purchaseOrderDTO);

        // Verify that the repository save method was called once
        verify(purchaseOrderRepository, times(1)).save(ArgumentMatchers.<PurchaseOrder>any());

        // Assertions
        assertNotNull(response);
        assertEquals(StatusCode.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Purchase Order Creation failed", response.getDescription());
        // Add more assertions as needed
    }


}
