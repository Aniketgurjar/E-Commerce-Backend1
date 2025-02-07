package org.example.novproductservice.Projections;

public interface UserProjections {
    interface BasicInfo {
        String getName();
        String getEmail();
    }

    interface DetailedInfo {
        String getName();
        String getEmail();
        String getAddress();
    }
}

