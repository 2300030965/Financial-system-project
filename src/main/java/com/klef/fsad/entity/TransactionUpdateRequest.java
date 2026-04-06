package com.klef.fsad.entity;

import com.klef.fsad.enums.UpdateRequestStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction_update_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionUpdateRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Transaction transaction;

    @ManyToOne
    private User user;

    private String reason;

    private String requestedChange;

    @Enumerated(EnumType.STRING)
    private UpdateRequestStatus status;
}