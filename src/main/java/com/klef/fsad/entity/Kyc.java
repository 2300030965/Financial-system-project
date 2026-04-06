package com.klef.fsad.entity;

import com.klef.fsad.enums.KycStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kyc")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kyc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 Link to user (One-to-One)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String documentType;

    private String documentUrl;

    @Enumerated(EnumType.STRING)
    private KycStatus status;

    // 🔥 Default status
    @PrePersist
    public void setDefaultStatus() {
        if (status == null) {
            status = KycStatus.PENDING;
        }
    }
}