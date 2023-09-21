package com.example.consumingrestendpoints.controller;

import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingrestendpoints.Model.Payment;



@RestController
public class PaymentsController {
  
  private static Logger logger =Logger.getLogger(PaymentsController.class.getName());

  @PostMapping("/makepayment")
  public ResponseEntity<Payment> createPayment(@RequestHeader String requestID,
                                               @RequestBody Payment payment)
                                               {
                                                logger.info("Received request with ID : "+requestID + 
                                                            "  ; Payment Amount : " + payment.getAmount()); 
                                                            
                                                payment.setId(UUID.randomUUID().toString());

                                                return ResponseEntity
                                                        .status(HttpStatus.OK)
                                                        .header("Request ID : "+requestID)
                                                        .body(payment);
                                               }

  
}
