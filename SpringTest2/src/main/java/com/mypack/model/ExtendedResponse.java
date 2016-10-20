package com.mypack.model;

public class ExtendedResponse {
    private RequestStatus requestStatus;
    private String username;
    private long requestsCount;

    public ExtendedResponse(RequestStatus requestStatus, String username,
                            long requestsCount) {
        this.requestStatus = requestStatus;
        this.username = username;
        this.requestsCount = requestsCount;
    }

    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    public String getUsername() {
        return username;
    }

    public long getRequestsCount() {
        return requestsCount;
    }
}
