package com.cabapp.pro.entity;

    import javax.persistence.*;

    import lombok.*;

    @Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public class Complaint {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer complaintId;
        private String dateOnRegister;
        private String comment;
        private String status;
        private String email;
        private String customerId;
        private String driverId;
    }
